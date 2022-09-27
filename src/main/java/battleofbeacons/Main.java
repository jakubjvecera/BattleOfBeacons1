package battlebeacons;

import battlebeacons.tymy.Skore;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;
import battlebeacons.commands.KonecHry;
import battlebeacons.commands.VytvorTeleportera;
import battlebeacons.listenery.*;
import battlebeacons.lobby.Lobby;
import battlebeacons.lobby.LobbyCreator;
import battlebeacons.teleporter.TeleportDoAreny;
import battlebeacons.teleporter.TeleportDoLoby;
import battlebeacons.tymy.Tymy;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Bukkit.setDefaultGameMode(GameMode.ADVENTURE);
        //data
        LobbyCreator lobbyCreator = new LobbyCreator(this);
        Lobby lobby = lobbyCreator.createLobby();
        Tymy tymy = new Tymy();
        TeleportDoAreny teleportDoAreny = new TeleportDoAreny(this, lobby, tymy);
        TeleportDoLoby teleportDoLoby = new TeleportDoLoby(lobby, tymy);
        Skore skore = new Skore(tymy);

        //listeners
        getServer().getPluginManager().registerEvents(new battlebeacons.listenery.PripojeniDoLobby(lobby), this);
        getServer().getPluginManager().registerEvents(new battlebeacons.listenery.StartHry(teleportDoAreny, skore), this);
        getServer().getPluginManager().registerEvents(new battlebeacons.listenery.ZraneniHrace(tymy, teleportDoLoby), this);
        getServer().getPluginManager().registerEvents(new battlebeacons.listenery.OdpocetZakazPohybu(tymy, teleportDoAreny), this);
        getServer().getPluginManager().registerEvents(new battlebeacons.listenery.RespawnHrace(tymy), this);
        getServer().getPluginManager().registerEvents(new battlebeacons.listenery.SmrtHrace(tymy, skore, teleportDoLoby), this);
        getServer().getPluginManager().registerEvents(new battlebeacons.listenery.BeaconZnicen(tymy), this);

        //commandy
        getCommand("+vytvorTeleportera").setExecutor(new VytvorTeleportera());
        getCommand("+konec").setExecutor(new KonecHry(teleportDoLoby, tymy));
    }
    // Halo idk programování

}
