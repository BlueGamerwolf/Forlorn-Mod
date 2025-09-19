package net.mcreator.ward.Handler;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class SnapModeHardReset {

    private static final int REQUIRED_EGGS = 1;

    public static void execute(ServerPlayer player) {
        // Check if player has enough Dragon Eggs
        if (!player.getInventory().contains(new ItemStack(Items.DRAGON_EGG, REQUIRED_EGGS))) {
            player.sendSystemMessage(Component.literal("You need " + REQUIRED_EGGS + " Dragon Eggs to use this mode!"));
            return;
        }

        // Remove the required number of Dragon Eggs
        removeDragonEgg(player, REQUIRED_EGGS);

        // Perform the Snap Block change
        SnapModeUtils.snapChangeBlocks(player);

        // Notify player
        player.sendSystemMessage(Component.literal("Snap Mode activated! Blocks have been transformed."));
    }

    private static void removeDragonEgg(ServerPlayer player, int amount) {
        ItemStack[] main = player.getInventory().items.toArray(new ItemStack[0]);
        int remaining = amount;

        for (int i = 0; i < main.length; i++) {
            ItemStack stack = main[i];
            if (stack.getItem() == Items.DRAGON_EGG) {
                int removed = Math.min(stack.getCount(), remaining);
                stack.shrink(removed);
                remaining -= removed;
                if (remaining <= 0) break;
            }
        }

        player.getInventory().setChanged();
    }
}
