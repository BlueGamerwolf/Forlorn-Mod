
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.ward.entity.MatterBulletEntity;
import net.mcreator.ward.entity.DeathEntity;
import net.mcreator.ward.entity.BluegamerwolfEntity;
import net.mcreator.ward.WardMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WardModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WardMod.MODID);
	public static final RegistryObject<EntityType<MatterBulletEntity>> MATTER_BULLET = register("projectile_matter_bullet",
			EntityType.Builder.<MatterBulletEntity>of(MatterBulletEntity::new, MobCategory.MISC).setCustomClientFactory(MatterBulletEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DeathEntity>> DEATH = register("death",
			EntityType.Builder.<DeathEntity>of(DeathEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(DeathEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BluegamerwolfEntity>> BLUEGAMERWOLF = register("bluegamerwolf",
			EntityType.Builder.<BluegamerwolfEntity>of(BluegamerwolfEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BluegamerwolfEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DeathEntity.init();
			BluegamerwolfEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DEATH.get(), DeathEntity.createAttributes().build());
		event.put(BLUEGAMERWOLF.get(), BluegamerwolfEntity.createAttributes().build());
	}
}
