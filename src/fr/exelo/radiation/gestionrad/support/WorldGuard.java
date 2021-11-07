package fr.exelo.radiation.gestionrad.support;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;

import fr.exelo.radiation.Radiation;

import org.bukkit.entity.Player;

public class WorldGuard
{
    private Radiation core;
    
    public WorldGuard(final Radiation instance) {
        this.core = instance;
    }
    
    public boolean isInSafeZone(final Player player) {
    	BlockVector3 position = BlockVector3.at(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
    	Location loc = new Location(BukkitAdapter.adapt(player.getWorld()), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
    	RegionContainer container = com.sk89q.worldguard.WorldGuard.getInstance().getPlatform().getRegionContainer();
    	RegionManager regions = container.get((World) loc.getExtent());
    	if (regions == null) return false;
    	ApplicableRegionSet set = regions.getApplicableRegions(position);
    	String[] s = this.core.plugin.getConfig().getString("safeZones.safeRegions").split(",");
    	
    	for (final ProtectedRegion region : set) {
            final String rid = region.getId();
            String[] array;
            for (int length = (array = s).length, i = 0; i < length; ++i) {
                final String name = array[i];
                if (name.equals(rid)) {
                    return true;
                }
            }
        }
        return false;
    }
}