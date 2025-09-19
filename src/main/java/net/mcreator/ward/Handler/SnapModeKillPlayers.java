package net.mcreator.ward.Handler;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;


public class SnapModeKillPlayers {
    public static void execute(ServerPlayer player) {
        if (player.totalExperience < 50) {
            player.sendSystemMessage(net.minecraft.network.chat.Component.literal("Not enough XP!"));
            return;
        }
        player.giveExperiencePoints(-50);

        ServerLevel world = (ServerLevel) player.level();
        var snap = SnapModeUtils.getSnapDamage(player);

        world.players().forEach(p -> {
            if (!p.getUUID().equals(player.getUUID())) {
                p.hurt(snap, Float.MAX_VALUE);
            }
        });

        player.sendSystemMessage(net.minecraft.network.chat.Component.literal("Mode 0 executed: all other players eliminated."));
    }
}
