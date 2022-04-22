package com.Lightning.theboysclasses.managers;

import com.Lightning.theboysclasses.Main;
import com.Lightning.theboysclasses.configs.PlayerConfig;
import com.Lightning.theboysclasses.powers.Profile;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private Main main;
    private PlayerConfig playerConfig;
    private Map<UUID, Profile> profiles = new HashMap<>();

    public ProfileManager(Main main) {
        this.main = main;
        main.getConfigManager().getPlayerConfig();
    }

    public void loadProfiles() {

    }

    public void saveProfiles() {
        for (UUID uuid : profiles.keySet()) {
            Profile profile = profiles.get(uuid);
            playerConfig.setClass(uuid, profile.getClazz());
        }
    }

    public Profile createProfile(Player player) {
        Profile profile = new Profile(null);
        profiles.put(player.getUniqueId(), profile);
        return profile;
    }

    public Profile getProfile(UUID uuid) {
        return profiles.get(uuid);
    }
}
