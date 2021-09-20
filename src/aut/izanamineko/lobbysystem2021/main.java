package aut.izanamineko.lobbysystem2021;


import aut.izanamineko.lobbysystem2021.WarpSystem.DelWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.SetWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.Warp;
import aut.izanamineko.lobbysystem2021.commands.*;
import aut.izanamineko.lobbysystem2021.events.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;

import java.io.File;

public class main extends JavaPlugin {

    private static main plugin;

    public static main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {        //Beim Start wird alles was in onEnable steht ausgeführt
        System.out.println("LobbySystem V2021 is starting....");
        loadListener();
        loadConfig();
    }


    @Override
    public void onDisable() {       //Beim Stoppen wird alles was in onDisable steht ausgeführt
        System.out.println("LobbySystem V2021 is stopping....");

    }

    private void loadListener() {
        plugin = this;
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JQEvent(this), (Plugin)this);
        //pm.registerEvents(new GeneralEvent(this), (Plugin)this);
        pm.registerEvents(new Respawn(), this);
        pm.registerEvents(new BypassLimit(), this);
        pm.registerEvents(new AntiPlugin(this), this);
        //pm.registerEvents(new PlayerInformation(this), this);
        pm.registerEvents(new TeamChat(this), this);
        pm.registerEvents(new DoubleJump(this), this);



        getCommand("setlobby").setExecutor(new SetLobby(this));
        getCommand("lobby").setExecutor(new Lobby(this));
        getCommand("chatclear").setExecutor(new ChatClear(this));
        getCommand("cc").setExecutor(new ChatClear(this));
        getCommand("setwarp").setExecutor(new SetWarp(this));
        getCommand("warp").setExecutor(new Warp(this));
        getCommand("delwarp").setExecutor(new DelWarp(this));
        getCommand("lobbysystem").setExecutor(new ReloadCMD(this));
        getCommand("ping").setExecutor(new PingCMD(this));

    }

    private void loadConfig()
    {
        getConfig().options().header("LobbySystem2021 by IzanamiNeko");
        getConfig().addDefault("Config.General.NoPerm", "&8[&3System&8] &7You dont have permissions... &4[ &c%player% &4]");

        //Join/Quit System
        getConfig().addDefault("Config.Messages.Join.Show", "false");
        getConfig().addDefault("Config.Messages.Join.Message", "&8[&3System&8] &7Welcome %player%");
        getConfig().addDefault("Config.Messages.Quit.Show", "false");
        getConfig().addDefault("Config.Messages.Quit.Message", "&8[&3System&8] &7Goodbye %player%");

        //Spawn/Lobby System
        getConfig().addDefault("Config.Spawn.Permission", "&8[&3System&8] &7You don't have any Permissions");
        getConfig().addDefault("Config.Spawn.Set", "&8[&3System&8] &7The Spawn has been set!");
        getConfig().addDefault("Config.Spawn.DoesntExist", "&8[&3System&8] &7There is not Spawn set yet!");

        //ChatClear System
        getConfig().addDefault("Config.ChatClear.Enabled", "false");
        getConfig().addDefault("Config.ChatClear.Message", "&8[&3System&8] &7Chat has been cleared!");

        //General Purpose
        getConfig().addDefault("Config.AntiPlugin.Enabled", "false");
        getConfig().addDefault("Config.AntiPlugin.Message", "&8[&3System&8] &7Nice try! Good luck, next time!");
        getConfig().addDefault("Config.ReloadCMD.Message", "&8[&3System&8] &7The Server has been reloaded! (does include every Plugin/Settings)");


        //HelpList
        getConfig().addDefault("Config.HelpList.Enabled", "false");
        getConfig().addDefault("Config.HelpList.Line1", "&c----------- &6[LobbySystem] &-----------");
        getConfig().addDefault("Config.HelpList.Line2", "TEST");
        getConfig().addDefault("Config.HelpList.Line3", "TEST");
        getConfig().addDefault("Config.HelpList.Line4", "TEST");
        getConfig().addDefault("Config.HelpList.Line5", "TEST");
        getConfig().addDefault("Config.HelpList.Line6", "TEST");
        getConfig().addDefault("Config.HelpList.Line7", "TEST");
        getConfig().addDefault("Config.HelpList.Line8", "TEST");
        getConfig().addDefault("Config.HelpList.Line9", "&c----------- &6[LobbySystem] &-----------");


        //WarpSystem
        getConfig().addDefault("Config.WarpSystem.SetCMD", "&8[&3System&8] &7Use /setwarp [warpname]!");
        getConfig().addDefault("Config.WarpSystem.WarpCMD", "&8[&3System&8] &7Use /warp [warpname]!");
        getConfig().addDefault("Config.WarpSystem.SetWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been set!");
        getConfig().addDefault("Config.WarpSystem.DelWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been deleted!");
        getConfig().addDefault("Config.WarpSystem.NoWarp", "&8[&3System&8] &7There is no Warp called &4%warpname%!");
        getConfig().addDefault("Config.WarpSystem.Warped", "&8[&3System&8] &7You've been warped!");

        ///TeamChat
        getConfig().addDefault("Config.TeamChat.Enabled", "true");
        getConfig().addDefault("Config.TeamChat.Prefix", "&e[&bTeamChat&e] %player%  >> &r");

        //DoubleJump
        getConfig().addDefault("Config.DoubleJump.Enabled", "true");

        //PingCMD
        getConfig().addDefault("Config.PingCMD.Message", "&8[&3System&8] &7You have a Ping of %ms% ms");

        //Scoreboard
        /*getConfig().addDefault("Config.Scoreboard.Displayname", "&4Test-Server");
        getConfig().addDefault("Config.Scoreboard.Line1", "&6Test1");
        getConfig().addDefault("Config.Scoreboard.Line2", "&6Test2");
        getConfig().addDefault("Config.Scoreboard.Line3", "&6Test3");
        getConfig().addDefault("Config.Scoreboard.Line4", "&6Test4");
        getConfig().addDefault("Config.Scoreboard.Line5", "&6Test5");
        getConfig().addDefault("Config.Scoreboard.Line6", "&6Test6");
        getConfig().addDefault("Config.Scoreboard.Line7", "&6Test7");
        getConfig().addDefault("Config.Scoreboard.Line8", "&6Test8");
        getConfig().addDefault("Config.Scoreboard.Line9", "&6Test9");
        getConfig().addDefault("Config.Scoreboard.Line10", "&6Test10");
        getConfig().addDefault("Config.Scoreboard.Line11", "&6Test11");
        getConfig().addDefault("Config.Scoreboard.Line12", "&6Test12");
        getConfig().addDefault("Config.Scoreboard.Line13", "&6Test13");
        getConfig().addDefault("Config.Scoreboard.Line14", "&6Test14");*/

        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }


}


//getConfig().addDefault("Config.DataCollect.Enabled", "false");
//getConfig().addDefault("Config.DataCollect.Enabled.Message", "false");
//getConfig().addDefault("Config.DataCollect.Note", "&8[&3System&8] &7The moment you joined our Server, there is a File created with");
//getConfig().addDefault("Config.DataCollect.Note2", "&7your current Information, like DisplayName, UUID and Inventory.");
//getConfig().addDefault("Config.DataCollect.Note3", "&7The moment you leave this Server this file gets deleted!");
//getConfig().addDefault("Config.HelpList.Message", "&8[&3System&8]  &7There is no Help right now!");
//getConfig().addDefault("Config.GeneralEvents.dropItem", "false");
//getConfig().addDefault("Config.GeneralEvents.pickupItem", "false");