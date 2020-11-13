package us.isebas.timber.util;

import jdk.jfr.Event;
import org.loomdev.api.Loom;
import org.loomdev.api.block.BlockPointer;
import org.loomdev.api.block.BlockType;
import org.loomdev.api.world.World;

import java.awt.*;

public class WoodType {
    private final BlockPointer block;
    private final int x, y, z;
    private final World world;

    public WoodType(BlockPointer block, World world, int x, int y, int z) {
        this.block = block;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;

        evalWood(BlockType.OAK_LOG, block.getBlockType());
        evalWood(BlockType.BIRCH_LOG, block.getBlockType());
        evalWood(BlockType.SPRUCE_LOG, block.getBlockType());
        evalWood(BlockType.ACACIA_LOG, block.getBlockType());
    }

    private void evalWood(BlockType blockType, BlockType block) {
        if (blockType.getKey().toString().equals(block.getKey().toString())) {
            breakWood();
        }
    }

    private void breakWood() {
        for (int xx = 0; xx < 16; xx++) {
            for (int zz = 0; zz < 16; zz++) {
                for (int yy = 127; yy >= 0; yy--) {
                    System.out.println("hello");
                    if (x == zz && y == yy && z == xx) {
                        System.out.println("hello");
                        world.getBlock(x, y, z).setBlockType(block.getBlockType());
                    }
                }
            }
        }
    }
}
