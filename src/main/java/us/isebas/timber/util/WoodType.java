package us.isebas.timber.util;

import jdk.jfr.Event;
import org.loomdev.api.Loom;
import org.loomdev.api.block.BlockType;
import org.loomdev.api.entity.player.Player;
import org.loomdev.api.event.block.entity.EntityBlockBreakEvent;

public class WoodType {

    private final EntityBlockBreakEvent event;

    public WoodType(BlockType block, EntityBlockBreakEvent event) {
        this.event = event;

        evalWood(BlockType.OAK_WOOD, block);
        evalWood(BlockType.BIRCH_WOOD, block);
        evalWood(BlockType.SPRUCE_WOOD, block);
        evalWood(BlockType.ACACIA_WOOD, block);
    }

    private void evalWood(BlockType blockType, BlockType block) {
        Player player = (Player) event.getPlayer();
        if (blockType.equals(block)) {
            event.getPlayer().sendMessage("mmmm yes");

            int x = (int) player.getLocation().getX();
            int y = (int) player.getLocation().getY();
            int z = (int) player.getLocation().getZ();

            player.getWorld().setBlockType(x, y, z, block);
        }
    }
}
