package battlebeacons.listenery;

import battlebeacons.Main;
import battlebeacons.tymy.Tymy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakBlockEvent implements Listener {
    private final Main main;
    private final Tymy tymy = new Tymy();

    public PlayerBreakBlockEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void blockPlace(BlockBreakEvent event) {
        if (tymy.hraJede()) {
            var location = event.getBlock().getLocation();
            main.blocksPlacedByPlayers.remove(location);
        }
    }
}
