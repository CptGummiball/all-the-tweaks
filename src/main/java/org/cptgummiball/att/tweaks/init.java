package org.cptgummiball.att.tweaks;

import org.bukkit.plugin.PluginManager;
import org.cptgummiball.att.Main;

public class init {

    private final Main plugin;
    public init(Main plugin) {
        this.plugin = plugin;
    }

    public void initialize() {
        // Überprüfen, ob CropTrample in der Config aktiviert ist
        if (plugin.getConfig().getBoolean("AntiCropTrample", false)) {
            PluginManager pluginManager = plugin.getServer().getPluginManager();
            pluginManager.registerEvents(new CropTrample(), plugin);
            plugin.getLogger().info("AntiCropTrample enabled!");
        } else {
            plugin.getLogger().info("AntiCropTrample feature is disabled in the config.");
        }
        if (plugin.getConfig().getBoolean("GlassDrop", false)) {
            PluginManager pluginManager = plugin.getServer().getPluginManager();
            pluginManager.registerEvents(new GlassDrop(), plugin);
            plugin.getLogger().info("GlassDrop enabled!");
        } else {
            plugin.getLogger().info("GlassDrop feature is disabled in the config.");
        }
        if (plugin.getConfig().getBoolean("Silentmobs", false)) {
            PluginManager pluginManager = plugin.getServer().getPluginManager();
            pluginManager.registerEvents(new SilentMobs(), plugin);
            plugin.getLogger().info("SilentMobs enabled!");
        } else {
            plugin.getLogger().info("SilentMobs feature is disabled in the config.");
        }
        if (plugin.getConfig().getBoolean("ClickHarvest", false)) {
            PluginManager pluginManager = plugin.getServer().getPluginManager();
            pluginManager.registerEvents(new ClickHarvest(), plugin);
            plugin.getLogger().info("ClickHarvest enabled!");
        } else {
            plugin.getLogger().info("ClickHarvest feature is disabled in the config.");
        }
    }
}
