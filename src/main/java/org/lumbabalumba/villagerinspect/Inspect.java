package org.lumbabalumba.villagerinspect;

import org.bukkit.Color;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Inspect implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length != 4) {
            sender.sendMessage("This command takes 4 arguments: " + Color.YELLOW + "/villagerinspect [x], [y], [z], [radius]");
            return false;
        }

        float x = Float.parseFloat(args[0]), y = Float.parseFloat(args[1]), z = Float.parseFloat(args[2]), r = Float.parseFloat(args[3]);
        int res = 0;
        for (World world : sender.getServer().getWorlds()) {
            for (Entity e : world.getEntities()) {
                if (e instanceof Mob & e.getType() == EntityType.VILLAGER & (e.getLocation().getX() * x + e.getLocation().getY() * y + e.getLocation().getZ() * z <= r * r)) {
                    ++res;
                }
            }
        }

        sender.sendMessage("There are " + Color.YELLOW + res + Color.WHITE + " villagers near point you selected");
        return true;
    }
}
