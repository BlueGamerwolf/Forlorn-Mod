package net.mcreator.ward.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SamProcedure {
    private static boolean abilityEnabled = false;

    public static void toggleAbility() {
        // Toggles the ability on or off
        abilityEnabled = !abilityEnabled;
        System.out.println("Ability enabled: " + abilityEnabled);
    }

    public static void execute(Level world, BlockPos originPos) {
        if (!abilityEnabled || !(world instanceof ServerLevel serverWorld)) return;

        // Iterate over a 10-block radius
        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                for (int z = -10; z <= 10; z++) {
                    BlockPos blockPos = originPos.offset(x, y, z);
                    BlockState blockState = world.getBlockState(blockPos);

                    // Check if the block is growable
                    if (blockState.getBlock() instanceof BonemealableBlock growableBlock) {
                        if (growableBlock.isValidBonemealTarget(world, blockPos, blockState, false)) {
                            // Perform the bonemeal effect
                            growableBlock.performBonemeal(serverWorld, serverWorld.random, blockPos, blockState);
                            System.out.println("Grew plant at: " + blockPos);
                        }
                    }
                }
            }
        }
    }
}
