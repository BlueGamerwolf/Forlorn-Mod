package net.mcreator.ward.Handler;

import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;


public class SnapModeKillWardens {
	public static void execute(ServerPlayer player) {
		if (!player.getInventory().contains(new net.minecraft.world.item.ItemStack(Items.NETHER_STAR))) {
			player.sendSystemMessage(Component.literal("You need a Nether Star to use this mode!"));
			return;
		}
		ServerLevel world = (ServerLevel) player.level();
		var snap = SnapModeUtils.getSnapDamage(player);
		try {
			world.getEntities(EntityType.WARDEN, player.getBoundingBox().inflate(1000), e -> true).forEach(e -> e.hurt(snap, Float.MAX_VALUE));
			player.sendSystemMessage(Component.literal("Mode 1 executed: all Wardens eliminated."));
		} catch (NoClassDefFoundError e) {
			player.sendSystemMessage(Component.literal("Wardens are not available in this version."));
		}
	}
}
