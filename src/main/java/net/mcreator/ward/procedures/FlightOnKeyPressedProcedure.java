package net.mcreator.ward.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class FlightOnKeyPressedProcedure {
    public static void execute(Entity entity) {
        if (!(entity instanceof Player player)) return;

        UUID playerUUID = player.getUUID();

        // Allowed UUIDs
        UUID[] allowedUUIDs = {
            UUID.fromString("fc616e06-fa9a-4431-845d-a1c892ce1f93"),
            UUID.fromString("9b233ebd-0f97-4ddb-9003-12611bf1ed8d"),
            UUID.fromString("a1bc8320-401b-43ff-a73f-581ea979e506"),
            UUID.fromString("d1be0b2d-4a64-4eea-976f-2d69de547c08"),
            UUID.fromString("380df991-f603-344c-a090-369bad2a924a"),
            UUID.fromString("89aba791-baf1-4686-b622-969d55f75887") // Newly added UUID
        };

        boolean canFly = false;
        for (UUID allowed : allowedUUIDs) {
            if (playerUUID.equals(allowed)) {
                canFly = true;
                break;
            }
        }

        if (canFly) {
            // Enable flight
            player.getAbilities().mayfly = true;
            player.getAbilities().flying = true;
            player.onUpdateAbilities();
            player.fallDistance = 0.0F;
        } else {
            player.displayClientMessage(Component.literal("You are not authorized to use this ability."), true);
        }
    }
}
