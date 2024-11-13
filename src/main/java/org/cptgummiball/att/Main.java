package org.cptgummiball.att;

import org.bukkit.plugin.java.JavaPlugin;
import org.cptgummiball.att.tweaks.init;
import org.cptgummiball.att.utils.ConfigManager;
import org.cptgummiball.att.utils.Translator;

public class Main extends JavaPlugin {

    private init Init;
    private ConfigManager configManager;
    String language = getConfig().getString("language","en-US");
    public Translator translator = new Translator(this, language);

    @Override
    public void onEnable() {
        saveConfig();
        // Initialize ConfigManager
        configManager = new ConfigManager(this);
        configManager.updateConfig();
        // Initialize Tweaks
        Init = new init(this);
        Init.initialize();

        getLogger().info("ATT enabled");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
