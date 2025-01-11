package net.mcreator.ward.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ward.procedures.VanishproProcedure;

@Mod.EventBusSubscriber
public class VanishCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("vanish")

                .executes(arguments -> {
                    Level world = arguments.getSource().getUnsidedLevel();
                    double x = arguments.getSource().getPosition().x();
                    double y = arguments.getSource().getPosition().y();
                    double z = arguments.getSource().getPosition().z();
                    Entity entity = arguments.getSource().getEntity();

                    // Ensure the entity is a ServerPlayer, not a fake player
                    if (entity instanceof ServerPlayer) {
                        ServerPlayer player = (ServerPlayer) entity;

                        // Pass the actual player to the VanishproProcedure
                        VanishproProcedure.execute(player);
                    } else if (world instanceof ServerLevel _servLevel) {
                        // Fallback to using a fake player if entity is null
                        ServerPlayer player = FakePlayerFactory.getMinecraft(_servLevel);
                        VanishproProcedure.execute(player);
                    }

                    return 0;
                }));
    }
}
