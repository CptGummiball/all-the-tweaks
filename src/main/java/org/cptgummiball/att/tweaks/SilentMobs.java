package org.cptgummiball.att.tweaks;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import java.util.Collection;

public class SilentMobs implements Listener{

    private int MOB_THRESHOLD = 10; // Number of mobs before silencing them
    private int RADIUS = 5; // Radius to check for nearby mobs

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Monster) {
            Collection<Entity> nearbyEntities = event.getLocation().getWorld().getNearbyEntities(
                    event.getLocation(), RADIUS, RADIUS, RADIUS, entity -> entity instanceof Monster);

            if (nearbyEntities.size() > MOB_THRESHOLD) {
                ((LivingEntity) event.getEntity()).setSilent(true);
            }
        }
    }
}
