public class HaelPart2Procedure {
    public static void execute(Entity entity) {
        if (entity instanceof Player player) {
            // Check if Zen Mode (HaelPart1Procedure) is active
            boolean zenModeActive = player.getPersistentData().getBoolean("zenModeActive");

            // Only proceed if Zen Mode is active
            if (zenModeActive) {
                // Check if the player has the custom tag "effectsActive" to determine the toggle state
                boolean effectsActive = player.getPersistentData().getBoolean("effectsActive");

                if (!effectsActive) {
                    // Apply effects if not active

                    // Apply Strength 100 (infinite duration)
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, 99, false, false));

                    // Apply Speed 6 (infinite duration)
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, Integer.MAX_VALUE, 5, false, false));

                    // Apply Haste 60 (infinite duration)
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, Integer.MAX_VALUE, 59, false, false));

                    // Gluttony effect: Transfer inventory from nearby players
                    if (!player.getCommandSenderWorld().isClientSide) {
                        // Define the search area (5-block radius around the player)
                        AABB searchArea = player.getBoundingBox().inflate(5);

                        // Get all entities in the search area
                        List<Entity> nearbyEntities = player.getCommandSenderWorld().getEntities(player, searchArea);

                        for (Entity nearbyEntity : nearbyEntities) {
                            if (nearbyEntity instanceof Player targetPlayer && targetPlayer != player) {
                                // Transfer items from the target player's inventory to the activating player
                                for (int i = 0; i < targetPlayer.getInventory().getContainerSize(); i++) {
                                    ItemStack itemStack = targetPlayer.getInventory().getItem(i);
                                    if (!itemStack.isEmpty()) {
                                        // Add the item to the player's inventory
                                        player.getInventory().add(itemStack.copy());
                                        // Remove the item from the target player's inventory
                                        targetPlayer.getInventory().setItem(i, ItemStack.EMPTY);
                                    }
                                }
                            }
                        }
                    }

                    // Set the toggle to true after applying the effects
                    player.getPersistentData().putBoolean("effectsActive", true);
                } else {
                    // Remove effects if active
                    player.removeEffect(MobEffects.DAMAGE_BOOST);
                    player.removeEffect(MobEffects.MOVEMENT_SPEED);
                    player.removeEffect(MobEffects.DIG_SPEED);

                    // Set the toggle to false after removing the effects
                    player.getPersistentData().putBoolean("effectsActive", false);
                }
            }
        }
    }
}
