package com.Lightning.theboysclasses.items;

import com.Lightning.theboysclasses.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class itemEvents implements Listener {

    private Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        UUID uuid = p.getUniqueId();
        if (plugin.cdtime.containsKey(uuid)) {
            p.sendMessage(ChatColor.RED + "You can't use that for another " + ChatColor.YELLOW + plugin.cdtime.get(uuid) + ChatColor.RED + " seconds.");
        } else {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getItem() != null) {
                    if (Objects.requireNonNull(event.getItem().getItemMeta()).equals(itemManager.BlazeWand.getItemMeta())) {
                        plugin.cdtime.put(uuid, plugin.mastercd);
                        Player player = event.getPlayer();
                        player.launchProjectile(Fireball.class);
                    }
                }
            }
        }
    }
}
