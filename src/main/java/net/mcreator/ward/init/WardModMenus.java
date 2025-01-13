
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.ward.world.inventory.KillMenu;
import net.mcreator.ward.WardMod;

public class WardModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, WardMod.MODID);
	public static final RegistryObject<MenuType<KillMenu>> KILL = REGISTRY.register("kill", () -> IForgeMenuType.create(KillMenu::new));
}
