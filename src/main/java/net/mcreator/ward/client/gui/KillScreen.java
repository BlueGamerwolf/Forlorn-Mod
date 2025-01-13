package net.mcreator.ward.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer; // Added import for ServerPlayer
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.Minecraft;
import net.mcreator.ward.procedures.SnapProcedure; // Import the SnapProcedure class
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.narration.NarratedElementType;

import net.mcreator.ward.world.inventory.KillMenu;

import java.util.HashMap;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

public class KillScreen extends AbstractContainerScreen<KillMenu> {
    private final static HashMap<String, Object> guistate = KillMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    private PlayerSelectionList playerSelectionList;
    private Player selectedPlayer;

    public KillScreen(KillMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("ward:textures/screens/kill.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (playerSelectionList != null) {
            playerSelectionList.render(guiGraphics, mouseX, mouseY, partialTicks);
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();

            // Kill the selected player after closing the menu
            if (selectedPlayer != null && selectedPlayer instanceof ServerPlayer serverPlayer) {
                SnapProcedure.execute(serverPlayer); // Adjusted to pass a ServerPlayer
            }
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void init() {
        super.init();

        // Initialize the player selection list
        List<? extends Player> players = this.world.players();
        this.playerSelectionList = new PlayerSelectionList(this.minecraft, this.width, this.height, 50, this.height - 50, 20, players);
        this.addRenderableWidget(this.playerSelectionList);

        // Add a button to confirm selection
        this.addRenderableWidget(Button.builder(Component.literal("Select Player"), button -> {
            Player selectedPlayer = playerSelectionList.getSelectedPlayer();
            if (selectedPlayer != null) {
                this.selectedPlayer = selectedPlayer; // Store the selected player
                System.out.println("Selected player: " + selectedPlayer.getName().getString());
            }
        }).bounds(this.leftPos + 50, this.topPos + 120, 80, 20).build());
    }

    private class PlayerSelectionList extends AbstractSelectionList<PlayerSelectionList.Entry> {
        private final List<? extends Player> players;

        public PlayerSelectionList(Minecraft minecraft, int width, int height, int top, int bottom, int slotHeight, List<? extends Player> players) {
            super(minecraft, width, height, top, bottom, slotHeight);
            this.players = players;
            for (Player player : players) {
                this.addEntry(new Entry(player));
            }
        }

        @Override
        protected int getScrollbarPosition() {
            return this.width - 6;
        }

        @Override
        public int getRowWidth() {
            return 150;
        }

        public Player getSelectedPlayer() {
            Entry entry = this.getSelected();
            return entry != null ? entry.player : null;
        }

        @Override
        public void updateNarration(NarrationElementOutput output) {
            output.add(NarratedElementType.TITLE, Component.literal("Player Selection List"));
        }

        public class Entry extends AbstractSelectionList.Entry<Entry> {
            private final Player player;

            public Entry(Player player) {
                this.player = player;
            }

            @Override
            public void render(GuiGraphics guiGraphics, int index, int y, int x, int width, int height, int mouseX, int mouseY, boolean hovered, float partialTicks) {
                guiGraphics.drawString(minecraft.font, player.getName().getString(), x, y, 0xFFFFFF);
            }

            @Override
            public boolean mouseClicked(double mouseX, double mouseY, int button) {
                PlayerSelectionList.this.setSelected(this);
                return true;
            }
        }
    }
}
