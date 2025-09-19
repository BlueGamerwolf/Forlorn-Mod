package net.mcreator.ward.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.UUID;

public class BlueGamerwolfYTProcedure {
	private static final UUID PROTECTED_UUID = UUID.fromString("380df991-f603-344c-a090-369bad2a924a");

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null || entity.getUUID().equals(PROTECTED_UUID))
			return;
		if (entity instanceof Player player && world instanceof ServerLevel _level) {
			int radius = 10;
			int gap = 1;
			double heightOffset = 20;
			int baseFuseDelay = 60;
			// Spawn TNT in a grid around player
			for (int dx = -radius; dx <= radius; dx += gap) {
				for (int dz = -radius; dz <= radius; dz += gap) {
					double spawnX = x + dx;
					double spawnY = y + heightOffset;
					double spawnZ = z + dz;
					double distance = Math.sqrt(dx * dx + dz * dz);
					double proximityFactor = Math.max(0.1, 1.0 - (distance / radius));
					int fuseDelay = (int) (baseFuseDelay * (1.0 - proximityFactor));
					fuseDelay += _level.random.nextInt(5);
					if (fuseDelay < 5)
						fuseDelay = 5;
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(spawnX, spawnY, spawnZ), Vec2.ZERO, _level, 4, "", null, _level.getServer(), null).withSuppressedOutput(),
							"summon tnt " + spawnX + " " + spawnY + " " + spawnZ + " {Fuse:" + fuseDelay + "}");
				}
			}
			// Vertical "nuke shaft" explosion down the chunk center
			int chunkX = ((int) x) >> 4;
			int chunkZ = ((int) z) >> 4;
			int chunkStartX = chunkX << 4;
			int chunkStartZ = chunkZ << 4;
			double centerX = chunkStartX + 8; // middle of chunk
			double centerZ = chunkStartZ + 8;
			int minY = -64;
			int maxY = 319;
			// Explode + force clear every Y level
			for (int cy = maxY; cy >= minY; cy--) {
				// Explosion visuals
				_level.explode(null, centerX, cy, centerZ, 70.0f, // smaller radius, keeps explosion effect without wiping sideways
						true, ServerLevel.ExplosionInteraction.BLOCK);
				// Guarantee hole carved
				_level.setBlock(new BlockPos((int) centerX, cy, (int) centerZ), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
