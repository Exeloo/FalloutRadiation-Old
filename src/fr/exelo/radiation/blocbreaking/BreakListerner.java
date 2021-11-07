package fr.exelo.radiation.blocbreaking;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.exelo.radiation.Main;
import fr.exelo.radiation.item.Items;

public class BreakListerner implements Listener{

	public BreakListerner(Main main) {}
	
	@EventHandler
	public void onBreak(PlayerInteractEvent event) throws InterruptedException {
			
			Player player = event.getPlayer();
			if (!(player.getGameMode().equals(GameMode.SURVIVAL))) return;
			ItemStack item = event.getItem();
			if (item == null) return;
			if(!(item.isSimilar(Items.Pickaxe3) || item.isSimilar(Items.Pickaxe32) || item.isSimilar(Items.Pickaxe4))) return;
			Block block = event.getClickedBlock();
			
			event.setCancelled(true);
			if (!block.getBlockData().getMaterial().equals(Material.CRACKED_STONE_BRICKS)) {
				player.sendMessage("§6[§eF.Rad§6] §4Vous ne pouvez casser que de la cracked stone brick avec cette pioche");
				return;
			}
			block.setType(Material.AIR);
			if (item.isSimilar(Items.Pickaxe32)) {
				item.setAmount(0);
				player.sendMessage("§6[§eF.Rad§6] §2Oh mince vous avez cassé votre Perceuse 3000");
			}
			else if (item.isSimilar(Items.Pickaxe3)) {
				player.getInventory().setItemInMainHand(Items.Pickaxe32);;
				player.sendMessage("§6[§eF.Rad§6] §2Oh mince vous avez un peu cassé votre Perceuse 3000");
			}
			
			return;
			
	}

}
