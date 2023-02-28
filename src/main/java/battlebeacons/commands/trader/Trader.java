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

        //veci pro obchodovani
        MerchantRecipe enderPearl = new MerchantRecipe(veciNaProdej.enderpearl(), 999);
        enderPearl.addIngredient(new ItemStack(Material.EMERALD, 3));

        MerchantRecipe wool = new MerchantRecipe(veciNaProdej.wool(), 999);
        wool.addIngredient(new ItemStack(Material.IRON_INGOT, 4));

        MerchantRecipe gladiatorSword = new MerchantRecipe(veciNaProdej.vyrobGladiatorSword(), 999);
        gladiatorSword.addIngredient(new ItemStack(Material.GOLD_NUGGET, 5));

        MerchantRecipe gladiatorShield = new MerchantRecipe(veciNaProdej.vyrobStit(), 999);
        gladiatorShield.addIngredient(new ItemStack(Material.GOLD_NUGGET, 7));

        MerchantRecipe gladiatorHelmet = new MerchantRecipe(veciNaProdej.vyrobGladiatorHelmet(), 999);
        gladiatorHelmet.addIngredient(new ItemStack(Material.GOLD_NUGGET, 3));

        MerchantRecipe gladiatorChestplate = new MerchantRecipe(veciNaProdej.vyrobGladiatorChestplate(), 999);
        gladiatorChestplate.addIngredient(new ItemStack(Material.GOLD_NUGGET, 3));

        MerchantRecipe gladiatorLeggings = new MerchantRecipe(veciNaProdej.vyrobGladiatorLeggins(), 999);
        gladiatorLeggings.addIngredient(new ItemStack(Material.GOLD_NUGGET, 3));

        MerchantRecipe gladiatorBoots = new MerchantRecipe(veciNaProdej.vyrobGladiatorSword(), 999);
        gladiatorBoots.addIngredient(new ItemStack(Material.GOLD_NUGGET, 3));

        trader.setRecipes(Lists.newArrayList(enderPearl, wool, gladiatorBoots, gladiatorChestplate, gladiatorHelmet, gladiatorLeggings,
                gladiatorSword, gladiatorShield));

        return true;
    }
}
//aj
