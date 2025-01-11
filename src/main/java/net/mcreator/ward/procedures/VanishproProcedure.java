package net.mcreator.ward.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class VanishproProcedure {
    public static void execute(ServerPlayer player) {
        // Fix: replace player.getLevel() with player.level()
        if (player == null || player.level().isClientSide()) {
            return;
        }

        // Check if the player already has the invisibility effect
        if (player.hasEffect(MobEffects.INVISIBILITY)) {
            // If the player has the invisibility effect, remove it and make them visible again

            // Remove the invisibility effect
            player.removeEffect(MobEffects.INVISIBILITY);

            // Disable flying
            player.getAbilities().flying = false; // Disable flight when the player becomes visible
            player.getAbilities().mayfly = false; // Ensure flight mode cannot be toggled
            player.onUpdateAbilities(); // Apply the changes to the player

            // Send a fake "joined the server" message to all players except the player
            Component joinMessage = Component.literal(player.getName().getString() + " joined the game");
            player.getServer().getPlayerList().getPlayers().forEach(otherPlayer -> {
                if (!otherPlayer.equals(player)) {
                    otherPlayer.connection.send(new ClientboundSystemChatPacket(joinMessage, false));
                }
            });

            // Add the player's entity back to the world for other players
            player.getServer().getPlayerList().getPlayers().forEach(otherPlayer -> {
                if (!otherPlayer.equals(player)) {
                    otherPlayer.connection.send(new ClientboundRemoveEntitiesPacket(player.getId()));
                }
            });

            // Inform the player that they are no longer vanished
            player.displayClientMessage(Component.literal("You are now visible!"), false);
        } else {
            // If the player doesn't have the invisibility effect, apply it and make them invisible

            // Make the player invisible without particles (showParticles=false)
            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, Integer.MAX_VALUE, 0, false, false));

            // Enable flight
            player.getAbilities().flying = true; // Enable flight when the player is vanished
            player.getAbilities().mayfly = true; // Allow the player to toggle flight mode
            player.onUpdateAbilities(); // Apply the changes to the player

            // Send a fake "left the server" message to all players except the vanished one
            Component leaveMessage = Component.literal(player.getName().getString() + " left the game");
            player.getServer().getPlayerList().getPlayers().forEach(otherPlayer -> {
                if (!otherPlayer.equals(player)) {
                    otherPlayer.connection.send(new ClientboundSystemChatPacket(leaveMessage, false));
                }
            });

            // Remove the player's entity from the world for other players
            player.getServer().getPlayerList().getPlayers().forEach(otherPlayer -> {
                if (!otherPlayer.equals(player)) {
                    otherPlayer.connection.send(new ClientboundRemoveEntitiesPacket(player.getId()));
                }
            });

            // Inform the vanished player
            player.displayClientMessage(Component.literal("You are now vanished!"), false);
        }
    }
}
