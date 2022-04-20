package com.Lightning.theboysclasses.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager {

    public static void init() {
        createBlazeWand();
    }

    private static void createBlazeWand() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Flame Wand");
        List<String> lore = new ArrayList<>();
        lore.add("The wand only given to the Flame Mages");
        meta.setLore(lore);
        item.setItemMeta(meta);
        BlazeWand = item;

    }

    public static ItemStack BlazeWand;

}
