package net.mcreator.ward.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class NickTheClownProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			// Grant flight ability
			_player.getAbilities().mayfly = true;
			_player.onUpdateAbilities();
			
			// Prevent fall damage by setting fall distance to 0
			_player.fallDistance = 0.0F;
		}
	}
}
