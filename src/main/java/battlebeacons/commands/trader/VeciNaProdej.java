package battlebeacons.commands.trader;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class VeciNaProdej {
    public ItemStack enderpearl(){
        var perla = new ItemStack(Material.ENDER_PEARL);
        return perla;
    }
    public ItemStack wool(){
        var wool = new ItemStack(Material.BLACK_WOOL,16);
        return wool;
    }
}
