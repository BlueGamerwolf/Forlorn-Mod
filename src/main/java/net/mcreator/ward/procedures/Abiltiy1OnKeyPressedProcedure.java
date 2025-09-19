package net.mcreator.ward.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class Abiltiy1OnKeyPressedProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) return;

        if (entity.getUUID().toString().equals("380df991-f603-344c-a090-369bad2a924a")) {
            BlueGamerwolfYTProcedure.execute(world, x, y, z, entity);

        } else if (entity.getUUID().toString().equals("d07322a7-1862-4b6d-92ea-0ef3ab2a7318")) {
            NickTheClownProcedure.execute(entity);

        } else if (entity.getUUID().toString().equals("9b233ebd-0f97-4ddb-9003-12611bf1ed8d")) {
            RageProcedure.toggleRage(entity);

        } else if (entity.getUUID().toString().equals("27293c84-e600-4290-8aae-348490503253")) {
            if (entity instanceof Player player) {
                NickProcedure.execute(player);
            }

        } else if (entity.getUUID().toString().equals("89aba791-baf1-4686-b622-969d55f75887")) {
            if (world instanceof Level level) {
                BlockPos pos = BlockPos.containing(x, y, z);
                SamProcedure.execute(level, pos); // ✅ correct signature
            }
            PlayersProcedure.execute(world, x, y, z, entity.getUUID());
        }
    }
}
