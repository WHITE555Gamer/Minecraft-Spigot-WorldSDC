package com.github.white555gamer.worldsdc;

import com.github.white555gamer.worldsdc.assets.commands.WorldSDCC;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldSDC extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WorldSDC Enabled...");
        getServer().broadcastMessage("WorldSDC Enabled...");

        getCommand("worldsdc").setExecutor(new WorldSDCC());
    }

    @Override
    public void onDisable() {
        getLogger().info("WorldSDC Disabled...");
        getServer().broadcastMessage("WorldSDC Disabled...");
    }

    @Override
    public void onLoad() {
        getLogger().info("WorldSDC Loaded...");
        getServer().broadcastMessage("WorldSDC Loaded...");
    }
}
