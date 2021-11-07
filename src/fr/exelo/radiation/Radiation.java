package fr.exelo.radiation;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Bukkit;

import java.util.Date;
import java.util.HashMap;

import fr.exelo.radiation.gestionrad.protection.InvProtection;
import fr.exelo.radiation.gestionrad.causes.RainRadiation;
import fr.exelo.radiation.gestionrad.causes.WorldRadiation;
import fr.exelo.radiation.gestionrad.support.WorldGuard;
import fr.exelo.radiation.item.Items;

public class Radiation
{
    public WorldGuard WorldGuard;
    public RainRadiation RainRadiation;
    public InvProtection InvProtection;
    public WorldRadiation WorldRadiation;
    public Main plugin;
    public HashMap<Player, Double> players;
    public HashMap<String, Long> playersEP;
    public boolean paused;
	private HashMap<Player, Boolean> contaminated;
    
    public Radiation(final Main instance) {
        this.WorldGuard = new WorldGuard(this);
        this.RainRadiation = new RainRadiation(this);
        this.InvProtection = new InvProtection(this);
        this.WorldRadiation = new WorldRadiation(this);
        this.players = new HashMap<Player, Double>();
        this.playersEP = new HashMap<String, Long>();
        this.paused = false;
        this.plugin = instance;
        this.contaminated = new HashMap<Player, Boolean>();
        
    }
    
    
    public void runApply() {
        if (!this.paused) {
            for (Player player : Bukkit.getOnlinePlayers()) {
            	if (!this.contaminated.containsKey(player)) {
            		this.contaminated.put(player, false);
            	}
            	
            	if (this.WorldGuard.isInSafeZone(player)) {
            		if (this.contaminated.get(player)) {
            			Location loc = player.getLocation();
            			int Y = loc.getBlockY() - 2;
            			if (player.getWorld().getBlockAt(loc.getBlockX(), Y, loc.getBlockZ()).getType().equals(Material.CAMPFIRE)) {
            				player.sendMessage("§6[§eF.Rad§6] §aVous n'êtes désormais plus contaminé(e)s");
            				this.contaminated.put(player, false);
            			}
            		}
            	}
            	else {
            		if (!this.contaminated.get(player) && (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE))) {
            			this.contaminated.put(player, true);
            			player.sendMessage("§6[§eF.Rad§6] §cVous êtes désormais contaminé(e)s");
            		}
            		
            	}
            	
                if ((player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE) && (!this.WorldGuard.isInSafeZone(player) || this.contaminated.get(player))) {
                    Boolean con = true;
                    if ((this.playersEP.containsKey(player.getName()) && this.playersEP.get(player.getName()) > new Date().getTime())) {
                        con = false;
                    }
                    if (con) {
                        final Double radiation = this.players.get(player);
                        if (radiation != null) {
                        	player.damage(radiation);
                        } else {
                        }
                    } 
                    else {
                    	this.runUpdate(player);
                    }
                }
            }
        }
    }
    
    public void runUpdate(final Player singlePlayer) {
        if (!this.paused) {
            if (singlePlayer == null) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    this.update(player);
                }
            }
            else {
                this.update(singlePlayer);
            }
        }
    }
    
	private void update(final Player player) {

        double rainRadiation = 1;
        double invProtection = 1;
		double worldRadiation = 1;

        rainRadiation = this.RainRadiation.getRainRadiation(player);
        worldRadiation = this.WorldRadiation.getWorldRadiation(player);
        invProtection = this.InvProtection.getInvProtection(player);
        Double radiation;
        radiation = 1.0*rainRadiation*invProtection*worldRadiation;
        this.players.put(player, radiation);
    }
    
	public void eat(final ItemStack item, final Player player) {
		if (item.getItemMeta().getDisplayName().equals(Items.RadX.getItemMeta().getDisplayName())) {
			final Date date = new Date();
			final Long time = date.getTime() + this.plugin.getConfig().getInt("protection.radX")*1000;
			this.playersEP.put(player.getName(), time);
			player.sendMessage("§6[§eF.Rad§6] §bTu as une protection pendant " + this.plugin.getConfig().getInt("protection.radX") + " secondes.");
			return;
		}
		else if (item.getItemMeta().getDisplayName().equals(Items.RadAway.getItemMeta().getDisplayName())) {
			final Date date = new Date();
			final Long time = date.getTime() + this.plugin.getConfig().getInt("protection.radAway")*1000;
			this.playersEP.put(player.getName(), time);
			player.sendMessage("§6[§eF.Rad§6] §bTu as une protection pendant " + this.plugin.getConfig().getInt("protection.radAway") + " secondes.");
			return;
		}
		else {
			return;
		}
    }
	
	public void timeEat(final Player player) {
		if (this.playersEP.containsKey(player.getName())) {
			
			if (this.playersEP.get(player.getName()) > new Date().getTime()) {
				long i = this.playersEP.get(player.getName()) - new Date().getTime();
				player.sendMessage("§6[§eF.Rad§6] §bTu as une protection contre les radiations pendant encore " + String.valueOf(i/1000) + " secondes");
			}
			else {
				player.sendMessage("§6[§eF.Rad§6] §cTu n'as plus de protection contre les radiations");
			}
		}
		else {
			player.sendMessage("§6[§eF.Rad§6] §cTu n'as pas de protection contre les radiations");
		}
	}
}