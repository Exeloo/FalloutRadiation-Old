package fr.exelo.radiation.item;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.exelo.radiation.Main;

public class CommandItem {

	private Main main;

	public CommandItem(Main main) {
		this.main = main; 
	}
	public void getCommandItem (Command cmd, CommandSender sender, String lbl, String[] args)  {
		
		
		if (args[1].equalsIgnoreCase("armor") || args[1].equalsIgnoreCase("potion") || args[1].equalsIgnoreCase("pickaxe")) {
	    	if (args.length > 1 && args.length < 4) {
				if (!(sender instanceof Player)) {
	    			sender.sendMessage("§6[§eF.Rad§6] §4Il faut préciser le nom du joueur /rad give <Player> <armor/potion/pickaxe> [lvl]");
	    			return;
	    		} else {
	    			Player player = (Player) sender;
	    			
	    			if (args[1].equalsIgnoreCase("armor")) {
	    				if (args.length == 2) {
	    					player.getInventory().addItem(Items.T45_Helmet);
	        				player.getInventory().addItem(Items.T45_Chestplate);
	        				player.getInventory().addItem(Items.T45_Leggings);
	        				player.getInventory().addItem(Items.T45_Boots);
	        				player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une armure assistée T45");
	        				
	    				} else if (args[2].equalsIgnoreCase("T45")) {
	        				player.getInventory().addItem(Items.T45_Helmet);
	        				player.getInventory().addItem(Items.T45_Chestplate);
	        				player.getInventory().addItem(Items.T45_Leggings);
	        				player.getInventory().addItem(Items.T45_Boots);
	        				player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une armure assistée T45");
	        				
	        			} else if (args[2].equalsIgnoreCase("T51b")) {
	    					player.getInventory().addItem(Items.T51_Helmet);
	        				player.getInventory().addItem(Items.T51_Chestplate);
	        				player.getInventory().addItem(Items.T51_Leggings);
	        				player.getInventory().addItem(Items.T51_Boots);
	        				player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une armure assistée T51");
	        				
	    				} else if (args[2].equalsIgnoreCase("X-01")) {
	        				player.getInventory().addItem(Items.X01_Helmet);
	        				player.getInventory().addItem(Items.X01_Chestplate);
	        				player.getInventory().addItem(Items.X01_Leggings);
	        				player.getInventory().addItem(Items.X01_Boots);
	        				player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une armure assistée X-01");
	        				
	    				} else if (args[2].equalsIgnoreCase("X-02")) {
	        				player.getInventory().addItem(Items.X02_Helmet);
	        				player.getInventory().addItem(Items.X02_Chestplate);
	        				player.getInventory().addItem(Items.X02_Leggings);
	        				player.getInventory().addItem(Items.X02_Boots);
	        				player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une armure assistée X-02");
	        				
	    				} else 
	    					player.sendMessage("§6[§eF.Rad§6] §4Il n'y a pas ce niveau d'armure");
	    				
	    			} else if (args[1].equalsIgnoreCase("potion")){
	    				if (args.length == 2) {
	    					player.getInventory().addItem(Items.RadX);
	    					player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner un RadX, il vous protège des radiations");
	    				}    				
	    				else if (args[2].equalsIgnoreCase("radX")) {
	    					player.getInventory().addItem(Items.RadX);
	    					player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner un RadX, il vous protège des radiations");
	    				}
	        			
	    				else if (args[2].equalsIgnoreCase("radAway")) {
	    					player.getInventory().addItem(Items.RadAway);
	    					player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner un RadAway, il vous protège des radiations");
	    				}
	    	
	    				else 
	    					player.sendMessage("§6[§eF.Rad§6] §4Il n'y a pas ce niveau de potion");
	    		
	    			} else if (args[1].equalsIgnoreCase("pickaxe")){
	    				if (args.length == 2) {
	    					player.getInventory().addItem(Items.Pickaxe3);
	    					player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une Perceuse 3000");
	    				}
	    				
	    				else if (args[2].equalsIgnoreCase("Perceuse3000")) {
	    					player.getInventory().addItem(Items.Pickaxe3);
	    					player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une Perceuse 3000");
	    				}
	    				
	    				else if (args[2].equalsIgnoreCase("Perceuse4000")) {
	    					player.getInventory().addItem(Items.Pickaxe4);
	    					player.sendMessage("§6[§eF.Rad§6] §2Vous venez de vous donner une Perceuse 4000");
	    				}
	    				else 
	    					player.sendMessage("§6[§eF.Rad§6] §4Il n'y a pas ce niveau de pioche");
	    			} else player.sendMessage("§6[§eF.Rad§6] §4Il faut choisir l'item : /rad give [Player] <armor/potion/pickaxe> [lvl]");
	    			return;
	    		} 
	    	}
    	} else {
    		if (args.length > 2 && args.length < 5) {
	    		for (Player player : main.getServer().getOnlinePlayers()) {
	    			if (args[1].equals(player.getName())) {
	    				if (args[2].equalsIgnoreCase("armor")) {
	        				if (args.length == 3) {
	        					player.getInventory().addItem(Items.T45_Helmet);
	            				player.getInventory().addItem(Items.T45_Chestplate);
	            				player.getInventory().addItem(Items.T45_Leggings);
	            				player.getInventory().addItem(Items.T45_Boots);
	            				player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Armure Assistée T45");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une Armure Assistée T45 à " + player.getName());
	            				
	        				} else if (args[3].equalsIgnoreCase("T45")) {
	            				player.getInventory().addItem(Items.T45_Helmet);
	            				player.getInventory().addItem(Items.T45_Chestplate);
	            				player.getInventory().addItem(Items.T45_Leggings);
	            				player.getInventory().addItem(Items.T45_Boots);
	            				player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Armure Assistée T45");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une  Armure Assistée T45 à " + player.getName());
	            				
	            			} else if (args[3].equalsIgnoreCase("T51b")) {
	        					player.getInventory().addItem(Items.T51_Helmet);
	            				player.getInventory().addItem(Items.T51_Chestplate);
	            				player.getInventory().addItem(Items.T51_Leggings);
	            				player.getInventory().addItem(Items.T51_Boots);
	            				player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Armure Assistée T51b");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une Armure Assistée T51b à " + player.getName());
	            				
	        				} else if (args[3].equalsIgnoreCase("X-01")) {
	            				player.getInventory().addItem(Items.X01_Helmet);
	            				player.getInventory().addItem(Items.X01_Chestplate);
	            				player.getInventory().addItem(Items.X01_Leggings);
	            				player.getInventory().addItem(Items.X01_Boots);
	            				player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Armure Assistée X-01");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une Armure Assistée X-01 à " + player.getName());
	            				
	        				} else if (args[3].equalsIgnoreCase("X-02")) {
		            			player.getInventory().addItem(Items.X02_Helmet);
		            			player.getInventory().addItem(Items.X02_Chestplate);
		            			player.getInventory().addItem(Items.X02_Leggings);
		            			player.getInventory().addItem(Items.X02_Boots);
		            			player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Armure Assistée X-02");
		            			sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une Armure Assistée X-02 à " + player.getName());
	        				} else 
	        					player.sendMessage("§6[§eF.Rad§6] §4Il n'y a pas ce niveau d'armure");
	        				
	        			} else if (args[2].equalsIgnoreCase("potion")){
	        				if (args.length == 3) {
	        					player.getInventory().addItem(Items.RadX);
	        					player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné un RadX");
	        					sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner un RadX à " + player.getName());
	        					
	        					} else if (args[3].equalsIgnoreCase("radX")) {
	        					player.getInventory().addItem(Items.RadX);
	        					player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné un RadX");
	        					sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner un RadX à " + player.getName());
	        					
	        					} else if (args[3].equalsIgnoreCase("radAway")) {
	        					player.getInventory().addItem(Items.RadAway);
	        					player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné un RadAway");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner un RadAway à " + player.getName());
	        					} else {
	        					player.sendMessage("§6[§eF.Rad§6] §4Il n'y a pas ce niveau de potion");
	        					}
	        			} else if (args[2].equalsIgnoreCase("pickaxe")) {
	        				if (args.length == 3) {
	        					player.getInventory().addItem(Items.Pickaxe3);
	        					player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Perceuse 3000");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une Perceuse 3000 à " + player.getName());
	        				
	        				} else if (args[3].equalsIgnoreCase("Perceuse3000")) {
	        					player.getInventory().addItem(Items.Pickaxe3);
	        					player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Perceuse 3000");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une Perceuse 3000 à " + player.getName());
	        				
	        				} else if (args[3].equalsIgnoreCase("Perceuse4000")) {
	        					player.getInventory().addItem(Items.Pickaxe4);
	        					player.sendMessage("§6[§eF.Rad§6] §2" + sender.getName() + " vous a donné une Perceuse 4000");
	            				sender.sendMessage("§6[§eF.Rad§6] §2Vous venez de donner une Perceuse 4000 à " + player.getName());
	        				
	        				} else {
	        					player.sendMessage("§6[§eF.Rad§6] §4Il n'y a pas ce niveau de pioche");
	        					
	        					
	        				}
	        			} else player.sendMessage("§6[§eF.Rad§6] §4Il faut choisir l'item : /rad give [Player] <armor/potion/pickaxe> [lvl]");
	    				return;
    				}
    			} sender.sendMessage("§6[§eF.Rad§6] §4Le joueur que vous avez selectionné n'est pas connecté");

    		} else return;
    	}
		return;
	}
	

}
