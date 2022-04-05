package de.timp.serverprojekt.serverprojekt.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LocationConfig {

    private final File file1;
    private final YamlConfiguration config1;

    public LocationConfig() {
        File dir = new File("./plugins/ServerProjekt/");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        this.file1 = new File(dir, "location.yml");

        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config1 = YamlConfiguration.loadConfiguration(file1);
    }

    public File getFile() {
        return file1;
    }

    public YamlConfiguration getConfig() {
        return config1;
    }

    public void save() {
        try {
            config1.save(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void reload() {
        try {
            config1.save(file1);
            config1.load(file1);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            System.out.println(PREFIX.ERROR + "§cDie Config konnte nicht neu geladen werden!");
        }
    }
}
