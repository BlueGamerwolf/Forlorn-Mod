package net.mcreator.ward.Handler;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.particles.ParticleTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SnapModeUtils {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int RADIUS = 5; // Hardcoded radius

    /**
     * Changes blocks in a 5-block radius around the player to the block in their off-hand.
     * Ignores air and blacklisted blocks.
     * If the off-hand block is blacklisted, Snap does nothing.
     */
    public static void snapChangeBlocks(ServerPlayer player) {
        if (player == null || !(player.level() instanceof ServerLevel serverLevel)) return;

        ItemStack offHandItem = player.getOffhandItem();

        // Check if the off-hand block can be copied
        if (offHandItem.isEmpty() || !(offHandItem.getItem() instanceof BlockItem blockItem)
                || SnapBlacklist.isBlacklisted(blockItem.getBlock())) {
            player.sendSystemMessage(
                    net.minecraft.network.chat.Component.literal("This block cannot be copied!"));
            return;
        }

        Block block = ((BlockItem) offHandItem.getItem()).getBlock();
        BlockState newState = block.defaultBlockState();
        BlockPos playerPos = player.blockPosition();

        LOGGER.info("Changing blocks around player {} to {}", player.getName().getString(), block.getName().getString());

        for (int dx = -RADIUS; dx <= RADIUS; dx++) {
            for (int dz = -RADIUS; dz <= RADIUS; dz++) {
                for (int dy = -RADIUS; dy <= RADIUS; dy++) {
                    BlockPos targetPos = playerPos.offset(dx, dy, dz);
                    BlockState targetState = serverLevel.getBlockState(targetPos);

                    // Skip air blocks
                    if (targetState.isAir()) continue;

                    serverLevel.setBlock(targetPos, newState, 3);
                    serverLevel.sendParticles(ParticleTypes.PORTAL,
                            targetPos.getX() + 0.5,
                            targetPos.getY() + 0.5,
                            targetPos.getZ() + 0.5,
                            1, 0, 0, 0, 0);
                }
            }
        }

        serverLevel.playSound(null, playerPos, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS, 2.0f, 1.0f);

        LOGGER.info("Finished changing blocks around player {} in radius {}", player.getName().getString(), RADIUS);
    }

    public static float getSnapDamageValue(ServerLevel world) {
        return switch (world.getDifficulty()) {
            case PEACEFUL -> 0.0f;
            case EASY -> 5.0f;
            case NORMAL -> 10.0f;
            case HARD -> 20.0f;
        };
    }

    public static DamageSource getSnapDamage(ServerPlayer player) {
        return player.damageSources().mobAttack(player);
    }
}
