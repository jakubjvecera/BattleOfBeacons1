package battlebeacons.listenery;

import battlebeacons.tymy.Tymy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnHrace implements Listener {
    private final Tymy tymy;

    public RespawnHrace(Tymy tymy) {
        this.tymy = tymy;
    }

    @EventHandler
    public void respawnHrace(PlayerRespawnEvent event) {
        if (!tymy.hraJede()) return;

        var player = event.getPlayer();
        var tym = tymy.vratTym(player);
        player.teleport(tym.getSpawnPoint());
        event.setRespawnLocation(tym.getSpawnPoint());
    }
}
