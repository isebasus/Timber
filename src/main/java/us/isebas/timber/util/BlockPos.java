package us.isebas.timber.util;

import org.loomdev.api.block.Block;

public class BlockPos {
    public Block block;
    public int pos[];

    public BlockPos(int[] pos, Block block) {
        this.block = block;
        this.pos = pos;
    }
}
