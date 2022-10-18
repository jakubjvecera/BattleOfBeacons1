package battlebeacons.commands.trader;

import com.google.common.collect.Lists;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Trader implements CommandExecutor {
    private final VeciNaProdej veciNaProdej;

    public static final String JMENO_OBCHODNIKA = "TRADER";

    public Trader(VeciNaProdej veciNaProdej) {
        this.veciNaProdej = veciNaProdej;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        var player = (Player) sender;

        var trader = (WanderingTrader) player.getWorld().spawnEntity(player.getLocation(), EntityType.WANDERING_TRADER);
        trader.setAI(false);
        trader.setCustomName(JMENO_OBCHODNIKA);
        trader.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 999999999, true));

        MerchantRecipe enderPearl = new MerchantRecipe(veciNaProdej.enderpearl(), 1);
        enderPearl.addIngredient(new ItemStack(Material.EMERALD, 3));

        MerchantRecipe wool = new MerchantRecipe(veciNaProdej.wool(), 1);
        wool.addIngredient(new ItemStack(Material.IRON_INGOT, 4));


        trader.setRecipes(Lists.newArrayList(enderPearl,wool));

        return true;
    }
}//aj