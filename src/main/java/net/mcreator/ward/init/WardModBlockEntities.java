
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.ward.block.entity.CableEnergyXCBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyXBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyTXCCBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyTXCBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyTXBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyTCBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyTBlockEntity;
import net.mcreator.ward.block.entity.CableEnergySBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyNBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyLTCBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyLTBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyLCCBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyLCBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyIBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyFBlockEntity;
import net.mcreator.ward.block.entity.CableEnergyEBlockEntity;
import net.mcreator.ward.block.entity.CableEndergyLBlockEntity;
import net.mcreator.ward.WardMod;

public class WardModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WardMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_N = register("cable_energy_n", WardModBlocks.CABLE_ENERGY_N, CableEnergyNBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_I = register("cable_energy_i", WardModBlocks.CABLE_ENERGY_I, CableEnergyIBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_LC = register("cable_energy_lc", WardModBlocks.CABLE_ENERGY_LC, CableEnergyLCBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_LCC = register("cable_energy_lcc", WardModBlocks.CABLE_ENERGY_LCC, CableEnergyLCCBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_LT = register("cable_energy_lt", WardModBlocks.CABLE_ENERGY_LT, CableEnergyLTBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_LTC = register("cable_energy_ltc", WardModBlocks.CABLE_ENERGY_LTC, CableEnergyLTCBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_T = register("cable_energy_t", WardModBlocks.CABLE_ENERGY_T, CableEnergyTBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_TC = register("cable_energy_tc", WardModBlocks.CABLE_ENERGY_TC, CableEnergyTCBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_TX = register("cable_energy_tx", WardModBlocks.CABLE_ENERGY_TX, CableEnergyTXBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_TXC = register("cable_energy_txc", WardModBlocks.CABLE_ENERGY_TXC, CableEnergyTXCBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_TXCC = register("cable_energy_txcc", WardModBlocks.CABLE_ENERGY_TXCC, CableEnergyTXCCBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_F = register("cable_energy_f", WardModBlocks.CABLE_ENERGY_F, CableEnergyFBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_S = register("cable_energy_s", WardModBlocks.CABLE_ENERGY_S, CableEnergySBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_E = register("cable_energy_e", WardModBlocks.CABLE_ENERGY_E, CableEnergyEBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_X = register("cable_energy_x", WardModBlocks.CABLE_ENERGY_X, CableEnergyXBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENERGY_XC = register("cable_energy_xc", WardModBlocks.CABLE_ENERGY_XC, CableEnergyXCBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CABLE_ENDERGY_L = register("cable_endergy_l", WardModBlocks.CABLE_ENDERGY_L, CableEndergyLBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
