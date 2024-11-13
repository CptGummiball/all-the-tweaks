package org.cptgummiball.att.tweaks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerHeadDrops implements Listener {

    private final double playerHeadDropChance;

    public PlayerHeadDrops(FileConfiguration config) {
        this.playerHeadDropChance = config.getDouble("PlayerHeadDrops.DropChance", 5.0);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (new Random().nextDouble() * 100 < playerHeadDropChance) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
            meta.setOwningPlayer(player);

            Player killer = player.getKiller();
            List<String> lore = new ArrayList<>();
            if (killer != null) {
                lore.add("§7Killed by: " + killer.getName());
            } else {
                lore.add("§7Killed by: Unknown");
            }
            meta.setLore(lore);

            playerHead.setItemMeta(meta);

            event.getDrops().add(playerHead);
        }
    }
}

