package net.mcreator.ward.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

@Mod.EventBusSubscriber
public class DragonegginfProcedure {

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof EnderDragon dragon)) return;
        if (!(dragon.level() instanceof ServerLevel level)) return;
        if (!level.dimension().equals(ServerLevel.END)) return;

        // Get the highest block at (0,0) in the End
        int y = level.getHeight() - 1; 
        BlockPos portalTop = new BlockPos(0, y, 0);

        // Move down until we find a solid block
        while (y > 0 && level.isEmptyBlock(portalTop)) {
            y--;
            portalTop = new BlockPos(0, y, 0);
        }

        // Place egg directly above the top block at (0,0)
        BlockPos eggPos = portalTop.above();
        level.setBlock(eggPos, Blocks.DRAGON_EGG.defaultBlockState(), 3);
    }
}
