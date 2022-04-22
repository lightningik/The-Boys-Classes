package com.Lightning.theboysclasses.configs;

import com.Lightning.theboysclasses.Main;
import com.Lightning.theboysclasses.powers.firemage;

import java.util.UUID;

public class PlayerConfig extends Config{


    public PlayerConfig(Main main) {
        super(main, "players.yml");
    }

    public firemage getClass(UUID id) {
        return firemage.getClassByName(getString(id.toString() + ".class"));
    }

    public void setClass(UUID id, firemage clazz) {
        set(id + ".class", clazz.getRawName());
    }

}
