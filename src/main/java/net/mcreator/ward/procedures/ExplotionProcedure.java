package net.mcreator.ward.procedures;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.core.registries.Registries;

public class ExplotionProcedure {
    // Constructor to register the event
    public ExplotionProcedure() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLevelTick(TickEvent.LevelTickEvent event) {
        // Ensure the event only runs on the server side and at the end of the tick
        if (event.phase == TickEvent.Phase.END && event.level instanceof ServerLevel serverWorld) {
            execute(serverWorld);
        }
    }

    public static void execute(LevelAccessor world) {
        // Ensure the procedure only runs on the server side
        if (world instanceof ServerLevel serverWorld) {
            // Iterate over all entities in the world
            for (Entity entity : serverWorld.getEntities(null, entity -> true)) {
                // Skip null entities
                if (entity == null)
                    continue;

                // Check if the entity is a player with the "Warden_god" tag
                if (entity instanceof Player player && player.getTags().contains("Warden_god")) {
                    // Player with "Warden_god" tag is immune to explosion damage
                    continue; // This skips applying damage
                }

                // Apply explosion damage to other entities
                entity.hurt(
                    new DamageSource(
                        serverWorld.registryAccess()
                            .registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(DamageTypes.EXPLOSION)
                    ),
                    10 // Replace 10 with the desired explosion damage value
                );
            }
        }
    }
}
