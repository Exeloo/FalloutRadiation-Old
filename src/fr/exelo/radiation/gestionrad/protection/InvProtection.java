package fr.exelo.radiation.gestionrad.protection;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import fr.exelo.radiation.Radiation;
import fr.exelo.radiation.item.Items;

public class InvProtection {
    
    public InvProtection(final Radiation instance) {
    }
    
    public double getInvProtection(final Player player) {
        final PlayerInventory inv = player.getInventory();
        if (inv.getHelmet() == null || inv.getChestplate() == null || inv.getLeggings() == null || inv.getBoots() == null) return 1;
        else if(inv.getHelmet().getItemMeta().getDisplayName().equals(Items.T45_Helmet.getItemMeta().getDisplayName()) && 
        		inv.getChestplate().getItemMeta().getDisplayName().equals(Items.T45_Chestplate.getItemMeta().getDisplayName()) && 
        		inv.getLeggings().getItemMeta().getDisplayName().equals(Items.T45_Leggings.getItemMeta().getDisplayName()) && 
        		inv.getBoots().getItemMeta().getDisplayName().equals(Items.T45_Boots.getItemMeta().getDisplayName())) 
        	return 0.5;
        else if(inv.getHelmet().getItemMeta().getDisplayName().equals(Items.T51_Helmet.getItemMeta().getDisplayName()) && 
        		inv.getChestplate().getItemMeta().getDisplayName().equals(Items.T51_Chestplate.getItemMeta().getDisplayName()) && 
        		inv.getLeggings().getItemMeta().getDisplayName().equals(Items.T51_Leggings.getItemMeta().getDisplayName()) && 
        		inv.getBoots().getItemMeta().getDisplayName().equals(Items.T51_Boots.getItemMeta().getDisplayName())) 
        	return 0.25;
        else if(inv.getHelmet().getItemMeta().getDisplayName().equals(Items.X01_Helmet.getItemMeta().getDisplayName()) && 
        		inv.getChestplate().getItemMeta().getDisplayName().equals(Items.X01_Chestplate.getItemMeta().getDisplayName()) && 
        		inv.getLeggings().getItemMeta().getDisplayName().equals(Items.X01_Leggings.getItemMeta().getDisplayName()) && 
        		inv.getBoots().getItemMeta().getDisplayName().equals(Items.X01_Boots.getItemMeta().getDisplayName())) 
        	return 0.0625;
        else if(inv.getHelmet().getItemMeta().getDisplayName().equals(Items.X02_Helmet.getItemMeta().getDisplayName()) && 
        		inv.getChestplate().getItemMeta().getDisplayName().equals(Items.X02_Chestplate.getItemMeta().getDisplayName()) && 
        		inv.getLeggings().getItemMeta().getDisplayName().equals(Items.X02_Leggings.getItemMeta().getDisplayName()) && 
        		inv.getBoots().getItemMeta().getDisplayName().equals(Items.X02_Boots.getItemMeta().getDisplayName())) 
        	return 0;
        else return 1.0;
    }
}

