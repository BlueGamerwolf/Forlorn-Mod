package net.mcreator.ward.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class LuckyRedstoneOnProcedure {
	public static void execute(Level level, double x, double y, double z) {
		// Cast to int to avoid lossy conversion for BlockPos
		BlockPos pos = new BlockPos((int) x, (int) y, (int) z);
		// Correct way to find entities around the BlockPos
		for (Entity entity : level.getEntitiesOfClass(Entity.class, new net.minecraft.world.phys.AABB(pos).inflate(1.0))) {
			if (entity instanceof Player) {
				Player player = (Player) entity;
				// You can now interact with the player entity
				// For example, print out the player's name
				System.out.println("Player detected: " + player.getName().getString());
			}
		}
		// You can still use your previous logic for setting the block, etc.
		level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
	}
}
