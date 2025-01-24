
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.ward.WardMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WardModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WardMod.MODID);
	public static final RegistryObject<CreativeModeTab> FORLORN = REGISTRY.register("forlorn",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.ward.forlorn")).icon(() -> new ItemStack(WardModItems.CORRUPTED_REAPER_SCYTHE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(WardModItems.CORRUPTEDARMOR_HELMET.get());
				tabData.accept(WardModItems.CORRUPTEDARMOR_CHESTPLATE.get());
				tabData.accept(WardModItems.CORRUPTEDARMOR_LEGGINGS.get());
				tabData.accept(WardModItems.CORRUPTEDARMOR_BOOTS.get());
				tabData.accept(WardModItems.CORRUPTED_REAPER_SCYTHE.get());
				tabData.accept(WardModItems.SCULK_GREATSWORD.get());
				tabData.accept(WardModItems.SPIRIT_BALL.get());
				tabData.accept(WardModItems.BLOSSOM_SCYTHE.get());
				tabData.accept(WardModItems.MATTERMULIPULATOR.get());
				tabData.accept(WardModItems.CORRUPTED_INGOT.get());
				tabData.accept(WardModItems.PART_1.get());
				tabData.accept(WardModItems.PART_2.get());
				tabData.accept(WardModItems.PART_3.get());
				tabData.accept(WardModItems.CORRUPTEDSWORD.get());
				tabData.accept(WardModItems.CORRUPTEDLONG_SWORD.get());
				tabData.accept(WardModBlocks.CABLE_ENERGY_N.get().asItem());
				tabData.accept(WardModItems.MATTER_BALL.get());
				tabData.accept(WardModItems.DEVINE_BLADE.get());
				tabData.accept(WardModItems.CORRUPTEDSNIPER.get());
				tabData.accept(WardModBlocks.LUCKY.get().asItem());
				tabData.accept(WardModBlocks.SCULK_NUKE.get().asItem());
				tabData.accept(WardModItems.WARDEN.get());
				tabData.accept(WardModBlocks.DARKNESS_LUCKY_BLOCK.get().asItem());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> COMMAND = REGISTRY.register("command",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.ward.command")).icon(() -> new ItemStack(WardModItems.COMMANDINGOT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(WardModItems.COMMANDINGOT.get());
				tabData.accept(WardModBlocks.COMMANDORE.get().asItem());
				tabData.accept(WardModItems.COMMANDAXE.get());
				tabData.accept(WardModItems.COMMAND_PICKAXE.get());
				tabData.accept(WardModItems.COMMANDSHUVEL.get());
				tabData.accept(WardModItems.COMMAND_HOE.get());
				tabData.accept(WardModItems.COMMAND_BLADE.get());
				tabData.accept(WardModItems.END_GAME_FIGHT.get());
				tabData.accept(WardModItems.COMMANDSET_HELMET.get());
				tabData.accept(WardModItems.COMMANDSET_CHESTPLATE.get());
				tabData.accept(WardModItems.COMMANDSET_LEGGINGS.get());
				tabData.accept(WardModItems.COMMANDSET_BOOTS.get());
				tabData.accept(WardModItems.NETHERLINE_BLADE.get());
				tabData.accept(WardModItems.ENDERLINE_BLADE.get());
				tabData.accept(WardModItems.HUMAN_BLADE.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(WardModItems.DEATH_SPAWN_EGG.get());
			tabData.accept(WardModItems.BLUEGAMERWOLF_SPAWN_EGG.get());
			tabData.accept(WardModItems.NETHERLIN_GOD_SPAWN_EGG.get());
			tabData.accept(WardModItems.ENDERLIN_GOD_SPAWN_EGG.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(WardModItems.CORRUPTED_PICKAXE.get());
		}
	}
}
