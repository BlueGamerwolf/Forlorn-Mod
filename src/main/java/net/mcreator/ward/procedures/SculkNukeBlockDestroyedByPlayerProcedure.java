package net.mcreator.ward.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ward.WardMod;

import java.util.Random;

public class SculkNukeBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Random = 0;
		WardMod.queueServerWork(20, () -> {
			for (int index0 = 0; index0 < 2; index0++) {
				WardMod.queueServerWork(100, () -> {
					for (int index1 = 0; index1 < 5; index1++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 1, z + 1), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 2, z + -5), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 3, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 4, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					WardMod.queueServerWork(30, () -> {
						for (int index2 = 0; index2 < 3; index2++) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 1, z + 1), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 2, z + -5), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 3, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 4, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
						WardMod.queueServerWork(30, () -> {
							for (int index3 = 0; index3 < 2; index3++) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 1, z + 1), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 2, z + -5), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 3, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y + 4, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						});
					});
				});
			}
		});
		WardMod.queueServerWork(200, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "summon tnt");
		});
	}
}
