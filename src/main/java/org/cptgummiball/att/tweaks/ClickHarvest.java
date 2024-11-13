package org.cptgummiball.att.tweaks;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClickHarvest implements Listener {
    public final Map<Material, Material> seeds = new HashMap<>();

    public ClickHarvest() {
        // Initialize the assignment of plants to seeds
        seeds.put(Material.WHEAT, Material.WHEAT_SEEDS);
        seeds.put(Material.CARROTS, Material.CARROT);
        seeds.put(Material.BEETROOTS, Material.BEETROOT_SEEDS);
        seeds.put(Material.POTATOES, Material.POTATO);
        seeds.put(Material.COCOA, Material.COCOA_BEANS);
        seeds.put(Material.NETHER_WART, Material.NETHER_WART);
    }
    @EventHandler
    public void onClick(@NotNull PlayerInteractEvent e){
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block block = e.getClickedBlock();
        if (block == null) return;
        if (!seeds.containsKey(block.getType())) return;
        Player player = e.getPlayer();
        if (player.isSneaking()) return;
        Ageable a = (Ageable) block.getBlockData();
        if (a.getAge() != a.getMaximumAge()) return;
        List<ItemStack> drops = new ArrayList<>(block.getDrops(player.getInventory().getItemInMainHand(), player));
        a.setAge(0);
        block.setBlockData(a);
        player.swingMainHand();
        for (ItemStack drop : drops) {
            if (seeds.containsValue(drop.getType())) {
                drop.setAmount(drop.getAmount()-1);
            }
            if (drop.getType().isAir() || drop.getAmount() <= 0) continue;
            block.getWorld().dropItemNaturally(block.getLocation(), drop);
        }
        player.getWorld().playSound(block.getLocation(), Sound.ITEM_CROP_PLANT, 1.0f, 1.0f);
        e.setUseItemInHand(Event.Result.DENY);
    }
}
