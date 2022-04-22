package com.Lightning.theboysclasses.GUI;

import com.Lightning.theboysclasses.Main;
import com.Lightning.theboysclasses.managers.ProfileManager;
import com.Lightning.theboysclasses.powers.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    private Main main;
    private ProfileManager profileManager;

    public JoinQuitListener(Main main) {
        this.main = main;
        profileManager = main.getProfileManager();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Profile profile = profileManager.getProfile(p.getUniqueId());
        if (profile == null) {
            profile = profileManager.createProfile(p);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

    }
}
