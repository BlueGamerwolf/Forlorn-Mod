
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.ward.client.renderer.NetherlinGodRenderer;
import net.mcreator.ward.client.renderer.MatterBulletRenderer;
import net.mcreator.ward.client.renderer.EnderlinGodRenderer;
import net.mcreator.ward.client.renderer.DeathRenderer;
import net.mcreator.ward.client.renderer.BluegamerwolfRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WardModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(WardModEntities.MATTER_BULLET.get(), MatterBulletRenderer::new);
		event.registerEntityRenderer(WardModEntities.DEATH.get(), DeathRenderer::new);
		event.registerEntityRenderer(WardModEntities.BLUEGAMERWOLF.get(), BluegamerwolfRenderer::new);
		event.registerEntityRenderer(WardModEntities.NETHERLIN_GOD.get(), NetherlinGodRenderer::new);
		event.registerEntityRenderer(WardModEntities.ENDERLIN_GOD.get(), EnderlinGodRenderer::new);
	}
}
