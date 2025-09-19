package net.mcreator.ward.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.ward.WardMod;
import net.mcreator.ward.procedures.Ability2OnKeyPressedProcedure;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Ability2Message {
    private final int type, pressedms;

    public Ability2Message(int type, int pressedms) {
        this.type = type;
        this.pressedms = pressedms;
    }

    public Ability2Message(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.pressedms = buffer.readInt();
    }

    public static void buffer(Ability2Message message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.writeInt(message.pressedms);
    }

    public static void handler(Ability2Message message, Supplier<NetworkEvent.Context> contextSupplier) {
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
            Ability2OnKeyPressedProcedure.execute(entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        WardMod.addNetworkMessage(Ability2Message.class, Ability2Message::buffer, Ability2Message::new, Ability2Message::handler);
    }
}
