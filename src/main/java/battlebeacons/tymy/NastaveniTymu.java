package battlebeacons.tymy;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;

public enum NastaveniTymu {
    REDS("Reds", Color.RED, ChatColor.RED, Material.RED_STAINED_GLASS_PANE),
    BLUES("Blues", Color.BLUE, ChatColor.BLUE, Material.BLUE_STAINED_GLASS_PANE),
    GREENS("Greens", Color.GREEN, ChatColor.GREEN, Material.GREEN_STAINED_GLASS_PANE),
    YELLOWS("Yellows", Color.YELLOW, ChatColor.YELLOW, Material.YELLOW_STAINED_GLASS_PANE);

    private final String jmeno;
    private final Color color;
    private final ChatColor chatColor;
    private final Material beaconGlass;

    NastaveniTymu(String jmeno, Color color, ChatColor chatColor, Material beaconGlass) {
        this.jmeno = jmeno;
        this.color = color;
        this.chatColor = chatColor;
        this.beaconGlass = beaconGlass;
    }

    public Color getColor() {
        return color;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public String getJmeno() {
        return jmeno;
    }

    public Material getBeaconGlass() {
        return beaconGlass;
    }
}
