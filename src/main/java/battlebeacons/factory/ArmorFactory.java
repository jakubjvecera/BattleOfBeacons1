package battlebeacons.factory;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public final class ArmorFactory {

    private final Color color;

    public ArmorFactory(Color color) {
        this.color = color;
    }

    public ItemStack chestplate() {
        var chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chestplate.addEnchantment(Enchantment.BINDING_CURSE, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) chestplate.getItemMeta();
        meta.setColor(color);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    public ItemStack helmet() {
        var helmet = new ItemStack(Material.LEATHER_HELMET, 1);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        helmet.addEnchantment(Enchantment.BINDING_CURSE, 1);
        return helmet;
    }

    public ItemStack leggins() {
        var leggins = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        leggins.addEnchantment(Enchantment.THORNS, 2);
        leggins.addEnchantment(Enchantment.BINDING_CURSE, 1);
        return leggins;
    }

    public ItemStack boots() {
        var boots = new ItemStack(Material.IRON_BOOTS, 1);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.addEnchantment(Enchantment.THORNS, 2);
        boots.addEnchantment(Enchantment.BINDING_CURSE, 1);
        return boots;
    }
}
