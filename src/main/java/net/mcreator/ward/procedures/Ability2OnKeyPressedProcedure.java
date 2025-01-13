package net.mcreator.ward.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;

public class Ability2OnKeyPressedProcedure {
    public static void execute(Player player) {
        // The target UUID you're looking for
        String targetUUID = "fc616e06-fa9a-4431-845d-a1c892ce1f93";
        
        // Check if the player is the one with the matching UUID
        if (player instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.getUUID().toString().equals(targetUUID)) {
                // If the player's UUID matches, execute HaelPart2Procedure
                HaelPart2Procedure.execute(serverPlayer);
            }
        }
    }
}
