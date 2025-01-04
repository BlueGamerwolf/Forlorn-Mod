
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ward.WardMod;

public class WardModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WardMod.MODID);
	public static final RegistryObject<SoundEvent> WARDEN_END_FIGHT = REGISTRY.register("warden_end_fight", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ward", "warden_end_fight")));
}
