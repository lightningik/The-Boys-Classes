package com.Lightning.theboysclasses.items;

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
    private HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();
    private int cooldowntime = 5;

    @EventHandler
    public static void onLeftClick(PlayerInteractEvent event) {
        Player p = event.getPlayer()
        if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (cooldown.containsKey(p.getUniqueId())) {
                long secondsleft - ((cooldown.get(p.getUniqueId())) / 1000 + cooldowntime) - (System.currentTimeMillis() / 1000);
                if (secondsleft > 0) {
                    p.sendMessage(ChatColor.RED + "You can't use that for another" + secondsleft + " seconds");
                }
                else {
                    if (event.getItem() != null) {
                        if (Objects.requireNonNull(event.getItem().getItemMeta()).equals(itemManager.BlazeWand.getItemMeta())) {
                            Player player = event.getPlayer();
                            player.launchProjectile(Fireball.class);
                        }
                    }
                }
            }
        }
    }


}
