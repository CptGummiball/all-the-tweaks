package org.cptgummiball.att.tweaks;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Collection;

public class SilentMobs implements Listener {

    private final int mobThreshold;
    private final int radius;

    public SilentMobs(FileConfiguration config) {
        this.mobThreshold = config.getInt("SilentMobs.MobThreshold", 10);
        this.radius = config.getInt("SilentMobs.Radius", 5);
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Monster) {
            Collection<Entity> nearbyEntities = event.getLocation().getWorld().getNearbyEntities(
                    event.getLocation(), radius, radius, radius, entity -> entity instanceof Monster);

            if (nearbyEntities.size() > mobThreshold) {
                event.getEntity().setSilent(true);
            }
        }
    }
}
