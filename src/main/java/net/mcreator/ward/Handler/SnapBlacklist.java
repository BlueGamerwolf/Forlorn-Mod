package net.mcreator.ward.Handler;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashSet;
import java.util.Set;

public class SnapBlacklist {

    private static final Set<Block> BLACKLISTED_BLOCKS = new HashSet<>();

    static {
        // Blocks that cannot be copied via Snap
        BLACKLISTED_BLOCKS.add(Blocks.BEDROCK);
        BLACKLISTED_BLOCKS.add(Blocks.END_PORTAL_FRAME);
        BLACKLISTED_BLOCKS.add(Blocks.STRUCTURE_BLOCK);
        BLACKLISTED_BLOCKS.add(Blocks.BARRIER);
        BLACKLISTED_BLOCKS.add(Blocks.REINFORCED_DEEPSLATE);
        BLACKLISTED_BLOCKS.add(Blocks.DRAGON_EGG);
        
        // Add more blocks here if needed
    }

    /**
     * Returns true if the block is blacklisted (cannot be copied).
     */
    public static boolean isBlacklisted(Block block) {
        return BLACKLISTED_BLOCKS.contains(block);
    }
}
