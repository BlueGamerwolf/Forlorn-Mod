package net.mcreator.ward.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.ItemStack;

import net.mcreator.ward.init.WardModItems;

public class CorruptedsniperRightclickedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("loaded", true);
		{
			ItemStack _isc = itemstack;
			final ItemStack _setstack = new ItemStack(WardModItems.MATTER_BALL.get());
			final int _sltid = 0;
			_setstack.setCount(1);
			_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable itemHandlerModifiable) {
					itemHandlerModifiable.setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}
}
