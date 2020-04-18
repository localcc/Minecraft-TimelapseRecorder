package com.localcc.timelapseplugin;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;

import java.sql.Timestamp;
import java.util.Date;

public class BlockStringifierHelper {
    static String get_info(Block block) {
        String world_name = block.getWorld().getName();
        int x = block.getX(), y = block.getY(), z = block.getZ();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        String timestamp_str = Statics.sdf.format(timestamp);
        String id = block.getBlockData().getAsString();
        return world_name + "*" + timestamp_str + "*" + x + "*" + y + "*" + z + "*" + id;
    }
}
