package com.Lightning.theboysclasses;

import com.Lightning.theboysclasses.GUI.Commands;
import com.Lightning.theboysclasses.GUI.GuiCommand;
import com.Lightning.theboysclasses.cooldowns.CDmanager;
import com.Lightning.theboysclasses.items.itemEvents;
import com.Lightning.theboysclasses.items.itemManager;
import com.Lightning.theboysclasses.managers.ConfigManager;
import com.Lightning.theboysclasses.managers.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    private static Logger logger;

    private ConfigManager configManager;
    private ProfileManager profileManager;
    private static Main plugin;
    public static Main getPlugin() {
        return plugin;
    }

    public HashMap<UUID, Integer> cdtime = new HashMap<UUID, Integer>();
    public int mastercd = 5;

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    @Override
    public void onEnable() {
        logger = getLogger();
        configManager = new ConfigManager(this);
        profileManager = new ProfileManager(this);
        configManager.loadConfigs();
        getLogger().info(ChatColor.GOLD + "[TBC] Plugin has loaded.");
        Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
        itemManager.init();
        getServer().getPluginManager().registerEvents(new itemEvents(), this);
        Objects.requireNonNull(getServer().getPluginCommand("class")).setExecutor(new GuiCommand());
        getServer().getPluginManager().registerEvents(new CDmanager(), this);
        loadConfig();
        runnablerunner();
        plugin = this;
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

    private final Map<UUID, List<ItemStack>> keepItems = new HashMap<>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        // Create the List who will store all items to keep for the current dead player (restore on respawn)
        final List<ItemStack> toKeep = new ArrayList<>();

        // Iterate all items in player drops
        for (ItemStack item : e.getDrops())
        {
            // Check if this item has item meta
            if (item.hasItemMeta())
            {
                final ItemMeta meta = item.getItemMeta();
                // Check if item meta has display name and if name is equals to your need
                assert meta != null;
                if (meta.equals(itemManager.BlazeWand.getItemMeta()))
                {
                    // Add the item to the list
                    toKeep.add(item);
                }
            }
        }

        // Check if there is items in the list created before (if there is items to restore on respawn)
        if (!toKeep.isEmpty())
        {
            /*
             *  If yes we remove all items in this list from the drop
             *  and we put the List in the Map using the Player UUID as key
             */
            e.getDrops().removeAll(toKeep);
            keepItems.put(e.getEntity().getUniqueId(), toKeep);
        }


    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e)
    {
        // On respawn we get the List from the Map
        final List<ItemStack> toRestore = keepItems.get(e.getPlayer().getUniqueId());

        // We check if the List "exist" in the Map, if it's equals to null there is not value for this player in map
        if (toRestore != null)
        {
            // We give back to player all items and remove him from the Map
            e.getPlayer().getInventory().addItem(toRestore.toArray(new ItemStack[0]));
            keepItems.remove(e.getPlayer().getUniqueId());
        }
    }


    @Override
    public void onDisable(){
        getLogger().info(ChatColor.BLUE + "[TBC] Plugin shutting down.");
        configManager.saveConfigs();
    }

    @Override
    public static Logger getPluginLogger() {
        return logger;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }
}
