package net.mcreator.ward.procedures;

import net.minecraft.world.level.LevelAccessor;

public class CableEnergyUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			CableEnergyUpdateTickModelsProcedure.execute(world, x, y, z);
			CableEnergyUpdateTickEnergyProcedure.execute(world, x, y, z);
		}
	}
}
