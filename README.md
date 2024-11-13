# ATT - All the Tweaks

**ATT - All the Tweaks** is a powerful Spigot and PaperMC plugin that adds a variety of useful tweaks and enhancements to your Minecraft server. Based on the popular **Vanilla Tweaks**, this plugin goes beyond by providing additional customization options to enrich your gameplay experience.

## Features

- Compatible with **Spigot** and **PaperMC** starting from **version 1.21**.
- Adds a wide range of **tweaks** and **configurable options** to enhance the Minecraft experience.
- Based on the well-known **Vanilla Tweaks** with additional custom features.

## Installation

1. Download the latest release of **ATT - All the Tweaks** from the [releases section](https://github.com/CptGummiball/all-the-tweaks/releases).
2. Place the `.jar` file into the `plugins` folder of your Spigot or PaperMC server.
3. Restart your server.
4. Configure the plugin settings in the `plugins/ATT` folder if needed.

## Configuration

The plugin comes with a configuration file where you can enable or disable specific tweaks. You can find the configuration files in the `plugins/ATT` directory. Each tweak has its own settings that can be adjusted to your needs.

## Tweak List

Below is a list of all the available tweaks that **ATT - All the Tweaks** offers.

### ClickHarvest

- **Description**: Harvests fully grown crops with a single click and automatically replants them.
- **Config Option**: ClickHarvest (default: false)

### CropTrample

- **Description**: Prevents crops from being trampled by players and mobs.
- **Config Option**: CropTrample (default: false)

### GlassDrop

- **Description**: Prevents glass from breaking on destruction, allowing it to drop as an item instead.
- **Config Option**: GlassDrop (default: false)

### Silent Mobs

- **Description**: Silences large groups of mobs (e.g., in mob farms) to reduce noise pollution. When there are more mobs than a specified threshold within a set radius, those mobs will become silent.
- **Config Options**:
    - `SilentMobs.enabled` (default: false): Enables or disables the feature that silences mobs in high-density areas.
    - `SilentMobs.MobThreshold` (default: 10): The number of mobs in proximity before they are silenced. Lower values will silence mobs more often.
    - `SilentMobs.Radius` (default: 5): The radius around the mob spawn point to check for nearby mobs to silence. Higher values will check a larger area.

### More Mob Heads

- **Description**: Allows mobs to drop their heads when killed. The chance of a mob dropping its head can be customized in the config.
- **Config Options**:
    - `MoreMobHeads.enabled` (default: false): Enables or disables the feature that allows mobs to drop their heads when killed.
    - `MoreMobHeads.DropChance` (default: 5.0): The chance (in percentage) for a mob to drop its head when killed.

### Player Head Drops

- **Description**: Allows players to drop their heads when killed by mobs or other players. The chance of a player dropping their head can be customized in the config.
- **Config Options**:
    - `PlayerHeadDrops.enabled` (default: false): Enables or disables the feature that allows players to drop their heads when killed.
    - `PlayerHeadDrops.DropChance` (default: 5.0): The chance (in percentage) for a player to drop their head when killed by mobs or other players.


### More Tweaks Coming Soon

Additional tweaks will be added before the official release to enhance functionality and customization.


## Commands

| Command                | Description                          |
|------------------------|--------------------------------------|
| `/att reload`           | Reloads the plugin configuration.   |
| `/att tweaks list`      | Displays a list of all available tweaks. |

## Permissions

| Permission             | Description                          |
|------------------------|--------------------------------------|
| `att.reload`            | Allows the user to reload the plugin configuration. |
| `att.tweaks.*`          | Grants access to all tweak-related commands. |

## Compatibility

- Tested with **Spigot** and **PaperMC** 1.21 and later.
- May work on older versions, but not guaranteed.

## Support

If you have any issues or questions, feel free to open an issue on the [GitHub repository](https://github.com/CptGummiball/all-the-tweaks/issues).

## License

This plugin is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Credits

- Inspired by **Vanilla Tweaks**.
- Thanks to the Spigot and PaperMC communities for their contributions.

---

*ATT - All the Tweaks* is developed and maintained by [CptGummiball].
