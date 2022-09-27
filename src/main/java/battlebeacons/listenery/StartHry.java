package battlebeacons.listenery;


import battlebeacons.teleporter.TeleportDoAreny;
import battlebeacons.tymy.Skore;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class StartHry implements Listener {

    private final TeleportDoAreny teleport;
    private final Skore skore;

    public StartHry(TeleportDoAreny teleport, Skore skore) {
        this.teleport = teleport;
        this.skore = skore;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if (!player.isOp()) return;

        Entity entity = event.getEntity();
        if (TeleportDoAreny.JMENO_TELEPORTERA.equals(entity.getCustomName())) {
            teleport.teleportPriStartuHry();
            skore.inicializace();
        }
        event.setCancelled(true);
    }
}