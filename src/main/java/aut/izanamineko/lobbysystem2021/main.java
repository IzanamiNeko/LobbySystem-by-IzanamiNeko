package aut.izanamineko.lobbysystem2021;


import aut.izanamineko.lobbysystem2021.SpawnSystem.Respawn;
import aut.izanamineko.lobbysystem2021.SpawnSystem.SetSpawn;
import aut.izanamineko.lobbysystem2021.SpawnSystem.Spawn;
import aut.izanamineko.lobbysystem2021.TabScore.TabBar;
import aut.izanamineko.lobbysystem2021.TabScore.updateTablist;
import aut.izanamineko.lobbysystem2021.Utils.ChatFormatter;
import aut.izanamineko.lobbysystem2021.Utils.ConfigManager;
import aut.izanamineko.lobbysystem2021.Utils.PermissionsListCFG;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.WarpSystem.DelWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.SetWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.Warp;
import aut.izanamineko.lobbysystem2021.WarpSystem.WarpList;
import aut.izanamineko.lobbysystem2021.commands.*;
import aut.izanamineko.lobbysystem2021.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class main extends JavaPlugin {

    private static main instance;

    private MessagesManager mm = new MessagesManager();
    private PermissionsListCFG plcfg = new PermissionsListCFG();
    private ConfigManager cm = new ConfigManager();







    @Override
    public void onEnable() {        //Beim Start wird alles was in onEnable steht ausgeführt
        Bukkit.getLogger().info(ChatColor.GREEN + "LobbySystem V2021 is starting....");
        Bukkit.getLogger().info(ChatColor.RED +  "For a full placeholder support, use PlaceholderAPI and the PlaceholderExpansion");

        createBugDirectory();
        loadCommands();
        loadListener();
        //loadConfig();
    }


    @Override
    public void onDisable() {       //Beim Stoppen wird alles was in onDisable steht ausgeführt
        Bukkit.getLogger().info(ChatColor.RED + "LobbySystem V2021 is stopping....");


    }



    private void loadListener() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JQEvent(), this);
        pm.registerEvents(new Respawn(this), this);
        pm.registerEvents(new BypassLimit(), this);
        //pm.registerEvents(new AntiPlugin(), this);
        pm.registerEvents(new TeamChat(), this);
        //pm.registerEvents(new bScoreboard(this), this);
        pm.registerEvents(new updateTablist(this), this);
        pm.registerEvents(new TabBar(), this);
        pm.registerEvents(new ChatFormatter(), this);
    }

    private void loadCommands() {
        getCommand("setwarp").setExecutor(new SetWarp(this));
        getCommand("warp").setExecutor(new Warp(this));
        getCommand("delwarp").setExecutor(new DelWarp(this));
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("chatclear").setExecutor(new ChatClear());
        getCommand("cc").setExecutor(new ChatClear());
        getCommand("lobbysystem").setExecutor(new ReloadCMD());
        getCommand("ls").setExecutor(new ReloadCMD());
        getCommand("ping").setExecutor(new PingCMD( this));
        getCommand("bug").setExecutor(new BugCMD(this));
        getCommand("warplist").setExecutor(new WarpList());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("repair").setExecutor(new RepairCommand());
    }

   /* private void loadConfig()
    {
        getConfig().options().header("LobbySystem2021 by IzanamiNeko");
        getConfig().addDefault("Messages.Join.Show", "false");
        getConfig().addDefault("Messages.Quit.Show", "false");

        //ChatClear System
        getConfig().addDefault("ChatClear.Enabled", "false");
        getConfig().addDefault("ChatClear.AllChat", "true");
        getConfig().addDefault("ChatClear.PlayerChat", "false");

        //getConfig().addDefault("Config.GeneralEvents.dropItem", "true");

        //General Purpose
        getConfig().addDefault("AntiPlugin.Enabled", "false");

        //HelpList
        getConfig().addDefault("HelpList.Enabled", "false");
        ///TeamChat
        getConfig().addDefault("TeamChat.Enabled", "true");
        getConfig().addDefault("TeamChat.Prefix", "&e[&bTeamChat&e] %player%  >> &r");
        getConfig().addDefault("Chat-Format.Enabled", "true");

        //DoubleJump
        getConfig().addDefault("DoubleJump.Enabled", "true");

        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }*/

    public void createBugDirectory() {
        File bug = new File("plugins/LobbySystem2021/Bugs");
        if(!bug.exists()){
            bug.mkdir();
        }
    }

    public static main getInstance() {
        return instance;
    }

}
