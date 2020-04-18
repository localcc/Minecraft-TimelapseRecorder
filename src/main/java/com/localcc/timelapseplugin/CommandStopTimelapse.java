package com.localcc.timelapseplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CommandStopTimelapse implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            try {
                LogFile.file.end_write();
                Bukkit.broadcastMessage("[TimelapseRecorder]: Stopped recording!");
            } catch (IOException e) {
                Bukkit.broadcastMessage("[TimelapseRecorder]: Failed to stop timelapse!");
            }
            return true;
        }
        return false;
    }
}
