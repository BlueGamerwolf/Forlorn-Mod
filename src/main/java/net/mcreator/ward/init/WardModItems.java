
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.ward.item.WardenItem;
import net.mcreator.ward.item.SpiritBallItem;
import net.mcreator.ward.item.SculkGreatswordItem;
import net.mcreator.ward.item.Part3Item;
import net.mcreator.ward.item.Part2Item;
import net.mcreator.ward.item.Part1Item;
import net.mcreator.ward.item.NetherlineBladeItem;
import net.mcreator.ward.item.MattermulipulatorItem;
import net.mcreator.ward.item.MatterBallItem;
import net.mcreator.ward.item.InTheEndItem;
import net.mcreator.ward.item.HumanBladeItem;
import net.mcreator.ward.item.EnderlineBladeItem;
import net.mcreator.ward.item.EndGameFightItem;
import net.mcreator.ward.item.DevineBladeItem;
import net.mcreator.ward.item.CorruptedswordItem;
import net.mcreator.ward.item.CorruptedsniperItem;
import net.mcreator.ward.item.CorruptedlongSwordItem;
import net.mcreator.ward.item.CorruptedarmorItem;
import net.mcreator.ward.item.CorruptedReaperScytheItem;
import net.mcreator.ward.item.CorruptedPickaxeItem;
import net.mcreator.ward.item.CorruptedIngotItem;
import net.mcreator.ward.item.CommandshuvelItem;
import net.mcreator.ward.item.CommandsetItem;
import net.mcreator.ward.item.CommandingotItem;
import net.mcreator.ward.item.CommandaxeItem;
import net.mcreator.ward.item.CommandPickaxeItem;
import net.mcreator.ward.item.CommandHoeItem;
import net.mcreator.ward.item.CommandBladeItem;
import net.mcreator.ward.item.BlossomScytheItem;
import net.mcreator.ward.WardMod;

public class WardModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, WardMod.MODID);
	public static final RegistryObject<Item> CORRUPTEDARMOR_HELMET = REGISTRY.register("corruptedarmor_helmet", () -> new CorruptedarmorItem.Helmet());
	public static final RegistryObject<Item> CORRUPTEDARMOR_CHESTPLATE = REGISTRY.register("corruptedarmor_chestplate", () -> new CorruptedarmorItem.Chestplate());
	public static final RegistryObject<Item> CORRUPTEDARMOR_LEGGINGS = REGISTRY.register("corruptedarmor_leggings", () -> new CorruptedarmorItem.Leggings());
	public static final RegistryObject<Item> CORRUPTEDARMOR_BOOTS = REGISTRY.register("corruptedarmor_boots", () -> new CorruptedarmorItem.Boots());
	public static final RegistryObject<Item> CORRUPTED_REAPER_SCYTHE = REGISTRY.register("corrupted_reaper_scythe", () -> new CorruptedReaperScytheItem());
	public static final RegistryObject<Item> SCULK_GREATSWORD = REGISTRY.register("sculk_greatsword", () -> new SculkGreatswordItem());
	public static final RegistryObject<Item> SPIRIT_BALL = REGISTRY.register("spirit_ball", () -> new SpiritBallItem());
	public static final RegistryObject<Item> BLOSSOM_SCYTHE = REGISTRY.register("blossom_scythe", () -> new BlossomScytheItem());
	public static final RegistryObject<Item> MATTERMULIPULATOR = REGISTRY.register("mattermulipulator", () -> new MattermulipulatorItem());
	public static final RegistryObject<Item> CORRUPTED_INGOT = REGISTRY.register("corrupted_ingot", () -> new CorruptedIngotItem());
	public static final RegistryObject<Item> PART_1 = REGISTRY.register("part_1", () -> new Part1Item());
	public static final RegistryObject<Item> PART_2 = REGISTRY.register("part_2", () -> new Part2Item());
	public static final RegistryObject<Item> PART_3 = REGISTRY.register("part_3", () -> new Part3Item());
	public static final RegistryObject<Item> CORRUPTEDSWORD = REGISTRY.register("corruptedsword", () -> new CorruptedswordItem());
	public static final RegistryObject<Item> CORRUPTEDLONG_SWORD = REGISTRY.register("corruptedlong_sword", () -> new CorruptedlongSwordItem());
	public static final RegistryObject<Item> CABLE_ENERGY_N = block(WardModBlocks.CABLE_ENERGY_N);
	public static final RegistryObject<Item> CABLE_ENERGY_I = block(WardModBlocks.CABLE_ENERGY_I);
	public static final RegistryObject<Item> CABLE_ENERGY_LC = block(WardModBlocks.CABLE_ENERGY_LC);
	public static final RegistryObject<Item> CABLE_ENERGY_LCC = block(WardModBlocks.CABLE_ENERGY_LCC);
	public static final RegistryObject<Item> CABLE_ENERGY_LT = block(WardModBlocks.CABLE_ENERGY_LT);
	public static final RegistryObject<Item> CABLE_ENERGY_LTC = block(WardModBlocks.CABLE_ENERGY_LTC);
	public static final RegistryObject<Item> CABLE_ENERGY_T = block(WardModBlocks.CABLE_ENERGY_T);
	public static final RegistryObject<Item> CABLE_ENERGY_TC = block(WardModBlocks.CABLE_ENERGY_TC);
	public static final RegistryObject<Item> CABLE_ENERGY_TX = block(WardModBlocks.CABLE_ENERGY_TX);
	public static final RegistryObject<Item> CABLE_ENERGY_TXC = block(WardModBlocks.CABLE_ENERGY_TXC);
	public static final RegistryObject<Item> CABLE_ENERGY_TXCC = block(WardModBlocks.CABLE_ENERGY_TXCC);
	public static final RegistryObject<Item> CABLE_ENERGY_F = block(WardModBlocks.CABLE_ENERGY_F);
	public static final RegistryObject<Item> CABLE_ENERGY_S = block(WardModBlocks.CABLE_ENERGY_S);
	public static final RegistryObject<Item> CABLE_ENERGY_E = block(WardModBlocks.CABLE_ENERGY_E);
	public static final RegistryObject<Item> CABLE_ENERGY_X = block(WardModBlocks.CABLE_ENERGY_X);
	public static final RegistryObject<Item> CABLE_ENERGY_XC = block(WardModBlocks.CABLE_ENERGY_XC);
	public static final RegistryObject<Item> CORRUPTED_PICKAXE = REGISTRY.register("corrupted_pickaxe", () -> new CorruptedPickaxeItem());
	public static final RegistryObject<Item> CABLE_ENDERGY_L = block(WardModBlocks.CABLE_ENDERGY_L);
	public static final RegistryObject<Item> MATTER_BALL = REGISTRY.register("matter_ball", () -> new MatterBallItem());
	public static final RegistryObject<Item> DEVINE_BLADE = REGISTRY.register("devine_blade", () -> new DevineBladeItem());
	public static final RegistryObject<Item> CORRUPTEDSNIPER = REGISTRY.register("corruptedsniper", () -> new CorruptedsniperItem());
	public static final RegistryObject<Item> LUCKY = block(WardModBlocks.LUCKY);
	public static final RegistryObject<Item> SCULK_NUKE = block(WardModBlocks.SCULK_NUKE);
	public static final RegistryObject<Item> WARDEN = REGISTRY.register("warden", () -> new WardenItem());
	public static final RegistryObject<Item> DEATH_SPAWN_EGG = REGISTRY.register("death_spawn_egg", () -> new ForgeSpawnEggItem(WardModEntities.DEATH, -65485, -16776961, new Item.Properties()));
	public static final RegistryObject<Item> COMMANDINGOT = REGISTRY.register("commandingot", () -> new CommandingotItem());
	public static final RegistryObject<Item> COMMANDORE = block(WardModBlocks.COMMANDORE);
	public static final RegistryObject<Item> COMMANDAXE = REGISTRY.register("commandaxe", () -> new CommandaxeItem());
	public static final RegistryObject<Item> COMMAND_PICKAXE = REGISTRY.register("command_pickaxe", () -> new CommandPickaxeItem());
	public static final RegistryObject<Item> COMMANDSHUVEL = REGISTRY.register("commandshuvel", () -> new CommandshuvelItem());
	public static final RegistryObject<Item> COMMAND_HOE = REGISTRY.register("command_hoe", () -> new CommandHoeItem());
	public static final RegistryObject<Item> COMMAND_BLADE = REGISTRY.register("command_blade", () -> new CommandBladeItem());
	public static final RegistryObject<Item> END_GAME_FIGHT = REGISTRY.register("end_game_fight", () -> new EndGameFightItem());
	public static final RegistryObject<Item> BLUEGAMERWOLF_SPAWN_EGG = REGISTRY.register("bluegamerwolf_spawn_egg", () -> new ForgeSpawnEggItem(WardModEntities.BLUEGAMERWOLF, -16776961, -16711681, new Item.Properties()));
	public static final RegistryObject<Item> COMMANDSET_HELMET = REGISTRY.register("commandset_helmet", () -> new CommandsetItem.Helmet());
	public static final RegistryObject<Item> COMMANDSET_CHESTPLATE = REGISTRY.register("commandset_chestplate", () -> new CommandsetItem.Chestplate());
	public static final RegistryObject<Item> COMMANDSET_LEGGINGS = REGISTRY.register("commandset_leggings", () -> new CommandsetItem.Leggings());
	public static final RegistryObject<Item> COMMANDSET_BOOTS = REGISTRY.register("commandset_boots", () -> new CommandsetItem.Boots());
	public static final RegistryObject<Item> NETHERLINE_BLADE = REGISTRY.register("netherline_blade", () -> new NetherlineBladeItem());
	public static final RegistryObject<Item> ENDERLINE_BLADE = REGISTRY.register("enderline_blade", () -> new EnderlineBladeItem());
	public static final RegistryObject<Item> HUMAN_BLADE = REGISTRY.register("human_blade", () -> new HumanBladeItem());
	public static final RegistryObject<Item> DARKNESS_LUCKY_BLOCK = block(WardModBlocks.DARKNESS_LUCKY_BLOCK);
	public static final RegistryObject<Item> NETHERLIN_GOD_SPAWN_EGG = REGISTRY.register("netherlin_god_spawn_egg", () -> new ForgeSpawnEggItem(WardModEntities.NETHERLIN_GOD, -65536, -26368, new Item.Properties()));
	public static final RegistryObject<Item> ENDERLIN_GOD_SPAWN_EGG = REGISTRY.register("enderlin_god_spawn_egg", () -> new ForgeSpawnEggItem(WardModEntities.ENDERLIN_GOD, -6750055, -13434829, new Item.Properties()));
	public static final RegistryObject<Item> IN_THE_END = REGISTRY.register("in_the_end", () -> new InTheEndItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
