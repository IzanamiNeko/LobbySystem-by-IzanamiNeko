package aut.izanamineko.lobbysystem2021;


import aut.izanamineko.lobbysystem2021.SpawnSystem.SetSpawn;
import aut.izanamineko.lobbysystem2021.SpawnSystem.Spawn;
import aut.izanamineko.lobbysystem2021.Utils.PermissionsListCFG;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.WarpSystem.DelWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.SetWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.Warp;
import aut.izanamineko.lobbysystem2021.WarpSystem.WarpList;
import aut.izanamineko.lobbysystem2021.commands.*;
import aut.izanamineko.lobbysystem2021.events.*;
import aut.izanamineko.lobbysystem2021.gui.InvGui;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class main extends JavaPlugin {

    main plugin;

    private MessagesManager mm = new MessagesManager();
    private PermissionsListCFG plcfg = new PermissionsListCFG();

    @Override
    public void onEnable() {        //Beim Start wird alles was in onEnable steht ausgeführt
        System.out.println(ChatColor.GREEN + "LobbySystem V2021 is starting....");

        createWarpsDirectory();
        createBugDirectory();
        loadCommands();
        loadListener();
        loadConfig();
    }


    @Override
    public void onDisable() {       //Beim Stoppen wird alles was in onDisable steht ausgeführt
        System.out.println(ChatColor.RED + "LobbySystem V2021 is stopping....");

    }



    private void loadListener() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JQEvent(this), this);
        //pm.registerEvents(new GeneralEvent(this), this);
        pm.registerEvents(new Respawn(this), this);
        pm.registerEvents(new BypassLimit(), this);
        pm.registerEvents(new AntiPlugin(this), this);
        pm.registerEvents(new TeamChat(this), this);
        //pm.registerEvents(new DoubleJump(this), this);
        pm.registerEvents(new InvGui(), this);
        //pm.registerEvents(new InvOnJoin(this), this);
        //pm.registerEvents(new PlayerInformation(this), this);
    }

    private void loadCommands() {
        getCommand("setwarp").setExecutor(new SetWarp(this));
        getCommand("warp").setExecutor(new Warp(this));
        getCommand("delwarp").setExecutor(new DelWarp(this));
        getCommand("setspawn").setExecutor(new SetSpawn(this));
        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("chatclear").setExecutor(new ChatClear(this));
        getCommand("cc").setExecutor(new ChatClear(this));
        getCommand("lobbysystem").setExecutor(new ReloadCMD(this));
        getCommand("ping").setExecutor(new PingCMD( this));
        getCommand("bug").setExecutor(new BugCMD(this));
        getCommand("warplist").setExecutor(new WarpList());

        plugin = this;
    }

    private void loadConfig()
    {
        getConfig().options().header("LobbySystem2021 by IzanamiNeko");
        getConfig().addDefault("Messages.Join.Show", "false");
        getConfig().addDefault("Messages.Quit.Show", "false");

        //ChatClear System
        getConfig().addDefault("ChatClear.Enabled", "false");
        getConfig().addDefault("ChatClear.AllChat", "true");
        getConfig().addDefault("ChatClear.PlayerChat", "false");

        getConfig().addDefault("ChatClear.Message", "&8[&3System&8] &7Chat has been cleared!");
        getConfig().addDefault("Config.GeneralEvents.dropItem", "true");

        //General Purpose
        getConfig().addDefault("AntiPlugin.Enabled", "false");
        getConfig().addDefault("ReloadCMD.Message", "&8[&3System&8] &7LobbySystem2021 has been reloaded! (only the config.yml)");

        //HelpList
        getConfig().addDefault("HelpList.Enabled", "false");
        ///TeamChat
        getConfig().addDefault("TeamChat.Enabled", "true");
        getConfig().addDefault("TeamChat.Prefix", "&e[&bTeamChat&e] %player%  >> &r");

        //DoubleJump
        getConfig().addDefault("DoubleJump.Enabled", "true");

        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }

    public void createBugDirectory() {
        File bug = new File("plugins/LobbySystem2021/Bugs");
        if(!bug.exists()){
            bug.mkdir();
        }
    }

    public void createWarpsDirectory() {
        File warps = new File("plugins/LobbySystem2021/Warps");
        if (!warps.exists()) {
            warps.mkdir();
        }
    }

}
