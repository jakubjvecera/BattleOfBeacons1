package battlebeacons.listenery;

import battlebeacons.tymy.Tym;
import battlebeacons.tymy.Tymy;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BeaconZnicen implements Listener {
    private final Tymy tymy;

    public BeaconZnicen(Tymy tymy) {
        this.tymy = tymy;
    }
    @EventHandler
    public void beaconZnicen(BlockBreakEvent event) {
        if (!tymy.hraJede()) return;
        if (event.getBlock().getType() != Material.BEACON ) return;
        Location location = event.getBlock().getLocation();
        for (var tym : tymy.vratTymy()) {
            if (tym.getBeaconPoint().equals(location)) {
                tym.setAlive(false);
                tym.zprava("Vas beacon byl znicen.", "Uz se nesnazte.");
                return;
            }
        }
    }
}
