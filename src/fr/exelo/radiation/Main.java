package fr.exelo.radiation;

import org.bukkit.plugin.java.JavaPlugin;

import fr.exelo.radiation.blocbreaking.BreakListerner;
import fr.exelo.radiation.item.CommandItem;
import fr.exelo.radiation.item.CraftingManager;
import fr.exelo.radiation.reload.CommandReload;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

public class Main extends JavaPlugin implements Listener {
	    public Radiation core;
	    public Help Help;
	    public Logger log;
	    public String v;
	    public String pluginName;
	    public CraftingManager craft;
	    private Date lmt;
		private CommandItem cmdItem;
		private CommandReload cmdRl;
		private ArrayList<Player> quit;
		
	    
	    public Main() {
	        this.core = new Radiation(this);
	        this.Help = new Help(this);
	        this.cmdItem = new CommandItem(this);
	        this.cmdRl = new CommandReload(this);
	        this.craft = new CraftingManager(this);
	        this.log = Logger.getLogger("Minecraft");
	        this.v = "1.0.0";
	        this.pluginName = "FalloutRadiation";
	        this.lmt = new Date();
	        this.quit = new ArrayList<Player>();
	    }
	    
	    public void onDisable() {

	        this.log.info("[" + this.pluginName + "] " + this.v + " disabled.");
	    }
	    
		public void onEnable() {
	        this.saveDefaultConfig();
			getServer().getPluginManager().registerEvents(new BreakListerner(this), this);

	        final PluginManager pm = this.getServer().getPluginManager();
	        pm.registerEvents((Listener)this, (Plugin)this);
	        this.log.info("[" + this.pluginName + "] " + this.v + " enabled."); 
	        Runnable run = new Runnable() {
                
                @Override
                public void run() {
                    core.runApply();
                    core.runUpdate(null);
                }
	        };
	        this.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, run, 0L, this.getConfig().getInt("timer.time"));
	    
	    }
	        

	    public boolean onCommand(final CommandSender sender, final Command cmd, final String lbl, final String[] args) {
	        if (sender instanceof Player) {
	            final Player player = (Player)sender;
	            if (lbl.equalsIgnoreCase("rad")) {
	            	if (args.length == 0) {
	                    this.core.timeEat(player);
	                    return true;
	                }
	            	if (!player.hasPermission("rad.use")) return false;
	            	if (args[0].equalsIgnoreCase("help")) {
	            		if (!player.hasPermission("rad.use")) return false;
	            		this.Help.getHelp(player, null);
	                    return true;
	            	}
	            	else if (args[0].equalsIgnoreCase("start")) {
	            		if (!player.hasPermission("rad.use")) return false;
	            		this.core.paused = false;
                        player.sendMessage("§6[§eF.Rad§6] §9Les radiations ont repris");
                        return true;
	            	}
	            	else if (args[0].equalsIgnoreCase("stop")) {
	            		if (!player.hasPermission("rad.use")) return false;
	            		this.core.paused = true;
                        player.sendMessage("§6[§eF.Rad§6] §cLes radiations ont été stopées");
                        return true;
	            	}
	            	else if (args[0].equalsIgnoreCase("reload")) {
	            		if (!player.hasPermission("rad.use")) return false;
	            		this.cmdRl.getCommandReload(cmd, sender, lbl, args);
	                    return true;
	            	}
	            	else if (args[0].equalsIgnoreCase("give")) {
	            		if (!player.hasPermission("rad.use")) return false;
	            		if (args.length >= 2 && args.length <= 4) {
	            			this.cmdItem.getCommandItem(cmd, sender, lbl, args);
	                        return true;
	            		} else
	            			player.sendMessage("§6[§eF.Rad§6] §cLa commande est /rad give [nom du joueur] <armor/potion/pickaxe> [niv]");
	            			return false;
	            	}
	            	else if (args[0].equalsIgnoreCase("safezone")) {
	            		if (!player.hasPermission("rad.use")) return false;
	            		if (args.length == 3) {
	            			if (args[1].equalsIgnoreCase("add")) {
                                if (player.hasPermission("rad.use")) {
                                    final String regions = this.getConfig().getString("safeZones.safeRegions");
                                    if (regions.length() > 0) {
                                        this.getConfig().set("safeZones.safeRegions", (Object)(String.valueOf(regions) + "," + args[2]));
                                    }
                                    else {
                                        this.getConfig().set("safeZones.safeRegions", (Object)args[2]);
                                    }
                                    this.saveConfig();
                                    player.sendMessage("§6[§eF.Rad§6] §bSafe region ajouté.");
                                    return true;
                                }
                            }
                            else {
                                if (!args[1].equalsIgnoreCase("remove")) {
                                    player.sendMessage("§6[§eF.Rad§6] §bVous pouvez uniquement \"add\" ou \"remove\" une zone");
                                    return true;
                                }
                                if (player.hasPermission("rad.use")) {
                                    final String regions = this.getConfig().getString("safeZones.safeRegions");
                                    final String[] s1 = regions.split(",");
                                    String out = "";
                                    String[] array;
                                    for (int length = (array = s1).length, i = 0; i < length; ++i) {
                                        final String s2 = array[i];
                                        if (s2 != args[2]) {
                                            out = String.valueOf(out) + s2 + ",";
                                        }
                                    }
                                    out = out.substring(0, out.length() - 1);
                                    this.getConfig().set("safeZones.safeRegions", (Object)out);
                                    this.saveConfig();
                                    player.sendMessage("§6[§eF.Rad§6] §bSafe region retirée.");
                                    return true;
                                }
                            }
	            		} 
	            		player.sendMessage("§6[§eF.Rad§6] §cLa commande est /rad safezone <add/remove> <nom de la region>");
	            		return false;
	            	}player.sendMessage("§6[§eF.Rad§6] §cLa commande est incomplete"); 
	            }
	        }
	        else {
	            this.log.warning("Only player can use this command.");
	        }
	        return false;
	    }
	    
	   
	    
	    @EventHandler
	    public void WeatherChange(final WeatherChangeEvent event) {
	        this.core.RainRadiation.weather = event.toWeatherState();
	        this.core.runUpdate(null);
	    }
	    
	    
	    @EventHandler
	    public void PlayerTeleport(final PlayerTeleportEvent event) {
	    	this.core.runUpdate(event.getPlayer());

	    }
	    @EventHandler
	    public void onCraftEvent(final PrepareItemCraftEvent event) {
	    	CraftingManager.craft(event);

	    }
	    
	    @EventHandler
	    public void onJoin (final PlayerJoinEvent event) {
	    	if (quit.contains(event.getPlayer())) {
	    		event.getPlayer().damage(2);
	    	}
	    	this.core.runUpdate(event.getPlayer());
	    }
	    
	    @EventHandler
	    public void onQuit (final PlayerQuitEvent event) {
	    	this.quit.add(event.getPlayer());
	    }
	   

	    
	    @EventHandler
	    public void PlayerMove(final PlayerMoveEvent event) {
	        if (this.lmt.getTime() + 10000L < new Date().getTime()) {
	            this.core.runUpdate(event.getPlayer());
	            this.lmt = new Date();
	        }
	    }
	    
	    @EventHandler
	    public void PlayerEat(final PlayerItemConsumeEvent event) {
	        if (event.getItem() != null) {
	            this.core.eat(event.getItem(), event.getPlayer());
	        }
	    }
	    @Override
	    public List<String> onTabComplete(CommandSender sender, Command cmd, String lbl, String[] args) {
	    	if ((lbl.equalsIgnoreCase("rad") || lbl.equalsIgnoreCase("radiation")) && sender.hasPermission("rad.use")) {
		    	if (args.length == 1)
		            return Arrays.asList("help", "start", "stop", "reload", "give", "safezone");
		    	if (args.length == 2) {
		    		if (args[0].equalsIgnoreCase("help")) {
		    			return Arrays.asList("start", "stop", "reload", "give", "safezone");
		    		}
		    		else if (args[0].equalsIgnoreCase("give")) {
		    			return this.getServer().getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
		    			
		    		}
		    		else if (args[0].equalsIgnoreCase("safezone")) {
		    			return Arrays.asList("add", "remove");
		    		}
		    		else return Collections.emptyList();
		    	}
		    	if (args.length == 3) {
		    		if (args[0].equalsIgnoreCase("give")) {
		    			if (args[1].equalsIgnoreCase("armor")) return Arrays.asList("T45", "T51b", "X-01", "X-02");
		    			else if (args[1].equalsIgnoreCase("potion")) return Arrays.asList("RadX", "RadAway");
		    			else if (args[1].equalsIgnoreCase("pickaxe")) return Arrays.asList("Perceuse3000", "Perceuse4000");
		    			else return Arrays.asList("armor", "potion", "pickaxe");
		    		}
		    		else {
		    			return Collections.emptyList();

		    		}
		    	}
		    	if (args.length == 4) {
		    		if (args[0].equalsIgnoreCase("give")) {
		    			if (args[2].equalsIgnoreCase("armor")) return Arrays.asList("T45", "T51b", "X-01", "X-02");
		    			else if (args[2].equalsIgnoreCase("potion")) return Arrays.asList("RadX", "RadAway");
		    			else if (args[2].equalsIgnoreCase("pickaxe")) return Arrays.asList("Perceuse3000", "Perceuse4000");
		    			else return Collections.emptyList();
		    		}
		    		else return Collections.emptyList();
		    	}
	    	return Collections.emptyList();
	    	}
	    return Collections.emptyList();
	    }
}
