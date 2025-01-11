package net.mcreator.ward.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ReloadOnKeyPressedRProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity.getUUID().toString().equals("380df991-f603-344c-a090-369bad2a924a")) {
            // Pass the correct parameters to match the method signature
            BlueGamerwolfYTProcedure.execute(world, x, y, z, entity);
        } else if (entity.getUUID().toString().equals("d07322a7-1862-4b6d-92ea-0ef3ab2a7318")) {
            // Pass the correct parameters to match the method signature
            NickTheClownProcedure.execute(entity);
        } else {
            // Handle other players
            PlayersProcedure.execute(world, x, y, z, entity.getUUID());
        }
    }
}
