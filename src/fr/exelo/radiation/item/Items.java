package fr.exelo.radiation.item;

import java.util.Collections;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Items {
	
	public static final ItemStack T45_Helmet, T45_Chestplate, T45_Leggings, T45_Boots, 
	T51_Helmet, T51_Chestplate, T51_Leggings, T51_Boots, 
	X01_Helmet, X01_Chestplate, X01_Leggings, X01_Boots, 
	X02_Helmet, X02_Chestplate, X02_Leggings, X02_Boots, 
	RadX, RadAway, Pickaxe3, Pickaxe32, Pickaxe4;

    static {
        T45_Helmet = getItemArmor(Material.LEATHER_HELMET, "§1Casque de T45", "", Color.BLUE);
        T45_Chestplate = getItemArmor(Material.LEATHER_CHESTPLATE, "§1Plastron de T45", "", Color.BLUE);
        T45_Leggings = getItemArmor(Material.LEATHER_LEGGINGS, "§1Jambières de T45", "", Color.BLUE);
        T45_Boots = getItemArmor(Material.LEATHER_BOOTS, "§1Bottes de T45", "", Color.BLUE);
        T51_Helmet = getItem(Material.IRON_HELMET, "§2Casque de T51b", "");
        T51_Chestplate = getItem(Material.IRON_CHESTPLATE, "§2Plastron de T51b", "");
        T51_Leggings = getItem(Material.IRON_LEGGINGS, "§2Jambières de T51b", "");
        T51_Boots = getItem(Material.IRON_BOOTS, "§2Bottes de T51b", "");
        X01_Helmet = getItem(Material.DIAMOND_HELMET, "§eCasque de X-01", "");
        X01_Chestplate = getItem(Material.DIAMOND_CHESTPLATE, "§ePlastron de X-01", "");
        X01_Leggings = getItem(Material.DIAMOND_LEGGINGS, "§eJambières de X-01", "");
        X01_Boots = getItem(Material.DIAMOND_BOOTS, "§eBottes de X-01", "");
        X02_Helmet = getItem(Material.NETHERITE_HELMET, "§eCasque de X-02", "");
        X02_Chestplate = getItem(Material.NETHERITE_CHESTPLATE, "§ePlastron de X-02", "");
        X02_Leggings = getItem(Material.NETHERITE_LEGGINGS, "§eJambières de X-02", "");
        X02_Boots = getItem(Material.NETHERITE_BOOTS, "§eBottes de X-02", "");
        RadX = getItem(Material.POTION, "§4RadX", "");
        RadAway = getItem(Material.POTION, "§5RadAway", "");
        Pickaxe3 = getItem(Material.DIAMOND_PICKAXE, "§aPerceuse 3000", "");
        Pickaxe32 = getItem(Material.DIAMOND_PICKAXE, "§aPerceuse 3000 un peu cassé", "");
        Pickaxe4 = getItem(Material.NETHERITE_PICKAXE, "§aPerceuse 4000", "");
    }
    public static ItemStack getItem (Material Material, String Name, String Lore) {
    	ItemStack item = new ItemStack(Material);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(Name);
        meta.setLore(Collections.singletonList(Lore));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack getItemArmor (Material Material, String Name, String Lore, Color color) {
    	ItemStack item = new ItemStack(Material);
    	LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
    	meta.setDisplayName(Name);
    	meta.setColor(color);
    	meta.setLore(Collections.singletonList(Lore));
    	meta.setUnbreakable(true);
    	item.setItemMeta(meta);
    	return item;
    }

}
