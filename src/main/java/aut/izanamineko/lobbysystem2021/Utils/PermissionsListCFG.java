package aut.izanamineko.lobbysystem2021.Utils;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PermissionsListCFG {

    public final File permissionslist;

    public final FileConfiguration plcfg;

    public PermissionsListCFG(){
        this.permissionslist = new File("plugins/LobbySystem/permissionslist.yml");
        this.plcfg = (FileConfiguration) YamlConfiguration.loadConfiguration(this.permissionslist);
        addDefaultStrings();
        checkIfExists();
    }

    public File getFile(){
        return this.permissionslist;
    }
    public FileConfiguration getConfig(){
        return this.plcfg;
    }
    public void checkIfExists(){
        if(!this.permissionslist.exists()){
            addDefaultStrings();
        }
    }

    private void addDefaultStrings(){

        List<String> permissions = Arrays.asList("LobbySystem.CommandProtection", "LobbySystem.Lobby", "LobbySystem.SetLobby", "LobbySystem.PlayerLimit.Bypass", "LobbySystem.ChatClear", "LobbySystem.SetWarp", "LobbySystem.Warp", "LobbySystem.DelWarp", "LobbySystem.Reload", "LobbySystem.HelpCMD", "LobbySystem.TeamChat", "LobbySystem.ReceiveBug");
        this.plcfg.addDefault("LobbySystem.Permissions", permissions);
        this.plcfg.options().copyDefaults(true);
        save();
    }

    public void save() {
        try {
            this.plcfg.save(this.permissionslist);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void load() {
        try {
            this.plcfg.load(this.permissionslist);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException iOException) {
            iOException.printStackTrace();
        }
    }
}
