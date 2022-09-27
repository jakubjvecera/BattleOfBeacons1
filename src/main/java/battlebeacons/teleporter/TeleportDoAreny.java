package battlebeacons.teleporter;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import battlebeacons.lobby.Lobby;
import battlebeacons.tymy.Tym;
import battlebeacons.tymy.Tymy;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public final class TeleportDoAreny {

    private static final String TEAM_LOCATION_CONFIG_KEY = "TeamBattleLocation_";
    private static final String BEACON_LOCATION_CONFIG_KEY = "BeaconLocation_";
    public static final String JMENO_TELEPORTERA = "Team Battle Teleporter";

    private final Plugin plugin;
    private final Lobby lobby;
    private final Tymy tymy;
    private battlebeacons.teleporter.Odpocet odpocet = null;

    public TeleportDoAreny(Plugin plugin, Lobby lobby, Tymy tymy) {
        this.plugin = plugin;
        this.lobby = lobby;
        this.tymy = tymy;
    }

    public void teleportPriStartuHry() {
        List<Player> lobbyPlayers = lobby.hraciVLobby();
        List<Location> spawnPointy = nactiPointy(PointType.SPAWN);
        List<Location> beaconPointy = nactiPointy(PointType.BEACON);
        tymy.vytvorTymy(lobbyPlayers, spawnPointy, beaconPointy);
        for (int i = 0; i < tymy.pocet(); i++) {
            Tym tym = tymy.vratTym(i);
            vytvorBeacon(tym);
            for (Player player : tym.getHraci()) {
                player.teleport(tym.getSpawnPoint());
                player.setBedSpawnLocation(tym.getSpawnPoint());
            }
        }
        odpocet(lobbyPlayers);
    }

    private void vytvorBeacon(Tym team) {
        Block beaconBlock = team.getBeaconPoint().getBlock();
        beaconBlock.setType(Material.BEACON);
        Block glassBlock = team.getBeaconPoint().clone().add(0,1,0).getBlock();
        glassBlock.setType(team.getNastaveniTymu().getBeaconGlass());
    }

    private enum PointType {
        SPAWN, BEACON
    }

    private String getConfigKey(PointType pointType, int teamNumber) {
        return switch (pointType) {
            case SPAWN -> TEAM_LOCATION_CONFIG_KEY + teamNumber;
            case BEACON -> BEACON_LOCATION_CONFIG_KEY + teamNumber;
        };
    }

    private List<Location> nactiPointy(PointType pointType) {
        List<Location> mista = new ArrayList<>();
        var i = 1;
        Location location;
        while ((location = plugin.getConfig().getLocation(getConfigKey(pointType, i++))) != null) {
            mista.add(location);
        }
        if (mista.size() == 0) {
            plugin.getLogger().log(Level.CONFIG, "Nenactena spawnovaci mista z configu pro team battle.");
        } else {
            plugin.getLogger().log(Level.CONFIG, "Pocet spawnovacich mist pro team battle:  " + mista.size());
        }
        return mista;
    }

    public boolean jeOdpocet() {
        if (odpocet == null) return false;
        return odpocet.jeOdpocet();
    }

    private void odpocet(List<Player> hraci) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        odpocet = new battlebeacons.teleporter.Odpocet(hraci);
        executorService.submit(odpocet);
    }

}
