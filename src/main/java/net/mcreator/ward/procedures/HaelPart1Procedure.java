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
                // Apply Zen Mode effect (DAMAGE_RESISTANCE) with infinite duration
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0, false, false));

                // Set the toggle to true after applying Zen Mode
                player.getPersistentData().putBoolean("zenModeActive", true);
            } else {
                // Remove Zen Mode effect if it's active
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);

                // Set the toggle to false after removing Zen Mode
                player.getPersistentData().putBoolean("zenModeActive", false);
            }

            // If Zen Mode is active, apply effects ONLY to the attacking player
            if (zenModeActive && attacker instanceof Player attackingPlayer) {
                // Check if the attacking player has Zen Mode active; don't apply negative effects to them
                boolean attackingPlayerZenModeActive = attackingPlayer.getPersistentData().getBoolean("zenModeActive");

                if (!attackingPlayerZenModeActive) {
                    // Apply Mining Fatigue 150 to the attacker with infinite duration
                    attackingPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, Integer.MAX_VALUE, 149, false, false));

                    // Apply Slowness 10 to the attacker with infinite duration
                    attackingPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, Integer.MAX_VALUE, 9, false, false));

                    // Drop the attacker's weapon
                    ItemStack heldItem = attackingPlayer.getMainHandItem();
                    if (!heldItem.isEmpty()) {
                        attackingPlayer.spawnAtLocation(heldItem);
                        attackingPlayer.setItemInHand(attackingPlayer.getUsedItemHand(), ItemStack.EMPTY);
                    }
                }
            }
        }
    }
}
