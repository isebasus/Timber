package us.isebas.timber.util;

import org.loomdev.api.Loom;
import org.loomdev.api.block.BlockType;

public class WoodType {

    public WoodType(BlockType block) {
        evalWood(BlockType.OAK_WOOD, block);
        evalWood(BlockType.BIRCH_WOOD, block);
        evalWood(BlockType.SPRUCE_WOOD, block);
        evalWood(BlockType.ACACIA_WOOD, block);
    }

    private void evalWood(BlockType blockType, BlockType block) {
        if (blockType.asItem() == block.asItem()) {
            Loom.getServer().broadcastMessage("MMM yes");
        }
    }
}
