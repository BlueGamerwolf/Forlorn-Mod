package net.mcreator.ward.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component; // Import Component class

import java.util.HashSet;
import java.util.Set;

public class RageProcedure {
    private static final Set<Entity> rageEnabledPlayers = new HashSet<>();

    public static void toggleRage(Entity entity) {
        if (entity instanceof Player player) {
            if (rageEnabledPlayers.contains(player)) {
                rageEnabledPlayers.remove(player);
                player.displayClientMessage(Component.literal("Rage mode disabled!"), true);
            } else {
                rageEnabledPlayers.add(player);
                player.displayClientMessage(Component.literal("Rage mode enabled!"), true);
            }
        }
    }

    public static void onPlayerHit(Entity attacker, Entity target) {
        if (target instanceof Player player && rageEnabledPlayers.contains(player) && attacker instanceof Player attackingPlayer) {
            // Drop all items from the attacker's inventory
            for (ItemStack itemStack : attackingPlayer.getInventory().items) {
                if (!itemStack.isEmpty()) {
                    attackingPlayer.drop(itemStack, true, false);
                }
            }
            // Clear the attacker's inventory
            attackingPlayer.getInventory().clearContent();
        }
    }
}
