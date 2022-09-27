package battlebeacons.factory;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Weapons {

    public ItemStack sword() {
        var mec = new ItemStack(Material.IRON_SWORD, 1);
        return mec;
    }

    public ItemStack shield() {
        var stit = new ItemStack(Material.SHIELD, 1);
        return stit;
    }

    public ItemStack bow() {
        var luk = new ItemStack(Material.BOW, 1);
        luk.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        return luk;
    }

    public ItemStack arrow() {
        var sip = new ItemStack(Material.ARROW, 1);
        return sip;
    }
}
