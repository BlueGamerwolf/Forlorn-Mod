package net.mcreator.ward.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.ward.procedures.Ability3OnKeyPressedProcedure;
import net.mcreator.ward.WardMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Ability3Message {
    private final int type, pressedms;

    public Ability3Message(int type, int pressedms) {
        this.type = type;
        this.pressedms = pressedms;
    }

    public Ability3Message(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.pressedms = buffer.readInt();
    }

    public static void buffer(Ability3Message message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.writeInt(message.pressedms);
    }

    public static void handler(Ability3Message message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player sender = context.getSender();
            if (sender != null) pressAction(sender, message.type, message.pressedms);
        });
        context.setPacketHandled(true);
    }

    public static void pressAction(Player entity, int type, int pressedms) {
        if (!entity.level().hasChunkAt(entity.blockPosition())) return;
        if (type == 0) {
            Ability3OnKeyPressedProcedure.execute(entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        WardMod.addNetworkMessage(Ability3Message.class, Ability3Message::buffer, Ability3Message::new, Ability3Message::handler);
    }
}
