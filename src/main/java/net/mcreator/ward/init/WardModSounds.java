
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
	public static final RegistryObject<SoundEvent> STATUS_YUKKI = REGISTRY.register("status_yukki", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ward", "status_yukki")));
	public static final RegistryObject<SoundEvent> CHAOTIC_INTERFERENCE = REGISTRY.register("chaotic_interference", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ward", "chaotic_interference")));
	public static final RegistryObject<SoundEvent> SOME_HOPE_BOTD = REGISTRY.register("some_hope.botd", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ward", "some_hope.botd")));
	public static final RegistryObject<SoundEvent> IN_THE_END = REGISTRY.register("in_the_end", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ward", "in_the_end")));
}
