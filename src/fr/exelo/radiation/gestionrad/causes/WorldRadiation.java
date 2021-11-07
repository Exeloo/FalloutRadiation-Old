package fr.exelo.radiation.gestionrad.causes;

import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.exelo.radiation.Radiation;

public class WorldRadiation {
	
	private Radiation core;

	public WorldRadiation(Radiation radiation) {
		this.core = radiation;
	}

	public double getWorldRadiation(Player player) {
        World loc = player.getLocation().getWorld();
        if (loc.getName().startsWith("DXL")) {
        	return 0;
        }
        for (String world : this.core.plugin.getConfig().getConfigurationSection("world").getKeys(false)) {
        	if (loc.getName().equalsIgnoreCase(this.core.plugin.getConfig().getConfigurationSection("world").getString(world + ".name"))) return this.core.plugin.getConfig().getConfigurationSection("world").getInt(world + ".rad");

        }
        return 1.0;
    }

}
