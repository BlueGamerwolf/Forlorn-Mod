package net.mcreator.ward.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class ReloadOnKeyPressedRProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity.getUUID().toString().equals("a1bc8320-401b-43ff-a73f-581ea979e506")) {
            // Pass the correct parameters to match the method signature
            BlueGamerwolfYTProcedure.execute(world, x, y, z, entity);
        } else if (entity.getUUID().toString().equals("d07322a7-1862-4b6d-92ea-0ef3ab2a7318")) {
            // Pass the correct parameters to match the method signature
            NickTheClownProcedure.execute(entity);
        } else if (entity.getUUID().toString().equals("9b233ebd-0f97-4ddb-9003-12611bf1ed8d")) {
            RageProcedure.toggleRage(entity); // Updated method call
        } else if (entity.getUUID().toString().equals("27293c84-e600-4290-8aae-348490503253")) {
            // Check if the entity is a Player
            if (entity instanceof Player player) {
                NickProcedure.execute(player); // Pass the Player instance
            }
        } else {
            // Handle other players
            PlayersProcedure.execute(world, x, y, z, entity.getUUID());
        }
    }
}
