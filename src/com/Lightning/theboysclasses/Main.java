package com.Lightning.theboysclasses;

import com.Lightning.theboysclasses.cooldowns.CDmanager;
import com.Lightning.theboysclasses.items.itemEvents;
import com.Lightning.theboysclasses.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class Main extends JavaPlugin {

    public HashMap<UUID, Integer> cdtime = new HashMap<UUID, Integer>();
    public int mastercd = 5;

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GOLD + "[TBC] Plugin has loaded.");
        Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
        itemManager.init();
        getServer().getPluginManager().registerEvents(new itemEvents(), this);
        Objects.requireNonNull(getServer().getPluginCommand("class")).setExecutor(new GuiCommand());
        getServer().getPluginManager().registerEvents(new CDmanager(), this);
        loadConfig();
        runnablerunner();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void runnablerunner() {
        new BukkitRunnable() {

            @Override
            public void run() {

                if (cdtime.isEmpty()) {
                    return;
                }

                for (UUID uuid : cdtime.keySet()) {
                    int timeleft = cdtime.get(uuid);

                    if (timeleft <= 0) {
                        cdtime.remove(uuid);
                    }else{
                        cdtime.put(uuid, timeleft - 1);
                    }
                }

            }

        }.runTaskTimer(this, 0, 20);
    }


    @Override
    public void onDisable(){
        getLogger().info(ChatColor.BLUE + "[TBC] Plugin shutting down.");
    }

}
