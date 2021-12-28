package aut.izanamineko.lobbysystem2021.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ScoreboardConfigManager {
    public final File sbfile;

    public final FileConfiguration sbconfig;

    public ScoreboardConfigManager(){
        this.sbfile = new File("plugins/LobbySystem/scoreboard.yml");
        this.sbconfig = (FileConfiguration) YamlConfiguration.loadConfiguration(this.sbfile);
        addDefaultStrings();
        checkIfExists();
    }

    public File getFile(){
        return this.sbfile;
    }
    public FileConfiguration getConfig(){
        return this.sbconfig;
    }
    public void checkIfExists(){
        if(!this.sbfile.exists()){
            addDefaultStrings();
        }
    }

    private void addDefaultStrings(){

        this.sbconfig.addDefault("Scoreboard.displayName", "&8[&3LobbySystem&8]");
        this.sbconfig.addDefault("Scoreboard.13",  "&8Server/Hub:");
        this.sbconfig.addDefault("Scoreboard.12",  "&4%server_name%");
        this.sbconfig.addDefault("Scoreboard.11",  "&6");
        this.sbconfig.addDefault("Scoreboard.10",  "&6Your Rank:");
        this.sbconfig.addDefault("Scoreboard.9", "%luckperms_primary_group_name%");
        this.sbconfig.addDefault("Scoreboard.8", "&7");
        this.sbconfig.addDefault("Scoreboard.7", "&6Online:");
        this.sbconfig.addDefault("Scoreboard.6", "%online% / %maxplayer%");
        this.sbconfig.addDefault("Scoreboard.5", "&1");
        this.sbconfig.addDefault("Scoreboard.4", "&2Money:");
        this.sbconfig.addDefault("Scoreboard.3", "&3%vault_eco_balance%");
        this.sbconfig.addDefault("Scoreboard.2", "&4");
        this.sbconfig.addDefault("Scoreboard.1", "&5Test");
        this.sbconfig.addDefault("Scoreboard.0", "&8%vault_rank%");
        List<String> Strings = Arrays.asList("Here are some Strings to use for the Scoreboard", "https://luckperms.net/wiki/Placeholders");
        this.sbconfig.set("Scoreboard.Information", Strings);
        this.sbconfig.options().header("LobbySystem Scoreboard CONFIG by IzanamiNeko");
        this.sbconfig.options().copyDefaults(true);
        save();
    }

    public void save() {
        try {
            this.sbconfig.save(this.sbfile);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void loadScoreboardManager() {
        try {
            this.sbconfig.load(this.sbfile);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException iOException) {
            iOException.printStackTrace();
        }
    }
}

