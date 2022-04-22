package com.Lightning.theboysclasses.powers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;

import static com.Lightning.theboysclasses.Utils.decolor;
import static com.Lightning.theboysclasses.powers.Items.*;

public enum firemage {

    DREAMER("&3Dreamer", DREAMER_ICON, DREAMER_ARMOR, DREAMER_SWORD),
    FIREMAGE("&cFire Mage", FIREMAGE_ICON, FIREMAGE_ARMOR, FIREMAGE_WAND);

   private String name, rawName;
   private ItemStack[] armor, items;
   private ItemStack icon;


   firemage(String name, ItemStack icon, ItemStack[] armor, ItemStack... items) {
       this.name = name;
       rawName = decolor(name);
       this.armor = armor;
       this.items = items;
       this.icon = icon;
   }

   public static firemage getClassByName(String name) {
       for (firemage clazz : values()) {
           if (name.equalsIgnoreCase(clazz.getRawName())) {
               return clazz;
           }
       }
       return null;
   }

    public String getName() {
        return name;
    }

    public ItemStack[] getArmor() {
        return armor;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public String getRawName() {
        return rawName;
    }
}
