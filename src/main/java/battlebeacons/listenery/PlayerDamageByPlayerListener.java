package battlebeacons.listenery;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public abstract class PlayerDamageByPlayerListener implements Listener {

    @EventHandler
    public void damage(EntityDamageByEntityEvent event) {
        Entity utocnik = event.getDamager();
        if (!(utocnik instanceof Player) ) return;
        Entity zraneny = event.getEntity();
        if (!(zraneny instanceof  Player)) return;
        playerDamaged((Player) utocnik, (Player) zraneny, event.getFinalDamage(), event);
    }

    public abstract void playerDamaged(Player utocnik, Player zraneny, double damage, EntityDamageByEntityEvent event);
}
