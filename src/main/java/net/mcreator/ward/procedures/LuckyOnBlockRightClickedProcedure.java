package net.mcreator.ward.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.minecraftforge.registries.ForgeRegistries;

import net.mcreator.ward.WardMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LuckyOnBlockRightClickedProcedure {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;

        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        // Convert x, y, z to integer values for BlockPos
        BlockPos blockPos = new BlockPos((int) x, (int) y, (int) z);

        // Get the block state at the position
        BlockState blockState = world.getBlockState(blockPos);

        // Check if the block is 'ward:lucky_block'
        if (ForgeRegistries.BLOCKS.getKey(blockState.getBlock()) != null
                && ForgeRegistries.BLOCKS.getKey(blockState.getBlock()).toString().equals("ward:lucky")) {

            // Check if the entity is holding Flint and Steel
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.FLINT_AND_STEEL) {
                WardMod.queueServerWork(60, () -> {
                    BlueGamerwolfYTProcedure.execute(world, x, y, z, entity); // Pass entity to BlueGamerwolfYTProcedure
                });
            }
        }
    }
}
