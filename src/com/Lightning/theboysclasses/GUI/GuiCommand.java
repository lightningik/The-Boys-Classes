package com.Lightning.theboysclasses.GUI;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String s, String[] strings) {

        if(sender instanceof Player) {
            Bukkit.getServer().getPluginManager().callEvent(new GuiEvent((Player) sender));
            return true;
        } else {
            Bukkit.getLogger().info("This command can only be used in game");
        }

        return false;
    }
}