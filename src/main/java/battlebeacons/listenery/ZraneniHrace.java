package battlebeacons.listenery;


import battlebeacons.teleporter.TeleportDoLoby;
import battlebeacons.tymy.Tymy;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ZraneniHrace extends battlebeacons.listenery.PlayerDamageByPlayerListener {

    private final Tymy tymy;

    public final TeleportDoLoby teleportDoLoby;

    public ZraneniHrace(Tymy tymy, TeleportDoLoby teleportDoLoby) {
        this.tymy = tymy;
        this.teleportDoLoby = teleportDoLoby;
    }

    @Override
    public void playerDamaged(Player utocnik, Player zraneny, double damage, EntityDamageByEntityEvent event) {
        if (!tymy.hraJede()) return;
        if (tymy.spoluhraci(utocnik, zraneny)) event.setCancelled(true);
    }
}
