package org.cptgummiball.att.tweaks;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.cptgummiball.att.Main;

public class init {

    private final Main plugin;
    public init(Main plugin) {
        this.plugin = plugin;
    }

    public void initialize() {
        FileConfiguration config = plugin.getConfig();
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        // register AntiCropTrample Listener
        if (config.getBoolean("AntiCropTrample", false)) {
            pluginManager.registerEvents(new CropTrample(), plugin);
            plugin.getLogger().info("AntiCropTrample enabled!");
        } else {
            plugin.getLogger().info("AntiCropTrample feature is disabled in the config.");
        }

        // register GlassDrop Listener
        if (config.getBoolean("GlassDrop", false)) {
            pluginManager.registerEvents(new GlassDrop(), plugin);
            plugin.getLogger().info("GlassDrop enabled!");
        } else {
            plugin.getLogger().info("GlassDrop feature is disabled in the config.");
        }

        // register SilentMobs Listener
        if (config.getBoolean("Silentmobs", false)) {
            int radius = config.getInt("SilentMobs.Radius");
            int treshold = config.getInt("SilentMobs.MobThreshold");
            pluginManager.registerEvents(new SilentMobs(config), plugin);
            plugin.getLogger().info("SilentMobs enabled! Radius: " + radius + " Treshold: " + treshold);
        } else {
            plugin.getLogger().info("SilentMobs feature is disabled in the config.");
        }

        // register ClickHarvest Listener
        if (config.getBoolean("ClickHarvest", false)) {
            pluginManager.registerEvents(new ClickHarvest(), plugin);
            plugin.getLogger().info("ClickHarvest enabled!");
        } else {
            plugin.getLogger().info("ClickHarvest feature is disabled in the config.");
        }

        // register MoreMobHeads Listener
        if (config.getBoolean("MoreMobHeads.enabled", false)) {
            double dropChance = config.getDouble("MoreMobHeads.DropChance", 5.0);
            pluginManager.registerEvents(new MoreMobHeads(config), plugin);
            plugin.getLogger().info("MoreMobHeads enabled! Drop chance: " + dropChance + "%");
        } else {
            plugin.getLogger().info("MoreMobHeads feature is disabled in the config.");
        }

        // register PlayerHeadDrops Listener
        if (config.getBoolean("PlayerHeadDrops.enabled", false)) {
            double dropChance = config.getDouble("PlayerHeadDrops.DropChance", 5.0);
            pluginManager.registerEvents(new PlayerHeadDrops(config), plugin);
            plugin.getLogger().info("PlayerHeadDrops enabled! Drop chance: " + dropChance + "%");
        } else {
            plugin.getLogger().info("PlayerHeadDrops feature is disabled in the config.");
        }
    }
}
