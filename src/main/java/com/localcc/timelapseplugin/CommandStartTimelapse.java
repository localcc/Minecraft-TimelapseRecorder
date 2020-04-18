package com.localcc.timelapseplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CommandStartTimelapse implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            try {
                LogFile.file.start_write();
                Bukkit.broadcastMessage("[TimelapseRecorder]: Started recording!");
            } catch (IOException e) {
                Bukkit.broadcastMessage("[TimelapseRecorder]: Failed to start timelapse!");
            }
            return true;
        }
        return false;
    }
}
