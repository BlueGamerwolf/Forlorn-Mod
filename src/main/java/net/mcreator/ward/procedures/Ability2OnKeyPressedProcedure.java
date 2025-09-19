package net.mcreator.ward.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ward.Handler.SnapHandler; // <- import the new handler

import java.util.UUID;

public class Ability2OnKeyPressedProcedure {

    private static final UUID TARGET_UUID = UUID.fromString("a1bc8320-401b-43ff-a73f-581ea979e506");

    public static void execute(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        if (serverPlayer.getUUID().equals(TARGET_UUID)) {
            // Call SnapHandler instead of SnapProcedure
            SnapHandler.executeSnap(serverPlayer);
        }
    }
}
