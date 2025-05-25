package com.example.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class MainMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // コマンド登録
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            JoinCommand.register(dispatcher);
        });
    }
}
