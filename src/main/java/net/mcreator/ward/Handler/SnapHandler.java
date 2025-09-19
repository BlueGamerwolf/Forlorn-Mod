package net.mcreator.ward.Handler;

import net.minecraft.server.level.ServerPlayer;

public class SnapHandler {
    private static final java.util.Map<java.util.UUID, Integer> playerModes = new java.util.HashMap<>();

    public static void cycleSnapMode(ServerPlayer player) {
        java.util.UUID uuid = player.getUUID();
        int mode = playerModes.getOrDefault(uuid, 0);
        mode = (mode + 1) % 3;
        playerModes.put(uuid, mode);
        player.sendSystemMessage(net.minecraft.network.chat.Component.literal("Snap mode set to " + mode));
    }

    public static void executeSnap(ServerPlayer player) {
        int mode = playerModes.getOrDefault(player.getUUID(), 0);
        switch (mode) {
            case 0 -> SnapModeKillPlayers.execute(player);
            case 1 -> SnapModeKillWardens.execute(player);
            case 2 -> SnapModeHardReset.execute(player);
        }
    }
}
