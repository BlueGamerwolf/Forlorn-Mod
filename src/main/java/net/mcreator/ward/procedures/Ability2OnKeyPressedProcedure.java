package net.mcreator.ward.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;

public class Ability2OnKeyPressedProcedure {
    public static void execute(Player player) {
        // The target UUIDs you're looking for
        String targetUUID1 = "fc616e06-fa9a-4431-845d-a1c892ce1f93";
        String targetUUID2 = "a1bc8320-401b-43ff-a73f-581ea979e506";

        // Check if the player is one with the matching UUID
        if (player instanceof ServerPlayer serverPlayer) {
            String playerUUID = serverPlayer.getUUID().toString();

            if (playerUUID.equals(targetUUID1)) {
                // If the player's UUID matches the first target UUID, execute HaelPart2Procedure
                HaelPart2Procedure.execute(serverPlayer);
            } else if (playerUUID.equals(targetUUID2)) {
                // If the player's UUID matches the second target UUID, execute SnapProcedure
                SnapProcedure.execute(serverPlayer);
            }
        }
    }
}
