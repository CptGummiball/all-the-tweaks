package org.cptgummiball.att.tweaks;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

public class HopperFilter implements Listener {


    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        if (event.getSource().getType().toString().equalsIgnoreCase("HOPPER")) {

            Block hopperBlock = event.getSource().getLocation().getBlock();
            ItemStack itemInHopper = event.getItem();

            boolean validItem = false;
            for (BlockFace face : BlockFace.values()) {
                Block adjacentBlock = hopperBlock.getRelative(face);
                if (adjacentBlock.getState() instanceof ItemFrame) {
                    ItemFrame itemFrame = (ItemFrame) adjacentBlock.getState();
                    ItemStack itemInFrame = itemFrame.getItem();

                    if (itemInHopper.isSimilar(itemInFrame)) {
                        validItem = true;
                        break;
                    }
                }
            }

            if (!validItem) {
                event.setCancelled(true);
            }
        }
    }
}


