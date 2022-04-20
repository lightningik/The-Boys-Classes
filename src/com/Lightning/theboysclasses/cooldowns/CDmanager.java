package com.Lightning.theboysclasses.cooldowns;

import java.util.UUID;

import com.Lightning.theboysclasses.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class CDmanager implements Listener {

    private Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onjoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        int cdtime = plugin.getConfig().getInt(uuid + ".Cooldown_Left");

        if (cdtime <= 0) {
            return;
        } else {
            plugin.cdtime.put(uuid, cdtime);
        }
    }

    @EventHandler
    public void onquit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        plugin.getConfig().set(uuid + ".Cooldown_Left", plugin.cdtime.get(uuid));
        plugin.saveConfig();
        plugin.cdtime.remove(uuid);
    }

}