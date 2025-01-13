package net.mcreator.ward.procedures;

import net.minecraft.world.entity.player.Player;

public class IfzenModeActiveProcedure {
    public static void execute(Player player) {
        // Check if the Zen Mode toggle is active for the player
        boolean zenModeActive = player.getPersistentData().getBoolean("zenModeActive");

        if (zenModeActive) {
            // If Zen Mode is active, execute HaelPart2Procedure
            HaelPart2Procedure.execute(player);
        }
    }
}
