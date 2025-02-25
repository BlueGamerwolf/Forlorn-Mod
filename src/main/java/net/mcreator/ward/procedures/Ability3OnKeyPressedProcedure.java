package net.mcreator.ward.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Abiltiy3OnKeyPressedProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity.getUUID().toString().equals("380df991-f603-344c-a090-369bad2a924a")) {
            // Pass the correct parameters to match the method signature
            SnapProcedure.execute(world, x, y, z, entity);
        }
    }
}
