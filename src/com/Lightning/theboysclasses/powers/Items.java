package com.Lightning.theboysclasses.powers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.Lightning.theboysclasses.Utils.createArmor;
import static com.Lightning.theboysclasses.Utils.createItem;

public class Items {

    public static final ItemStack DREAMER_ICON = createItem(Material.ELYTRA, 1, true, true, "&3Dreamer", "&dThe class of &lDreamers"), FIREMAGE_ICON = createItem(Material.BLAZE_POWDER, 1, true, true , "&cThe Fire Mages of Hell", "They came from a firey abyss"), SNOW_ICON = createItem(Material.SNOW_BLOCK, 1, true, true, "Snow Sorcerer", "&bA heaver hitter.");

    public static final ItemStack[] DREAMER_ARMOR = createArmor(createItem(Material.LEATHER_HELMET, 1, true, true, "Dreamer's Helmet", "The helmet given to the one chosen to be Dreamer"), createItem(Material.LEATHER_CHESTPLATE, 1, true, true,
            "Dreamer's Chestplate", "The Chestplate given to the one chosen to be Dreamer"), createItem(Material.LEATHER_LEGGINGS, 1, true, true, "Dreamer's Leggings", "The leggings given to the one chosen to be Dreamer"),
            createItem(Material.LEATHER_BOOTS, 1, true, true, "Dreamer's Boots", "The boots given to the one chosen to be Dreamer")), FIREMAGE_ARMOR = createArmor(createItem(Material.LEATHER_HELMET, 1, true, true, "Fire Mage's Helmet", "The " +
            "helmet" +
            " " +
            "helmet given to the one born as a mage of fire."), createItem(Material.LEATHER_CHESTPLATE, 1, true, true, "Fire Mage's Chestplate", "The Chestplate given to the one born as a mage of fire."), createItem(Material.LEATHER_LEGGINGS, 1,
            true,
            true, "Fire Mage's " +
                    "Leggings",
            "The " +
            "leggings" +
            " " +
            "given to the one born as a mage of fire."), createItem(Material.LEATHER_BOOTS, 1, true, true, "Fire Mage's Boots", "The boots given to the one born as a mage of fire."));


    public static final ItemStack DREAMER_SWORD = createItem(Material.DIAMOND_SWORD, 1, false, true, "Dreamer's Sword"), FIREMAGE_WAND = createItem(Material.BLAZE_ROD, 1, true, true, "Fire Mage's Wand", "&cCan create fireballs");
}
