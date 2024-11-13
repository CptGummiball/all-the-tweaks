package org.cptgummiball.att.utils;


import org.bukkit.configuration.file.YamlConfiguration;
import org.cptgummiball.att.Main;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfigManager {

    private final Main plugin;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
    }

    public void updateConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        String currentVersion = "1.1";
        String configVersion = config.getString("version", "0");

        if (configVersion.equals("0") || configVersion.compareTo(currentVersion) < 0) {
            YamlConfiguration newConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(plugin.getResource("config.yml")));
            for (String key : config.getKeys(true)) {
                if (newConfig.contains(key)) {
                    newConfig.set(key, config.get(key));
                }
            }
            newConfig.set("version", currentVersion);
            try {
                newConfig.save(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}