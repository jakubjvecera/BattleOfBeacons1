package battlebeacons.listenery;

import battlebeacons.Main;
import battlebeacons.tymy.Tymy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceBlockEvent implements Listener {
    private final Main main;
    private final Tymy tymy = new Tymy();

    public PlayerPlaceBlockEvent(Main main) {
        this.main = main;
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent event) {
        if (tymy.hraJede()) {
            var location = event.getBlockPlaced().getLocation();
            main.blocksPlacedByPlayers.add(location);
        }
    }
}
