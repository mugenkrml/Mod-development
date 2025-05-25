package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

public class MainMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            JoinCommand.register(dispatcher);
        });
    }
}
// This is the main class for the Fabric mod that registers the join command.
// It implements ModInitializer and registers the command using CommandRegistrationCallback.