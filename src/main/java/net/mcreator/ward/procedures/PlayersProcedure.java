package net.mcreator.ward.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.HashMap;
import java.util.UUID;

public class PlayersProcedure {
	// A static map to store cooldowns for each player (or globally if no player is involved)
	private static final HashMap<UUID, Long> cooldownMap = new HashMap<>();
	private static final long COOLDOWN_TIME = 3600 * 1000; // 1 hour in milliseconds

	public static void execute(LevelAccessor world, double x, double y, double z, UUID playerUUID) {
		// Check if the world is a ServerLevel
		if (world instanceof ServerLevel _level) {
			// Get the current system time
			long currentTime = System.currentTimeMillis();

			// Check if the playerUUID exists in the cooldown map
			if (cooldownMap.containsKey(playerUUID)) {
				long lastExecutionTime = cooldownMap.get(playerUUID);

				// Check if the cooldown has expired
				if (currentTime - lastExecutionTime < COOLDOWN_TIME) {
					// Cooldown not expired, send a message to the player or do nothing
					_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
								Component.literal("Command is on cooldown!"), _level.getServer(), null).withSuppressedOutput(),
						""); // No command execution
					return;
				}
			}

			// Cooldown expired or first-time execution
			cooldownMap.put(playerUUID, currentTime); // Update the cooldown time

			// Execute the command
			_level.getServer().getCommands().performPrefixedCommand(
					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
							Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"summon ender_dragon");
		}
	}
}
