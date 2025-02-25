package net.mcreator.ward.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;

public class SnapProcedure {

    public static void execute(ServerPlayer player) {
        if (player == null) {
            return;
        }

        player.sendSystemMessage(Component.literal("Select Snap Type: \n1. Kill All Players (Requires 50 XP Levels) \n2. Kill All Wardens (Requires Nether Star) \n3. Recreate Universe (Requires 5 Dragon Eggs)"));
    }

    public static void performSnapAction(ServerPlayer player, int snapType) {
        MinecraftServer server = player.getServer();
        if (server == null) return;
        
        switch (snapType) {
            case 1: // Kill all players (Requires 50 XP Levels)
                if (player.experienceLevel >= 50) {
                    player.giveExperienceLevels(-50);
                    for (ServerPlayer target : server.getPlayerList().getPlayers()) {
                        target.sendSystemMessage(Component.literal(target.getDisplayName().getString() + " dusted away"));
                        target.kill();
                    }
                } else {
                    player.sendSystemMessage(Component.literal("You need at least 50 XP levels to perform this snap!"));
                }
                break;

            case 2: // Kill all wardens (Requires Nether Star)
                if (player.getInventory().contains(new ItemStack(Items.NETHER_STAR))) {
                    player.getInventory().removeItem(new ItemStack(Items.NETHER_STAR));
                    server.getPlayerList().broadcastSystemMessage(Component.literal("I am Iron-Man"), false);
                    server.overworld().getEntities().forEach(entity -> {
                        if (entity.getType().toString().equals("minecraft:warden")) {
                            entity.kill();
                        }
                    });
                } else {
                    player.sendSystemMessage(Component.literal("You need a Nether Star to perform this snap!"));
                }
                break;

            case 3: // Recreate the universe (Requires 5 Dragon Eggs)
                if (player.getInventory().countItem(Items.DRAGON_EGG) >= 5) {
                    player.getInventory().removeItem(new ItemStack(Items.DRAGON_EGG, 5));
                    ServerLevel overworld = server.overworld();
                    overworld.getGameRules().getRule(GameRules.MOB_GRIEFING).set(false, server); // Corrected rule name
                    overworld.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, server);
                    overworld.getGameRules().getRule(GameRules.RULE_WEATHER_CYCLE).set(false, server);
                    overworld.getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(true, server);
                    server.getPlayerList().broadcastSystemMessage(Component.literal("The universe has been recreated!"), false);
                } else {
                    player.sendSystemMessage(Component.literal("You need 5 Dragon Eggs to perform this snap!"));
                }
                break;
        }
    }
}
