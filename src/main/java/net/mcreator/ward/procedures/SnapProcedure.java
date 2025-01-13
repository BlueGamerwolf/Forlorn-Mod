package net.mcreator.ward.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import io.netty.buffer.Unpooled;
import net.mcreator.ward.world.inventory.KillMenu;

public class SnapProcedure {

    public static void execute(ServerPlayer player) {
        if (player == null) return;

        // Set the title for the screen
        Component title = Component.literal("Select Player to Snap");

        // Open the KillScreen GUI for the player
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return title;
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player playerEntity) {
                // Create a FriendlyByteBuf to pass data to the container
                FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
                return new KillMenu(id, playerInventory, buffer);
            }
        });
    }
}
