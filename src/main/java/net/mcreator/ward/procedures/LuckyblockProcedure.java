package net.mcreator.ward.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.mcreator.ward.init.WardModBlocks;
import net.mcreator.ward.init.WardModEntities;

public class LuckyblockProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double random = Math.random();

        // 50% chance to spawn the Blue Gamerwolf entity
        if (random < 0.5) {
            spawnBlueGamerwolf(world, x, y, z);  // Spawn the ward:blue_gamerwolf entity
            return;  // Exit the method if the entity is spawned
        }

        // Group 1: Item Spawns
        if (random < 0.25) {
            spawnItem(world, x, y, z, new ItemStack(Blocks.WATER));
            spawnItem(world, x, y, z, new ItemStack(Items.NETHERITE_BOOTS));
        } 
        // Group 2: Entity Spawns (Evokers)
        else if (random < 0.75) {
            spawnMultipleEntities(world, x, y, z, EntityType.EVOKER, 5);
        } 
        // Group 3: Block Placement
        else if (random < 0.95) {
            placeBlocksAround(world, x, y, z, WardModBlocks.DARKNESS_LUCKY_BLOCK.get());
        } 
        // Group 4: Lightning and Quartz Tower
        else {
            buildTowerWithLightning(world, x, y, z);
        }
    }

    // Method to spawn the ward:blue_gamerwolf entity
    private static void spawnBlueGamerwolf(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = WardModEntities.BLUEGAMERWOLF.get().create(_level);  // Use your entity registry here
            if (entityToSpawn != null) {
                entityToSpawn.moveTo(x + 0.5, y, z + 0.5, world.getRandom().nextFloat() * 360F, 0);
                _level.addFreshEntity(entityToSpawn);
            }
        }
    }

    private static void spawnItem(LevelAccessor world, double x, double y, double z, ItemStack item) {
        if (world instanceof ServerLevel _level) {
            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, item);
            entityToSpawn.setPickUpDelay(10);
            entityToSpawn.setUnlimitedLifetime();
            _level.addFreshEntity(entityToSpawn);
        }
    }

    private static void spawnMultipleEntities(LevelAccessor world, double x, double y, double z, EntityType<?> entityType, int count) {
        if (world instanceof ServerLevel _level) {
            for (int i = 0; i < count; i++) {
                Entity entityToSpawn = entityType.create(_level);
                if (entityToSpawn != null) {
                    entityToSpawn.moveTo(x + 0.5, y, z + 0.5, world.getRandom().nextFloat() * 360F, 0);
                    _level.addFreshEntity(entityToSpawn);
                }
            }
        }
    }

    private static void placeBlocksAround(LevelAccessor world, double x, double y, double z, Block darknessBlock) {
        world.setBlock(new BlockPos((int) x - 1, (int) y, (int) z), Blocks.BEDROCK.defaultBlockState(), 3);
        world.setBlock(new BlockPos((int) x + 1, (int) y, (int) z), Blocks.BEDROCK.defaultBlockState(), 3);
        world.setBlock(new BlockPos((int) x, (int) y, (int) z), darknessBlock.defaultBlockState(), 3);
        world.setBlock(new BlockPos((int) x, (int) y + 1, (int) z), darknessBlock.defaultBlockState(), 3);
        world.setBlock(new BlockPos((int) x, (int) y + 2, (int) z), darknessBlock.defaultBlockState(), 3);
    }

    private static void buildTowerWithLightning(LevelAccessor world, double x, double y, double z) {
        for (int i = 0; i < 4; i++) {
            world.setBlock(new BlockPos((int) x, (int) y + i, (int) z), Blocks.QUARTZ_PILLAR.defaultBlockState(), 3);
        }
        world.setBlock(new BlockPos((int) x, (int) y + 4, (int) z), Blocks.NETHERITE_BLOCK.defaultBlockState(), 3);

        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
            if (entityToSpawn != null) {
                entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos((int) x, (int) y, (int) z)));
                _level.addFreshEntity(entityToSpawn);
            }
        }
    }
}
