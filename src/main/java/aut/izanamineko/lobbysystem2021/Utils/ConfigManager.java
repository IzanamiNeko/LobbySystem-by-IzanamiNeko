package aut.izanamineko.lobbysystem2021.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public final File file;

    public final FileConfiguration config;

    public ConfigManager(){
        this.file = new File("plugins/LobbySystem/messages.yml");
        this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
        addDefaultStrings();
        checkIfExists();
    }

    public File getFile(){
        return this.file;
    }
    public FileConfiguration getConfig(){
        return this.config;
    }
    public void checkIfExists(){
        if(!this.file.exists()){
            addDefaultStrings();
        }
    }

    private void addDefaultStrings(){

        this.config.options().header("LobbySystem2021 by IzanamiNeko");
        this.config.addDefault("Config.Join.Show", "false");
        this.config.addDefault("Config.Quit.Show", "false");
        this.config.addDefault("Config.ChatClear.Enabled", "false");
        this.config.addDefault("Config.ChatClear.AllChat", "true");
        this.config.addDefault("Config.ChatClear.PlayerChat", "false");
        this.config.addDefault("Config.AntiPlugin.Enabled", "false");
        this.config.addDefault("Config.HelpList.Enabled", "false");
        this.config.addDefault("Config.TeamChat.Enabled", "true");
        this.config.addDefault("Config.TeamChat.Prefix", "&e[&bTeamChat&e] %player%  >> &r");
        this.config.addDefault("Config.Chat-Format.Enabled", "true");
        this.config.addDefault("Config.DoubleJump.Enabled", "true");
        this.config.addDefault("Config.Warplist.Color", "&2");
        this.config.options().header("LobbySystem CONFIG by IzanamiNeko");
        this.config.options().copyDefaults(true);
        save();
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void load() {
        try {
            this.config.load(this.file);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException iOException) {
            iOException.printStackTrace();
        }
    }
}
