package com.Lightning.theboysclasses.GUI;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GuiEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    Player player;

    public Player getPlayer() {
        return this.player;
    }

    public GuiEvent(Player player) {
        this.player = player;
    }

    public static HandlerList getHANDLERS() {
        return HANDLERS;
    }


    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}