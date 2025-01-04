package net.mcreator.ward.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.server.level.ServerLevel;
import net.mcreator.ward.init.WardModItems;

import java.util.List;

public class CorruptedPickaxeItem extends PickaxeItem {
    public CorruptedPickaxeItem() {
        super(new Tier() {
            public int getUses() {
                return 6840;
            }

            public float getSpeed() {
                return 10f;
            }

            public float getAttackDamageBonus() {
                return 2f;
            }

            public int getLevel() {
                return 15;
            }

            public int getEnchantmentValue() {
                return 15;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of(new ItemStack(WardModItems.CORRUPTED_INGOT.get()));
            }
        }, 1, -3f, new Item.Properties().fireResistant());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);

        // Ensure we are on the server and the block is not air
        if (!world.isClientSide && !state.isAir() && player != null) {
            Block block = state.getBlock();
            ItemStack blockItemStack = new ItemStack(block);

            // Give the block item to the player
            if (!player.getInventory().add(blockItemStack)) {
                player.drop(blockItemStack, false); // Drop the item if the inventory is full
            }

            // Replace the block with air
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); // Flag 3 updates the client and physics
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS; // Let Minecraft handle other interactions
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
    }
}
