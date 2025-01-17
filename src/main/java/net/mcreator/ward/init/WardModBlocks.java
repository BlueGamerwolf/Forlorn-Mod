
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.ward.block.SculkNukeBlock;
import net.mcreator.ward.block.LuckyBlock;
import net.mcreator.ward.block.DarknessLuckyBlockBlock;
import net.mcreator.ward.block.CommandoreBlock;
import net.mcreator.ward.block.CableEnergyXCBlock;
import net.mcreator.ward.block.CableEnergyXBlock;
import net.mcreator.ward.block.CableEnergyTXCCBlock;
import net.mcreator.ward.block.CableEnergyTXCBlock;
import net.mcreator.ward.block.CableEnergyTXBlock;
import net.mcreator.ward.block.CableEnergyTCBlock;
import net.mcreator.ward.block.CableEnergyTBlock;
import net.mcreator.ward.block.CableEnergySBlock;
import net.mcreator.ward.block.CableEnergyNBlock;
import net.mcreator.ward.block.CableEnergyLTCBlock;
import net.mcreator.ward.block.CableEnergyLTBlock;
import net.mcreator.ward.block.CableEnergyLCCBlock;
import net.mcreator.ward.block.CableEnergyLCBlock;
import net.mcreator.ward.block.CableEnergyIBlock;
import net.mcreator.ward.block.CableEnergyFBlock;
import net.mcreator.ward.block.CableEnergyEBlock;
import net.mcreator.ward.block.CableEndergyLBlock;
import net.mcreator.ward.WardMod;

public class WardModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, WardMod.MODID);
	public static final RegistryObject<Block> CABLE_ENERGY_N = REGISTRY.register("cable_energy_n", () -> new CableEnergyNBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_I = REGISTRY.register("cable_energy_i", () -> new CableEnergyIBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_LC = REGISTRY.register("cable_energy_lc", () -> new CableEnergyLCBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_LCC = REGISTRY.register("cable_energy_lcc", () -> new CableEnergyLCCBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_LT = REGISTRY.register("cable_energy_lt", () -> new CableEnergyLTBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_LTC = REGISTRY.register("cable_energy_ltc", () -> new CableEnergyLTCBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_T = REGISTRY.register("cable_energy_t", () -> new CableEnergyTBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_TC = REGISTRY.register("cable_energy_tc", () -> new CableEnergyTCBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_TX = REGISTRY.register("cable_energy_tx", () -> new CableEnergyTXBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_TXC = REGISTRY.register("cable_energy_txc", () -> new CableEnergyTXCBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_TXCC = REGISTRY.register("cable_energy_txcc", () -> new CableEnergyTXCCBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_F = REGISTRY.register("cable_energy_f", () -> new CableEnergyFBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_S = REGISTRY.register("cable_energy_s", () -> new CableEnergySBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_E = REGISTRY.register("cable_energy_e", () -> new CableEnergyEBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_X = REGISTRY.register("cable_energy_x", () -> new CableEnergyXBlock());
	public static final RegistryObject<Block> CABLE_ENERGY_XC = REGISTRY.register("cable_energy_xc", () -> new CableEnergyXCBlock());
	public static final RegistryObject<Block> CABLE_ENDERGY_L = REGISTRY.register("cable_endergy_l", () -> new CableEndergyLBlock());
	public static final RegistryObject<Block> LUCKY = REGISTRY.register("lucky", () -> new LuckyBlock());
	public static final RegistryObject<Block> SCULK_NUKE = REGISTRY.register("sculk_nuke", () -> new SculkNukeBlock());
	public static final RegistryObject<Block> COMMANDORE = REGISTRY.register("commandore", () -> new CommandoreBlock());
	public static final RegistryObject<Block> DARKNESS_LUCKY_BLOCK = REGISTRY.register("darkness_lucky_block", () -> new DarknessLuckyBlockBlock());
}
