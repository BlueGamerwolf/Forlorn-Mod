package net.mcreator.ward.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public class MusicProcedure {
    private static boolean musicToggled = false; // Tracks whether the music is toggled on or off
    private static final UUID ALLOWED_UUID = UUID.fromString("a1bc8320-401b-43ff-a73f-581ea979e506");

    public static void execute(ServerLevel world, ServerPlayer player) {
        if (!player.getUUID().equals(ALLOWED_UUID)) {
            player.displayClientMessage(
                net.minecraft.network.chat.Component.literal("You do not have permission to toggle the music."),
                true
            );
            return; // Prevent non-authorized players from toggling the music
        }

        musicToggled = !musicToggled; // Toggle the music state

        // Get the SoundEvent from the registry
        var customSound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ward:warden_end_fight"));

        if (customSound == null) {
            player.displayClientMessage(
                net.minecraft.network.chat.Component.literal("Sound event not found!"),
                true
            );
            return; // Exit if the sound event is not found
        }

        if (musicToggled) {
            // Play the music to every player in the world
            for (ServerPlayer targetPlayer : world.players()) {
                world.playSound(
                    null, // No specific entity
                    targetPlayer.getX(), targetPlayer.getY(), targetPlayer.getZ(), // Player's position
                    customSound, // Custom sound event
                    SoundSource.MUSIC, // Sound category
                    1.0F, // Volume
                    1.0F // Pitch
                );
            }
        } else {
            // Optionally notify players that the music is toggled off
            for (ServerPlayer targetPlayer : world.players()) {
                targetPlayer.displayClientMessage(
                    net.minecraft.network.chat.Component.literal("Music has been toggled off."),
                    true
                );
            }
        }
    }
}
