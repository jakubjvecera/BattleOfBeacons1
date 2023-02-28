package battlebeacons.commands.trader;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;

public class VeciNaProdej {
    public ItemStack enderpearl() {
        var perla = new ItemStack(Material.ENDER_PEARL);
        return perla;
    }

    public ItemStack wool() {
        var wool = new ItemStack(Material.BLACK_WOOL, 16);
        return wool;
    }

    public ItemStack vyrobOcarovaneZlateJablko() {
        return new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
    }

    public ItemStack vyrobLapizLazuli() {
        return new ItemStack(Material.LAPIS_LAZULI);
    }

    public ItemStack vyrobGladiatorSword() {
        var gladiatorSword = new ItemStack(Material.GOLDEN_SWORD, 1);
        var itemMeta = gladiatorSword.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Sword");
        AttributeModifier attributeModifier = new AttributeModifier("Damage", 5, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
        gladiatorSword.setItemMeta(itemMeta);
        return gladiatorSword;
    }

    public ItemStack vyrobStit() {
        var stit = new ItemStack(Material.SHIELD, 1);
        var itemMeta = stit.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Shield");
        stit.setItemMeta(itemMeta);
        return stit;
    }

    public ItemStack vyrobGladiatorChestplate() {
        var gladiatorMaleChestplate = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
        var itemMeta = gladiatorMaleChestplate.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Chestplate");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorMaleChestplate.setItemMeta(itemMeta);
        return gladiatorMaleChestplate;
    }

    public ItemStack vyrobGladiatorHelmet() {
        var gladiatorHelmet = new ItemStack(Material.GOLDEN_HELMET, 1);
        var itemMeta = gladiatorHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Helmet");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorHelmet.setItemMeta(itemMeta);
        return gladiatorHelmet;
    }

    public ItemStack vyrobGladiatorLeggins() {
        var gladiatorHelmet = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
        var itemMeta = gladiatorHelmet.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Legins");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorHelmet.setItemMeta(itemMeta);
        return gladiatorHelmet;
    }

    public ItemStack vyrobGladiatorBoots() {
        var gladiatorBoots = new ItemStack(Material.GOLDEN_BOOTS, 1);
        var itemMeta = gladiatorBoots.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName("Gladiator Boots");
        AttributeModifier attributeModifier = new AttributeModifier("Armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, attributeModifier);
        gladiatorBoots.setItemMeta(itemMeta);
        return gladiatorBoots;
    }
}
