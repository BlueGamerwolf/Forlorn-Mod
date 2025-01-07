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
			int baseFuseDelay = 40; // Base fuse delay in ticks (20 ticks = 1 second)

			for (int dx = -radius; dx <= radius; dx += gap) {
				for (int dz = -radius; dz <= radius; dz += gap) {
					double spawnX = x + dx;
					double spawnY = y + heightOffset;
					double spawnZ = z + dz;

					// Calculate distance from the player
					double distance = Math.sqrt(dx * dx + dz * dz);

					// Adjust properties based on proximity
					double proximityFactor = Math.max(0.1, 1.0 - (distance / radius)); // Closer = higher factor
					int fuseDelay = (int) (baseFuseDelay * (1.0 - proximityFactor)); // Closer = shorter delay
					if (fuseDelay < 5) fuseDelay = 5; // Ensure a minimum fuse delay

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
				}
			}

			// Nuke the chunk where the player is located
			// Determine the chunk coordinates
			int chunkX = ((int) x) >> 4; // Divide x by 16 to get the chunk X coordinate
			int chunkZ = ((int) z) >> 4; // Divide z by 16 to get the chunk Z coordinate

			// Convert chunk coordinates back to block coordinates
			int chunkStartX = chunkX << 4; // Multiply chunkX by 16
			int chunkStartZ = chunkZ << 4; // Multiply chunkZ by 16

			// Define vertical range for explosions
			int minY = 0; // Starting from bedrock
			int maxY = 319; // Minecraft's height limit (adjustable based on your version)

			// Iterate through the chunk and create explosions
			for (int cx = 0; cx < 16; cx++) { // Chunk is 16 blocks wide
				for (int cz = 0; cz < 16; cz++) { // Chunk is 16 blocks long
					for (int cy = minY; cy <= maxY; cy += 10) { // Create explosions every 10 blocks vertically
						double explosionX = chunkStartX + cx;
						double explosionY = cy;
						double explosionZ = chunkStartZ + cz;

						// Trigger an explosion at the specified location
						_level.explode(null, explosionX, explosionY, explosionZ, 8.0f, true, ServerLevel.ExplosionInteraction.BLOCK);
					}
				}
			}
		}
	}
}
