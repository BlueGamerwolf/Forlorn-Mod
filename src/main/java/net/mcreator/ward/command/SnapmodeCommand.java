package net.mcreator.ward.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.mcreator.ward.Handler.SnapHandler;

@Mod.EventBusSubscriber
public class SnapmodeCommand {

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(
            Commands.literal("snap")
                .executes(context -> {
                    CommandSourceStack source = context.getSource();
                    if (source.getEntity() instanceof ServerPlayer player) {
                        // Use SnapHandler now
                        SnapHandler.cycleSnapMode(player);
                        return 1;
                    } else {
                        source.sendFailure(Component.literal("This command can only be run by a player."));
                        return 0;
                    }
                })
        );
    }
}
