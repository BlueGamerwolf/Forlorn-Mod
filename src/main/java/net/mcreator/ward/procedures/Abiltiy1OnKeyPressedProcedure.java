package net.mcreator.ward.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class Abiltiy1OnKeyPressedProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity.getUUID().toString().equals("380df991-f603-344c-a090-369bad2a924a")) {
            // Pass the correct parameters to match the method signature
            BlueGamerwolfYTProcedure.execute(world, x, y, z, entity);
        } else if (entity.getUUID().toString().equals("d07322a7-1862-4b6d-92ea-0ef3ab2a7318")) {
            // Pass the correct parameters to match the method signature
            NickTheClownProcedure.execute(entity);
        } else if (entity.getUUID().toString().equals("9b233ebd-0f97-4ddb-9003-12611bf1ed8d")) {
            RageProcedure.toggleRage(entity); // Updated method call
        } else if (entity.getUUID().toString().equals("27293c84-e600-4290-8aae-348490503253")) {
            // Check if the entity is a Player
            if (entity instanceof Player) {
                NickProcedure.execute((Player) entity); // Cast entity to Player
            }
        } else if (entity.getUUID().toString().equals("fc616e06-fa9a-4431-845d-a1c892ce1f93")) {
            // Execute HaelPart1Procedure when the UUID matches
            HaelPart1Procedure.execute(entity, entity); // Pass the entity twice as required by the method
        } else {
            // Handle other players
            PlayersProcedure.execute(world, x, y, z, entity.getUUID());
        }
    }
}
