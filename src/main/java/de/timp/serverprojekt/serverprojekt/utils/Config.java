package de.timp.serverprojekt.serverprojekt.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private final File file;
    private final YamlConfiguration config;

    public Config() {
        File dir = new File("./plugins/ServerProjekt/");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        this.file = new File(dir, "backpacks.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void reload() {
        try {
            config.save(file);
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            System.out.println(PREFIX.ERROR + "§cDie Config konnte nicht neu geladen werden!");
        }
    }
}
