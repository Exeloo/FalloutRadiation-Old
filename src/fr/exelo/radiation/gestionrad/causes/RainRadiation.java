package fr.exelo.radiation.gestionrad.causes;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import fr.exelo.radiation.Radiation;

public class RainRadiation implements Listener {

	private Radiation core;
    public boolean weather;

    public RainRadiation(final Radiation instance) {
        this.core = instance;
    }

    
    public double getRainRadiation(final Player player) {
        if (this.weather && player.getWorld().getHighestBlockAt(player.getLocation()).getY() < player.getLocation().getY()) {
            return this.core.plugin.getConfig().getDouble("radiation.pluie");
        }
        return 1.0;
    }
}
