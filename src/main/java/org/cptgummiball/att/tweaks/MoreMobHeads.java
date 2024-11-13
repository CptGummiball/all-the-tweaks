package org.cptgummiball.att.tweaks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class MoreMobHeads implements Listener {

    private final double mobHeadDropChance;

    public MoreMobHeads(FileConfiguration config) {
        this.mobHeadDropChance = config.getDouble("MoreMobHeads.DropChance", 5.0);
    }


    public class MobHeadDropListener implements Listener {

        private final double mobHeadDropChance;

        public MobHeadDropListener(double mobHeadDropChance) {
            this.mobHeadDropChance = mobHeadDropChance;
        }

        @EventHandler
        public void onMobDeath(EntityDeathEvent event) {
            LivingEntity entity = event.getEntity();

            if (new Random().nextDouble() * 100 < mobHeadDropChance) {
                EntityType entityType = entity.getType();

                ItemStack head = null;
                switch (entityType) {
                    case ZOMBIE:
                        head = new ItemStack(Material.ZOMBIE_HEAD);
                        break;
                    case SKELETON:
                        head = new ItemStack(Material.SKELETON_SKULL);
                        break;
                    case CREEPER:
                        head = new ItemStack(Material.CREEPER_HEAD);
                        break;
                    case ENDER_DRAGON:
                        head = new ItemStack(Material.DRAGON_HEAD);
                        break;
                    case WITHER:
                        head = new ItemStack(Material.WITHER_SKELETON_SKULL);
                        break;
                }

                if (head != null) {
                    event.getDrops().add(head);
                }
            }
        }

    }
}

