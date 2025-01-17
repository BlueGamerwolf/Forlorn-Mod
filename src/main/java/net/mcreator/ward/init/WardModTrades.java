
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.ward.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WardModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == WardModVillagerProfessions.DARKNESS_TRADER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.SCULK, 64), new ItemStack(Items.AMETHYST_SHARD), new ItemStack(WardModBlocks.COMMANDORE.get()), 1000, 5, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.CORNFLOWER, 8), new ItemStack(Items.BLUE_DYE), new ItemStack(WardModItems.MATTER_BALL.get(), 32), 1000, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.TNT, 64), new ItemStack(Blocks.SCULK, 32), new ItemStack(WardModBlocks.SCULK_NUKE.get()), 500, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.TNT, 9), new ItemStack(Items.EMERALD, 14), new ItemStack(WardModBlocks.DARKNESS_LUCKY_BLOCK.get()), 10000, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(WardModBlocks.SCULK_NUKE.get(), 5), new ItemStack(Items.EMERALD, 36), new ItemStack(WardModBlocks.LUCKY.get()), 10000, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.KNOWLEDGE_BOOK), new ItemStack(Items.AXOLOTL_BUCKET), new ItemStack(WardModItems.HUMAN_BLADE.get()), 1, 10, 0.1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(WardModItems.HUMAN_BLADE.get()), new ItemStack(Items.NETHER_STAR), new ItemStack(WardModItems.NETHERLINE_BLADE.get()), 1, 10, 0.2f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(WardModItems.NETHERLINE_BLADE.get()), new ItemStack(Blocks.DRAGON_EGG), new ItemStack(WardModItems.ENDERLINE_BLADE.get()), 1, 10, 0.2f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Blocks.NETHERITE_BLOCK, 9), new ItemStack(Items.NETHERITE_INGOT, 4), new ItemStack(WardModItems.CORRUPTED_INGOT.get()), 64, 10, 1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(WardModItems.NETHERLINE_BLADE.get()), new ItemStack(WardModItems.CORRUPTED_INGOT.get()), new ItemStack(WardModItems.COMMAND_BLADE.get()), 1, 10, 0.4f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(WardModItems.COMMANDINGOT.get(), 64), new ItemStack(WardModItems.COMMAND_BLADE.get()), new ItemStack(WardModItems.CORRUPTED_PICKAXE.get()), 1, 10000, 0.9f));
		}
	}
}
