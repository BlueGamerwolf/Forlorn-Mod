public class HaelPart1Procedure {
    public static void execute(Entity attacker, Entity target) {
        if (target instanceof Player player) {
            // Check if the Zen Mode toggle is active for the player
            boolean zenModeActive = player.getPersistentData().getBoolean("zenModeActive");

            // Toggle Zen Mode state BEFORE applying effects
            boolean newZenModeState = !zenModeActive;
            player.getPersistentData().putBoolean("zenModeActive", newZenModeState);

            if (newZenModeState) {
                // Apply Zen Mode effect (DAMAGE_RESISTANCE) with infinite duration
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0, false, false));
            } else {
                // Remove Zen Mode effect if it's active
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }

            // If Zen Mode is active, apply effects ONLY to the attacking player
            if (newZenModeState && attacker instanceof Player attackingPlayer) {
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
