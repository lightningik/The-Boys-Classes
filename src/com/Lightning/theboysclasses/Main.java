package com.Lightning.theboysclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GOLD + "[TBC] Plugin has loaded.");
    }


    @Override
    public void onDisable(){
        getLogger().info(ChatColor.BLUE + "[TBC] Plugin shutting down.");
    }

}
