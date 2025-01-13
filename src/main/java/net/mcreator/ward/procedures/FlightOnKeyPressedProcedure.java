package net.mcreator.ward.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class FlightOnKeyPressedProcedure {
    public static void execute(Entity entity) {
        if (entity instanceof Player player) {
            // Get the UUID of the player
            UUID playerUUID = player.getUUID();

            // Check if the player's UUID is in the allowed list
            if (playerUUID.equals(UUID.fromString("fc616e06-fa9a-4431-845d-a1c892ce1f93")) ||
                playerUUID.equals(UUID.fromString("9b233ebd-0f97-4ddb-9003-12611bf1ed8d")) ||
                playerUUID.equals(UUID.fromString("a1bc8320-401b-43ff-a73f-581ea979e506")) ||
                playerUUID.equals(UUID.fromString("d1be0b2d-4a64-4eea-976f-2d69de547c08")) ||
                playerUUID.equals(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"))) {

                // Enable flight for the player
                player.getAbilities().mayfly = true; // Allow the player to fly
                player.getAbilities().flying = true; // Start the player flying
                player.onUpdateAbilities(); // Update the player's abilities

                // Make the player immune to fall damage
                player.fallDistance = 0.0F; // Reset fall distance to prevent fall damage
            } else {
                // Notify the player they don't have permission (optional)
                player.displayClientMessage(Component.literal("You are not authorized to use this ability."), true);
            }
        }
    }
}
