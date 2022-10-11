package battlebeacons.listenery;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageByPlayerInLobbyToTeleporter implements Listener {


    @EventHandler
    public void damageByPlayerInLobbyToTeleporter(EntityDamageByEntityEvent event){
        Entity utocnik = event.getDamager();
        if (!(utocnik instanceof Player) ) return;
        Entity zraneny = event.getEntity();
        if (!(zraneny instanceof  Villager)) return;
        Villager villager = (Villager) zraneny;

        if (villager.getName().equals("Team Battle Teleporter")){
            villager.addPotionEffect(new PotionEffect(PotionEffectType.HEAL,5,255));
        }
    }
}
