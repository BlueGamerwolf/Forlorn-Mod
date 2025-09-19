package net.mcreator.ward.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageTypes;

public class ExplotionProcedure {
    // Constructor to register the event
    public ExplotionProcedure() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        // Only check for players
        if (event.getEntity() instanceof Player player) {
            // If player has the tag and the damage source is an explosion, cancel it
            if (player.getTags().contains("Warden_god") &&
                event.getSource().is(DamageTypes.EXPLOSION)) {
                event.setCanceled(true); // Prevent explosion damage entirely
            }
        }
    }
}
