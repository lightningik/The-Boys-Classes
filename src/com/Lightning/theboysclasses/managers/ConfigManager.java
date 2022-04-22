package com.Lightning.theboysclasses.managers;

import com.Lightning.theboysclasses.Main;
import com.Lightning.theboysclasses.configs.Config;
import com.Lightning.theboysclasses.configs.PlayerConfig;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private Main main;
    private List<Config> configs = new ArrayList<>();
    private PlayerConfig playerConfig;

    public ConfigManager(Main main) {
        this.main = main;
        configs.add(playerConfig = new PlayerConfig(main));
    }

    public void loadConfigs() {
        for (Config config : configs) {
            config.loadConfig();
        }
    }

    public void saveConfigs() {
        for (Config config : configs) {
            config.saveConfig();
        }
    }

    public PlayerConfig getPlayerConfig() {
        return playerConfig;
    }
}
