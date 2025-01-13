package net.mcreator.ward.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.FriendlyByteBuf;
import net.mcreator.ward.client.gui.KillScreen;
import net.mcreator.ward.world.inventory.KillMenu;
import io.netty.buffer.Unpooled;

public class SnapProcedure {

    public static void execute(ServerPlayer player) {
        if (player == null) return;

        // Create a FriendlyByteBuf to pass to KillMenu constructor
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());

        // You might want to provide block position or other data in extraData
        // buffer.writeBlockPos(someBlockPos);

        // Create the KillMenu container, passing the required arguments
        KillMenu container = new KillMenu(0, player.getInventory(), buffer);

        // Set the title for the screen
        Component title = new TextComponent("Select Player to Snap");

        // Open the KillScreen GUI for the player
        player.openMenu(new KillScreen(container, player.getInventory(), title));
    }
}
