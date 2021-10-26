package aut.izanamineko.lobbysystem2021;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private main plugin = main.getPlugin(main.class);


    public FileConfiguration messagesyscfg;
    public File messagecfg;

    //Config Setup
    public void MessagesCFGsetup(){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }

        messagecfg = new File(plugin.getDataFolder(), "Messages.yml");
        if(!messagecfg.exists()){
            try{
                messagecfg.createNewFile();
            } catch(IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create the Messages.yml file");
            }
        }
        messagesyscfg = YamlConfiguration.loadConfiguration(messagecfg);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Messages.yml has been created!");
    }
    //----------------------------------------------------------------------------------------------------------------------

    public FileConfiguration getMessagesCFG(){
        return messagesyscfg;
    }

    public void saveMessagesCFG(){
        try{
            messagesyscfg.save(messagecfg);
        } catch (IOException e){
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the Messages.yml file");
        }
    }

    public void reloadMessagesCFG(){
        messagesyscfg = YamlConfiguration.loadConfiguration(messagecfg);
    }

}
