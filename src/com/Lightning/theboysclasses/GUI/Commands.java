package com.Lightning.theboysclasses.GUI;

import com.Lightning.theboysclasses.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements Listener {

    private Inventory gui;
    ItemStack item = new ItemStack(Material.BLAZE_POWDER);
    ItemStack item2 = new ItemStack(Material.ELYTRA);

    public void openNewGui(Player p) {
        gui = Bukkit.createInventory(null, 54, "Pick Your Class");



        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD  + "Fire Mage");
        item.setItemMeta(meta);

        ItemMeta meta2 = item.getItemMeta();
        assert meta2 != null;
        meta2.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Dreamer");
        item2.setItemMeta(meta2);

        gui.setItem(12, item);
        gui.setItem(14, item2);

        p.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != gui) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        if (clickedItem.getType() == Material.BLAZE_POWDER) {
            p.getInventory().addItem(itemManager.BlazeWand);
        }

        if (clickedItem.getType() == Material.ELYTRA) {
            p.getInventory().addItem(itemManager.BlazeWand);
        }
    }

    @EventHandler
    public void openGuiEvent(GuiEvent e) {
        openNewGui(e.getPlayer());
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(gui)) {
            e.setCancelled(true);
        }
    }



}
