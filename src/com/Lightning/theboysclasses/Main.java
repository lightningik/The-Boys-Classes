package com.Lightning.theboysclasses;

import com.Lightning.theboysclasses.items.itemEvents;
import com.Lightning.theboysclasses.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GOLD + "[TBC] Plugin has loaded.");
        Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
        itemManager.init();
        getServer().getPluginManager().registerEvents(new itemEvents(), this);
        Objects.requireNonNull(getServer().getPluginCommand("class")).setExecutor(new GuiCommand());
    }


    @Override
    public void onDisable(){
        getLogger().info(ChatColor.BLUE + "[TBC] Plugin shutting down.");
    }

}
