package us.isebas.timber.util;

import org.loomdev.api.block.Block;
import org.loomdev.api.block.BlockType;

public class BlockPos {
    public BlockType block;
    public int pos[];

    public BlockPos(int[] pos, BlockType block) {
        this.block = block;
        this.pos = pos;
    }
}
