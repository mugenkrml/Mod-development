package com.example;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.server.world.ServerWorld;

import static net.minecraft.server.command.CommandManager.literal;

public class JoinCommand {

    private static final int WAIT_X = 100;
    private static final int WAIT_Y = 65;
    private static final int WAIT_Z = 100;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("join")
            .executes(context -> {
                ServerCommandSource source = context.getSource();
                ServerPlayerEntity player = source.getPlayer();

                if (player == null) {
                    source.sendFeedback(Text.literal("このコマンドはプレイヤー専用です。"), false);
                    return 0;
                }

                ServerWorld world = player.getServerWorld();

                player.teleport(world, WAIT_X, WAIT_Y, WAIT_Z, player.getYaw(), player.getPitch());

                player.sendTitle(
                    Text.literal("待機中..."),
                    Text.literal("PvP開始までお待ちください"),
                    10, 70, 20
                );

                source.sendFeedback(Text.literal(player.getName().getString() + " さんを待機場所へ移動しました。"), true);

                return 1;
            })
        );
    }
}
