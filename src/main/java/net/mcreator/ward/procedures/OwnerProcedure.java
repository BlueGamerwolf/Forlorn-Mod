package net.mcreator.ward.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;

import java.util.UUID;

@Mod.EventBusSubscriber
public class OwnerProcedure {
    private static final UUID OWNER_UUID = UUID.fromString("a1bc8320-401b-43ff-a73f-581ea979e506");
    private static final String OWNER_NAME = "Blue_gamerwolfYT";

    // Runs when player joins the server
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        giveTag(player);
    }

    // Keep the old-style method for block/item usage
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            _level.getServer().getPlayerList().getPlayers().forEach(player -> {
                if (player.getGameProfile().getName().equalsIgnoreCase(OWNER_NAME) ||
                    player.getUUID().equals(OWNER_UUID)) {
                    giveTag(player);
                }
            });
        }
    }

    // Central method to add tag
    private static void giveTag(ServerPlayer player) {
        ServerLevel level = player.serverLevel();
        level.getServer().getCommands().performPrefixedCommand(
            new CommandSourceStack(CommandSource.NULL,
                    new Vec3(player.getX(), player.getY(), player.getZ()),
                    Vec2.ZERO, level, 4, "",
                    Component.literal(""), level.getServer(), null
            ).withSuppressedOutput(),
            "tag " + player.getScoreboardName() + " add warden_god"
        );
    }
}
