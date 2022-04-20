package com.Lightning.theboysclasses;

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
        meta.setDisplayName(ChatColor.RED + "Fire Mage");
        item.setItemMeta(meta);

        gui.setItem(12, item);

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
        if (clickedItem == item)
            p.getInventory().addItem(itemManager.BlazeWand);
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
