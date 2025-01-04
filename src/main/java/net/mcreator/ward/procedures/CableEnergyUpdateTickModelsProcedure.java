package net.mcreator.ward.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.ward.init.WardModBlocks;

public class CableEnergyUpdateTickModelsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_N.get())) {
				CableEnergyUpdateTickModelsNProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_E.get())) {
				CableEnergyUpdateTickModelsEProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_I.get())) {
				CableEnergyUpdateTickModelsIProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENDERGY_L.get())) {
				CableEnergyUpdateTickModelsLProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_LC.get())) {
				CableEnergyUpdateTickModelsLCProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_LCC.get())) {
				CableEnergyUpdateTickModelsLCCProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_LT.get())) {
				CableEnergyUpdateTickModelsLTProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_LTC.get())) {
				CableEnergyUpdateTickModelsLTCProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_T.get())) {
				CableEnergyUpdateTickModelsTProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_TC.get())) {
				CableEnergyUpdateTickModelsTCProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_TX.get())) {
				CableEnergyUpdateTickModelsTXProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_TXC.get())) {
				CableEnergyUpdateTickModelsTXCProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_TXCC.get())) {
				CableEnergyUpdateTickModelsTXCCProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_X.get())) {
				CableEnergyUpdateTickModelsXProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_XC.get())) {
				CableEnergyUpdateTickModelsXCProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_F.get())) {
				CableEnergyUpdateTickModelsFProcedure.execute(world, x, y, z);
			}
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == WardModBlocks.CABLE_ENERGY_S.get())) {
				CableEnergyUpdateTickModelsSProcedure.execute(world, x, y, z);
			}
		}
	}
}
