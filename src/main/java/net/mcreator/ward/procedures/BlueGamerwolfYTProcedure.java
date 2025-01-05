package net.mcreator.ward.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class BlueGamerwolfYTProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity instanceof Player player && world instanceof ServerLevel _level) {
			// Iterate in a 100x100 radius with 5-block gaps
			int radius = 100;
			int gap = 5;
			double heightOffset = 10; // TNT spawns 10 blocks above the player
			int fuseDelay = 600; // 30 seconds in ticks (20 ticks = 1 second)

			for (int dx = -radius; dx <= radius; dx += gap) {
				for (int dz = -radius; dz <= radius; dz += gap) {
					double spawnX = x + dx;
					double spawnY = y + heightOffset;
					double spawnZ = z + dz;

					// Summon TNT with a custom fuse delay
					_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(
							CommandSource.NULL, 
							new Vec3(spawnX, spawnY, spawnZ), 
							Vec2.ZERO, 
							_level, 
							4, 
							"", 
							null, 
							_level.getServer(), 
							null
						).withSuppressedOutput(), 
						"summon tnt " + spawnX + " " + spawnY + " " + spawnZ + " {Fuse:" + fuseDelay + "}"
					);

					// After TNT is summoned, use explosion power simulation (if using custom TNT)
					// Note: Vanilla Minecraft doesn't support ExplosionPower for tnt, but you can add it via mods/data packs.
				}
			}
		}
	}
}
