package net.mcreator.ward.world.inventory;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity; // Corrected import statement
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ward.init.WardModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class KillMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public final static HashMap<String, Object> guistate = new HashMap<>();
    public final Level world;
    public final Player entity;
    public int x, y, z;
    private ContainerLevelAccess access = ContainerLevelAccess.NULL;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private boolean bound = false;
    private Supplier<Boolean> boundItemMatcher = null;
    private Entity boundEntity = null; // Corrected reference
    private BlockEntity boundBlockEntity = null;

    private String selectedPlayerName = ""; // To store the selected player

    public KillMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        super(WardModMenus.KILL.get(), id);
        this.entity = inv.player;
        this.world = inv.player.level();
        this.internal = new ItemStackHandler(0);
        BlockPos pos = null;
        if (extraData != null) {
            pos = extraData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
            access = ContainerLevelAccess.create(world, pos);
        }
    }

    public void setSelectedPlayer(String playerName) {
        this.selectedPlayerName = playerName;
    }

    public String getSelectedPlayer() {
        return this.selectedPlayerName;
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.bound) {
            if (this.boundItemMatcher != null)
                return this.boundItemMatcher.get();
            else if (this.boundBlockEntity != null)
                return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
            else if (this.boundEntity != null)
                return this.boundEntity.isAlive();
        }
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        return ItemStack.EMPTY;
    }

    public Map<Integer, Slot> get() {
        return customSlots;
    }
}
