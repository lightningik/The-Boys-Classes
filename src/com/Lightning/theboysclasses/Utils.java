package com.Lightning.theboysclasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Utils {
    private static Logger logger = Main.getPluginLogger();

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String decolor(String string) {
        return ChatColor.stripColor(color(string));
    }

    public static void log(String... strings) {
        for (String string : strings) {
            logger.info(string);
        }
    }

    public static void  msgPlayer(Player player, String... strings) {
        for (String string : strings) {
            player.sendMessage(color(string));
        }
    }

    public static ItemStack createItem(Material material, int amount, boolean glow, boolean unb, String name, String... lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        if (name != null) {
            meta.setDisplayName(color(name));
        }
        if (lore != null) {
            List<String> list = new ArrayList<>();
            for(String string : lore) {
                list.add(color(string));
            }
            meta.setLore(list);
        }
        if (glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        if (unb) {
            meta.setUnbreakable(true);
        }
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack[] createArmor(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        ItemStack[] armor = new ItemStack[4];
        armor[3] = helmet;
        armor[2] = chestplate;
        armor[1] = leggings;
        armor[0] = boots;
        return armor;
    }
}
