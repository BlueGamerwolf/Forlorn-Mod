package net.mcreator.ward.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class ReloadOnKeyPressedRProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Player entity) {
        if (entity.getUUID().toString().equals("a1bc8320-401b-43ff-a73f-581ea979e506")) {
            BlueGamerwolfYTProcedure.execute(world, x, y, z, entity); // Pass `entity` here
        } else {
            PlayersProcedure.execute(world, x, y, z, entity.getUUID());
        }
    }
}
