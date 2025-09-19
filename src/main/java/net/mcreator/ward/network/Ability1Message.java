package net.mcreator.ward.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.mcreator.ward.procedures.Abiltiy1OnKeyPressedProcedure;
import net.mcreator.ward.WardMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Ability1Message {
    private final int type, pressedms;

    public Ability1Message(int type, int pressedms) {
        this.type = type;
        this.pressedms = pressedms;
    }

    public Ability1Message(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.pressedms = buffer.readInt();
    }

    public static void buffer(Ability1Message message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.writeInt(message.pressedms);
    }

    public static void handler(Ability1Message message, Supplier<NetworkEvent.Context> contextSupplier) {
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
            Abiltiy1OnKeyPressedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        WardMod.addNetworkMessage(Ability1Message.class, Ability1Message::buffer, Ability1Message::new, Ability1Message::handler);
    }
}
