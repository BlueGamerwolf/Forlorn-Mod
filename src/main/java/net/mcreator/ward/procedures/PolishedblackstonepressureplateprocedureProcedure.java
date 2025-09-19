package net.mcreator.ward.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

@Mod.EventBusSubscriber
public class PolishedblackstonepressureplateprocedureProcedure {

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!(player.level() instanceof ServerLevel level)) return;

        // Block directly under the player
        BlockPos pos = player.blockPosition().below();

        if (level.getBlockState(pos).is(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE)) {
            // Heal player while standing on the plate
            float healAmount = 0.5F; // 1/4 heart per tick
            player.heal(healAmount);
        }
    }
}
