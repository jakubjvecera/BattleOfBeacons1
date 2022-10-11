package battlebeacons.teleporter;


import battlebeacons.Main;
import battlebeacons.lobby.Lobby;
import battlebeacons.tymy.Tymy;
import org.bukkit.GameMode;
import org.bukkit.Material;

public class TeleportDoLoby {
    private final Lobby lobby;
    private final Tymy tymy;
    private final Main main;


    public TeleportDoLoby(Lobby lobby, Tymy tymy, Main main) {
        this.lobby = lobby;
        this.tymy = tymy;
        this.main = main;
    }

    public void teleport() {
        tymy.vratTymy().forEach( tym -> {
            tym.getHraci().forEach(hrac -> {
                var mistovLoby = lobby.nahodneMistoVLobby();
                hrac.setGameMode(GameMode.ADVENTURE);
                hrac.teleport(mistovLoby);
            });
        });
        main.blocksPlacedByPlayers.forEach(lokace -> {
            if (lokace.getBlock().getType().equals(Material.AIR))return;
            lokace.getBlock().setType(Material.AIR);
        });
    }
}
