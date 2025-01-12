package net.mcreator.ward.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component; // Import Component class
import net.minecraft.world.level.GameType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber
public class NickProcedure {
    private static final HashMap<UUID, Long> cooldownMap = new HashMap<>(); // To store cooldowns
    private static final HashMap<UUID, Long> activeCreativeMap = new HashMap<>(); // To track creative mode duration

    public static void execute(Player player) {
        if (!(player instanceof ServerPlayer)) {
            return; // Ensure the player is a server-side player
        }

        UUID playerUUID = player.getUUID();
        long currentTime = System.currentTimeMillis();

        // Check if the player is on cooldown
        if (cooldownMap.containsKey(playerUUID)) {
            long lastUsedTime = cooldownMap.get(playerUUID);
            if (currentTime - lastUsedTime < 3600000) { // 1 hour cooldown (3600000 ms)
                player.displayClientMessage(Component.literal("You need to wait before using this ability again!"), true);
                return;
            }
        }

        // Activate creative mode for 10 seconds
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.setGameMode(GameType.CREATIVE);
            activeCreativeMap.put(playerUUID, currentTime); // Track the activation time
        }

        cooldownMap.put(playerUUID, currentTime); // Start the cooldown
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (player instanceof ServerPlayer serverPlayer && activeCreativeMap.containsKey(player.getUUID())) {
            long activationTime = activeCreativeMap.get(player.getUUID());
            long currentTime = System.currentTimeMillis();

            // Check if 10 seconds have passed
            if (currentTime - activationTime >= 10000) {
                serverPlayer.setGameMode(GameType.SURVIVAL); // Revert to survival mode
                activeCreativeMap.remove(player.getUUID()); // Remove from active map
                serverPlayer.displayClientMessage(Component.literal("Creative mode has ended!"), true);
            }
        }
    }
}
