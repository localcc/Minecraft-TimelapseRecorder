package com.localcc.timelapseplugin;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventListener implements Listener {
    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {
        String final_string = BlockStringifierHelper.get_info(event.getBlockPlaced()) + "*p\n";
        if(LogFile.file.isRunning()) {
            try {
                LogFile.file.write_data(final_string);
            } catch (IOException e) {
                Bukkit.broadcastMessage(e.toString());
            }
        }
    }

    @EventHandler
    public void onBlockBroken(BlockBreakEvent event) {
        String final_string = BlockStringifierHelper.get_info(event.getBlock()) + "*b\n";
        if(LogFile.file.isRunning()) {
            try {
                LogFile.file.write_data(final_string);
            } catch (IOException e) {
                Bukkit.broadcastMessage(e.toString());
            }
        }
    }
}
