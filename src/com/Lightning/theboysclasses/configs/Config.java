package com.Lightning.theboysclasses.configs;

import com.Lightning.theboysclasses.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.Lightning.theboysclasses.Utils.log;

public class Config extends YamlConfiguration {

    protected Main main;
    protected String name;
    protected File file;

    public Config(Main main, String name) {
        this.main = main;
        this.name = name;
        file = new File(main.getDataFolder(), name);
    }

    public Set<String> getSection(String path) {
        ConfigurationSection section = getConfigurationSection(path);
        if (section != null) return section.getKeys(false);
        return new HashSet<>();
    }

    private void checkFile() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            main.saveResource(name, false);
        }
    }

    public void loadConfig() {
        checkFile();
        try {
            load(file);
            log("Loaded data from" + name);
        } catch (InvalidConfigurationException | IOException exception) {
            exception.printStackTrace();
            log("Error loading data from" + name);
        }
    }

    public void saveConfig() {
        checkFile();
        try {
            save(file);
            log("Saved data from" + name);
        } catch (IOException exception) {
            exception.printStackTrace();
            log("Error saving data from" + name);
        }
    }


}
