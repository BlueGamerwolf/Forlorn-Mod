package net.mcreator.ward.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.UUID;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ability3OnKeyPressedProcedure {

    // Admins who can toggle flight
    private static final List<UUID> ModAdminUUID = Arrays.asList(
        UUID.fromString("a1bc8320-401b-43ff-a73f-581ea979e506") // Owner/Admin
    );

    // Users whose flight can be toggled
    private static final List<UUID> RestrictedUUID = Arrays.asList(
        UUID.fromString("89aba791-baf1-4686-b622-969d55f75887") // Restricted flight user
    );

    // Tracks users whose flight is currently disabled
    private static final Set<UUID> FlightDisabled = new HashSet<>();

    public static void execute(Entity executor) {
        if (!(executor instanceof Player execPlayer)) return;

        UUID executorUUID = execPlayer.getUUID();

        // Only admins can toggle flight
        if (!ModAdminUUID.contains(executorUUID)) return;

        if (executor.level() == null) return;

        for (Entity e : executor.level().players()) {
            if (e instanceof Player targetPlayer) {
                UUID targetUUID = targetPlayer.getUUID();

                if (RestrictedUUID.contains(targetUUID)) {
                    boolean currentlyDisabled = FlightDisabled.contains(targetUUID);

                    if (currentlyDisabled) {
                        // Re-enable flight
                        targetPlayer.getAbilities().mayfly = true;
                        FlightDisabled.remove(targetUUID);
                        targetPlayer.displayClientMessage(
                            Component.literal("Your flight was restored by an admin."), true
                        );
                    } else {
                        // Disable flight
                        targetPlayer.getAbilities().mayfly = false;
                        targetPlayer.getAbilities().flying = false;
                        FlightDisabled.add(targetUUID);
                        String message = executorUUID.equals(UUID.fromString("a1bc8320-401b-43ff-a73f-581ea979e506"))
                                ? "Your flight was removed by the Forlorn mod Owner."
                                : "Your flight was removed by a Mod Admin.";
                        targetPlayer.displayClientMessage(Component.literal(message), true);
                    }

                    targetPlayer.onUpdateAbilities();
                }
            }
        }
    }
}
