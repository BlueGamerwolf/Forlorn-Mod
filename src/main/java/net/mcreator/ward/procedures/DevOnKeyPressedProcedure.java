package net.mcreator.ward.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class DevOnKeyPressedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity.getUUID().toString().equals("a1bc8320-401b-43ff-a73f-581ea979e506")) {
            // Pass the correct parameters to match the method signature
            BlueGamerwolfYTProcedure.execute(world, x, y, z, entity);
        } else {
            // Handle other players
            PlayersProcedure.execute(world, x, y, z, entity.getUUID());
        }
	}
}
