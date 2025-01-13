package net.mcreator.ward.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;

public class HaelPart1Procedure {
    public static void execute(Entity attacker, Entity target) {
        if (target instanceof Player player) {
            // Check if the Zen Mode toggle is active for the player
            boolean zenModeActive = player.getPersistentData().getBoolean("zenModeActive");

            if (!zenModeActive) {
                // Apply Zen Mode effect (DAMAGE_RESISTANCE)
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0)); // 6000 ticks = 5 minutes
                
                // Set the toggle to true after applying Zen Mode
                player.getPersistentData().putBoolean("zenModeActive", true);
            } else {
                // Remove Zen Mode effect if it's active
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);

                // Set the toggle to false after removing Zen Mode
                player.getPersistentData().putBoolean("zenModeActive", false);
            }

            // If Zen Mode is active, apply effects to the attacker
            if (zenModeActive) {
                if (attacker instanceof LivingEntity livingAttacker) {
                    // Apply Mining Fatigue 150 to the attacker
                    livingAttacker.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 6000, 149)); // 6000 ticks = 5 minutes

                    // Apply Slowness 10 to the attacker
                    livingAttacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6000, 9));

                    // Drop the attacker's weapon
                    ItemStack heldItem = livingAttacker.getMainHandItem();
                    if (!heldItem.isEmpty()) {
                        livingAttacker.spawnAtLocation(heldItem);
                        livingAttacker.setItemInHand(livingAttacker.getUsedItemHand(), ItemStack.EMPTY);
                    }
                }
            }
        }
    }
}
