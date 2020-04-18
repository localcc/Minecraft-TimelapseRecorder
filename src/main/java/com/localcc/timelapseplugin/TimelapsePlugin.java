package com.localcc.timelapseplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TimelapsePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("starttimelapse").setExecutor(new CommandStartTimelapse());
        this.getCommand("stoptimelapse").setExecutor(new CommandStopTimelapse());
        getServer().getPluginManager().registerEvents( new EventListener(), this);
        getLogger().info("Enabled timelapse plugin!");

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled timelapse plugin!");
    }
}
