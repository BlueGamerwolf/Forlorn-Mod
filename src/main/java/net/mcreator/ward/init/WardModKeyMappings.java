
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ward.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.ward.network.FlightMessage;
import net.mcreator.ward.network.DevMessage;
import net.mcreator.ward.network.Ability3Message;
import net.mcreator.ward.network.Ability1Message;
import net.mcreator.ward.WardMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class WardModKeyMappings {
	public static final KeyMapping DEV = new KeyMapping("key.ward.dev", GLFW.GLFW_KEY_UNKNOWN, "key.categories.creative") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardMod.PACKET_HANDLER.sendToServer(new DevMessage(0, 0));
				DevMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_2 = new KeyMapping("key.ward.ability_2", GLFW.GLFW_KEY_N, "key.categories.misc");
	public static final KeyMapping ABILITY_1 = new KeyMapping("key.ward.ability_1", GLFW.GLFW_KEY_B, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardMod.PACKET_HANDLER.sendToServer(new Ability1Message(0, 0));
				Ability1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLIGHT = new KeyMapping("key.ward.flight", GLFW.GLFW_KEY_UNKNOWN, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardMod.PACKET_HANDLER.sendToServer(new FlightMessage(0, 0));
				FlightMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_3 = new KeyMapping("key.ward.ability_3", GLFW.GLFW_KEY_MINUS, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WardMod.PACKET_HANDLER.sendToServer(new Ability3Message(0, 0));
				Ability3Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DEV);
		event.register(ABILITY_2);
		event.register(ABILITY_1);
		event.register(FLIGHT);
		event.register(ABILITY_3);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DEV.consumeClick();
				ABILITY_1.consumeClick();
				FLIGHT.consumeClick();
				ABILITY_3.consumeClick();
			}
		}
	}
}
