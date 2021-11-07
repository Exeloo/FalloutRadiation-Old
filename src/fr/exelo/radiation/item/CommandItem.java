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
	    			sender.sendMessage("�6[�eF.Rad�6] �4Il faut pr�ciser le nom du joueur /rad give <Player> <armor/potion/pickaxe> [lvl]");
	    			return;
	    		} else {
	    			Player player = (Player) sender;
	    			
	    			if (args[1].equalsIgnoreCase("armor")) {
	    				if (args.length == 2) {
	    					player.getInventory().addItem(Items.T45_Helmet);
	        				player.getInventory().addItem(Items.T45_Chestplate);
	        				player.getInventory().addItem(Items.T45_Leggings);
	        				player.getInventory().addItem(Items.T45_Boots);
	        				player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une armure assist�e T45");
	        				
	    				} else if (args[2].equalsIgnoreCase("T45")) {
	        				player.getInventory().addItem(Items.T45_Helmet);
	        				player.getInventory().addItem(Items.T45_Chestplate);
	        				player.getInventory().addItem(Items.T45_Leggings);
	        				player.getInventory().addItem(Items.T45_Boots);
	        				player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une armure assist�e T45");
	        				
	        			} else if (args[2].equalsIgnoreCase("T51b")) {
	    					player.getInventory().addItem(Items.T51_Helmet);
	        				player.getInventory().addItem(Items.T51_Chestplate);
	        				player.getInventory().addItem(Items.T51_Leggings);
	        				player.getInventory().addItem(Items.T51_Boots);
	        				player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une armure assist�e T51");
	        				
	    				} else if (args[2].equalsIgnoreCase("X-01")) {
	        				player.getInventory().addItem(Items.X01_Helmet);
	        				player.getInventory().addItem(Items.X01_Chestplate);
	        				player.getInventory().addItem(Items.X01_Leggings);
	        				player.getInventory().addItem(Items.X01_Boots);
	        				player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une armure assist�e X-01");
	        				
	    				} else if (args[2].equalsIgnoreCase("X-02")) {
	        				player.getInventory().addItem(Items.X02_Helmet);
	        				player.getInventory().addItem(Items.X02_Chestplate);
	        				player.getInventory().addItem(Items.X02_Leggings);
	        				player.getInventory().addItem(Items.X02_Boots);
	        				player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une armure assist�e X-02");
	        				
	    				} else 
	    					player.sendMessage("�6[�eF.Rad�6] �4Il n'y a pas ce niveau d'armure");
	    				
	    			} else if (args[1].equalsIgnoreCase("potion")){
	    				if (args.length == 2) {
	    					player.getInventory().addItem(Items.RadX);
	    					player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner un RadX, il vous prot�ge des radiations");
	    				}    				
	    				else if (args[2].equalsIgnoreCase("radX")) {
	    					player.getInventory().addItem(Items.RadX);
	    					player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner un RadX, il vous prot�ge des radiations");
	    				}
	        			
	    				else if (args[2].equalsIgnoreCase("radAway")) {
	    					player.getInventory().addItem(Items.RadAway);
	    					player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner un RadAway, il vous prot�ge des radiations");
	    				}
	    	
	    				else 
	    					player.sendMessage("�6[�eF.Rad�6] �4Il n'y a pas ce niveau de potion");
	    		
	    			} else if (args[1].equalsIgnoreCase("pickaxe")){
	    				if (args.length == 2) {
	    					player.getInventory().addItem(Items.Pickaxe3);
	    					player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une Perceuse 3000");
	    				}
	    				
	    				else if (args[2].equalsIgnoreCase("Perceuse3000")) {
	    					player.getInventory().addItem(Items.Pickaxe3);
	    					player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une Perceuse 3000");
	    				}
	    				
	    				else if (args[2].equalsIgnoreCase("Perceuse4000")) {
	    					player.getInventory().addItem(Items.Pickaxe4);
	    					player.sendMessage("�6[�eF.Rad�6] �2Vous venez de vous donner une Perceuse 4000");
	    				}
	    				else 
	    					player.sendMessage("�6[�eF.Rad�6] �4Il n'y a pas ce niveau de pioche");
	    			} else player.sendMessage("�6[�eF.Rad�6] �4Il faut choisir l'item : /rad give [Player] <armor/potion/pickaxe> [lvl]");
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
	            				player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Armure Assist�e T45");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une Armure Assist�e T45 � " + player.getName());
	            				
	        				} else if (args[3].equalsIgnoreCase("T45")) {
	            				player.getInventory().addItem(Items.T45_Helmet);
	            				player.getInventory().addItem(Items.T45_Chestplate);
	            				player.getInventory().addItem(Items.T45_Leggings);
	            				player.getInventory().addItem(Items.T45_Boots);
	            				player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Armure Assist�e T45");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une  Armure Assist�e T45 � " + player.getName());
	            				
	            			} else if (args[3].equalsIgnoreCase("T51b")) {
	        					player.getInventory().addItem(Items.T51_Helmet);
	            				player.getInventory().addItem(Items.T51_Chestplate);
	            				player.getInventory().addItem(Items.T51_Leggings);
	            				player.getInventory().addItem(Items.T51_Boots);
	            				player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Armure Assist�e T51b");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une Armure Assist�e T51b � " + player.getName());
	            				
	        				} else if (args[3].equalsIgnoreCase("X-01")) {
	            				player.getInventory().addItem(Items.X01_Helmet);
	            				player.getInventory().addItem(Items.X01_Chestplate);
	            				player.getInventory().addItem(Items.X01_Leggings);
	            				player.getInventory().addItem(Items.X01_Boots);
	            				player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Armure Assist�e X-01");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une Armure Assist�e X-01 � " + player.getName());
	            				
	        				} else if (args[3].equalsIgnoreCase("X-02")) {
		            			player.getInventory().addItem(Items.X02_Helmet);
		            			player.getInventory().addItem(Items.X02_Chestplate);
		            			player.getInventory().addItem(Items.X02_Leggings);
		            			player.getInventory().addItem(Items.X02_Boots);
		            			player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Armure Assist�e X-02");
		            			sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une Armure Assist�e X-02 � " + player.getName());
	        				} else 
	        					player.sendMessage("�6[�eF.Rad�6] �4Il n'y a pas ce niveau d'armure");
	        				
	        			} else if (args[2].equalsIgnoreCase("potion")){
	        				if (args.length == 3) {
	        					player.getInventory().addItem(Items.RadX);
	        					player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� un RadX");
	        					sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner un RadX � " + player.getName());
	        					
	        					} else if (args[3].equalsIgnoreCase("radX")) {
	        					player.getInventory().addItem(Items.RadX);
	        					player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� un RadX");
	        					sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner un RadX � " + player.getName());
	        					
	        					} else if (args[3].equalsIgnoreCase("radAway")) {
	        					player.getInventory().addItem(Items.RadAway);
	        					player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� un RadAway");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner un RadAway � " + player.getName());
	        					} else {
	        					player.sendMessage("�6[�eF.Rad�6] �4Il n'y a pas ce niveau de potion");
	        					}
	        			} else if (args[2].equalsIgnoreCase("pickaxe")) {
	        				if (args.length == 3) {
	        					player.getInventory().addItem(Items.Pickaxe3);
	        					player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Perceuse 3000");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une Perceuse 3000 � " + player.getName());
	        				
	        				} else if (args[3].equalsIgnoreCase("Perceuse3000")) {
	        					player.getInventory().addItem(Items.Pickaxe3);
	        					player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Perceuse 3000");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une Perceuse 3000 � " + player.getName());
	        				
	        				} else if (args[3].equalsIgnoreCase("Perceuse4000")) {
	        					player.getInventory().addItem(Items.Pickaxe4);
	        					player.sendMessage("�6[�eF.Rad�6] �2" + sender.getName() + " vous a donn� une Perceuse 4000");
	            				sender.sendMessage("�6[�eF.Rad�6] �2Vous venez de donner une Perceuse 4000 � " + player.getName());
	        				
	        				} else {
	        					player.sendMessage("�6[�eF.Rad�6] �4Il n'y a pas ce niveau de pioche");
	        					
	        					
	        				}
	        			} else player.sendMessage("�6[�eF.Rad�6] �4Il faut choisir l'item : /rad give [Player] <armor/potion/pickaxe> [lvl]");
	    				return;
    				}
    			} sender.sendMessage("�6[�eF.Rad�6] �4Le joueur que vous avez selectionn� n'est pas connect�");

    		} else return;
    	}
		return;
	}
	

}
