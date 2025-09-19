package net.mcreator.ward.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class SnapDamageTypes {
    // Register "ward:snap" as a damage type
    public static final ResourceKey<DamageType> SNAP =
            ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("ward", "snap"));

    // Create a DamageSource for use in code
    public static DamageSource snap(Level level) {
        return new DamageSource(
                level.registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(SNAP)
        );
    }
}
