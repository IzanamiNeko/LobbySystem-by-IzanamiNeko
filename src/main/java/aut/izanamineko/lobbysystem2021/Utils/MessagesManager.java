package aut.izanamineko.lobbysystem2021.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class MessagesManager {

    public final File file;

    public final FileConfiguration config;

    public MessagesManager(){
        this.file = new File("plugins/LobbySystem2021/messages.yml");
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

        this.config.addDefault("Messages.WarpSystem.SetCMD", "&8[&3LobbySystem&8] &7Use /setwarp [warpname]!");
        this.config.addDefault("Messages.WarpSystem.WarpCMD", "&8[&3System&8] &7Use /warp [warpname]!");
        this.config.addDefault("Messages.WarpSystem.SetWarp", "&8[&3System&8] &7The Warp &4%warpname% &7has been set!");
        this.config.addDefault("Messages.WarpSystem.DelWarp", "&8[&3System&8] &7The Warp &4%warpname% &7has been deleted!");
        this.config.addDefault("Messages.WarpSystem.NoWarp", "&8[&3System&8] &7There is no Warp called &4%warpname%!");
        this.config.addDefault("Messages.WarpSystem.Warped", "&8[&3System&8] &7You've been warped!");
        this.config.addDefault("Messages.WarpSystem.WarpExists", "&8[&3System&8] &7The Warp &4%warpname% &7exists already!");
        this.config.addDefault("Messages.General.NoPermissions", "&8[&3System&8] &7You dont have permissions... &4[ &c%player% &4]");
        this.config.addDefault("Messages.General.Ping", "&8[&3System&8] &7You have a Ping of %ms% ms");
        this.config.addDefault("Messages.General.Reload", "&8[&3System&8] &7LobbySystem2021 has been reloaded! (only the config.yml)");
        this.config.addDefault("Messages.BugCMD.Usage", "&8[&3System&8] &7Use /bug <bug to report> to report a Bug");
        this.config.addDefault("Messages.BugCMD.ID-Message", "&8[&3System&8] &c%player% &7reported a Bug with the ID %id%");
        this.config.addDefault("Messages.BugCMD.BugReported", "&8[&3System&8] &7Your bug has been reported, please save this ID %id%");
        this.config.addDefault("Messages.Spawn.DoesntExist", "&8[&3System&8] &c%player% &7reported a Bug with the ID %id%\"");
        this.config.addDefault("Messages.Spawn.Permission", "&8[&3System&8] &7You don't have any Permissions");
        this.config.addDefault("Messages.Quit.Message", "&8[&3System&8] &7Goodbye %player%");
        this.config.addDefault("Messages.Join.Message", "&8[&3System&8] &7Welcome %player%");
        this.config.addDefault("Messages.Join.Sound", "ENTITY_FIREWORK_ROCKET_LARGE_BLAST");
        this.config.addDefault("Messages.HelpList.Line1", "&c----------- &6[LobbySystem] &c-----------");
        this.config.addDefault("Messages.HelpList.Line2", "TEST");
        this.config.addDefault("Messages.HelpList.Line3", "TEST");
        this.config.addDefault("Messages.HelpList.Line4", "TEST");
        this.config.addDefault("Messages.HelpList.Line5", "TEST");
        this.config.addDefault("Messages.HelpList.Line6", "TEST");
        this.config.addDefault("Messages.HelpList.Line7", "TEST");
        this.config.addDefault("Messages.HelpList.Line8", "TEST");
        this.config.addDefault("Messages.HelpList.Line9", "&c----------- &6[LobbySystem] &c-----------");
        this.config.addDefault("Messages.AntiPlugin.Message", "&8[&3System&8] &7Nice try! Good luck, next time!");
        this.config.addDefault("Messages.ChatClear.Message", "&8[&3System&8] &7Chat has been cleared!");
        this.config.addDefault("Messages.Chat-Format.Format", "%luckperms_prefix% %player_name%:");
        this.config.options().header("LobbySystem2021 MESSAGES CONFIG by IzanamiNeko");
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
