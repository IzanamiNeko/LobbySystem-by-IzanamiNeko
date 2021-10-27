package aut.izanamineko.lobbysystem2021;


import aut.izanamineko.lobbysystem2021.WarpSystem.DelWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.SetWarp;
import aut.izanamineko.lobbysystem2021.WarpSystem.Warp;
import aut.izanamineko.lobbysystem2021.WarpSystem.WarpList;
import aut.izanamineko.lobbysystem2021.commands.*;
import aut.izanamineko.lobbysystem2021.events.*;
import aut.izanamineko.lobbysystem2021.gui.InvGui;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public class main extends JavaPlugin {

    main plugin;
    ConfigManager cfgm;

    @Override
    public void onEnable() {        //Beim Start wird alles was in onEnable steht ausgeführt
        System.out.println(ChatColor.GREEN + "LobbySystem V2021 is starting....");

        createWarpsDirectory();
        loadListener();
        loadConfig();
        loadConfigManager();
    }


    @Override
    public void onDisable() {       //Beim Stoppen wird alles was in onDisable steht ausgeführt
        System.out.println(ChatColor.RED + "LobbySystem V2021 is stopping....");

    }

    public void loadConfigManager(){
        cfgm = new ConfigManager();
        cfgm.MessagesCFGsetup();
        cfgm.getMessagesCFG().options().header("WarpSystemConfig by IzanamiNeko");
        //cfgm.getMessagesCFG().addDefault("General.NoPerm", "&8[&3System&8] &7You dont have permissions... &4[ &c%player% &4]");
        cfgm.getMessagesCFG().addDefault("Messages.WarpSystem.SetCMD", "&8[&3System&8] &7Use /setwarp [warpname]!");
        cfgm.getMessagesCFG().addDefault("Messages.WarpSystem.WarpCMD", "&8[&3System&8] &7Use /warp [warpname]!");
        cfgm.getMessagesCFG().addDefault("Messages.WarpSystem.SetWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been set!");
        cfgm.getMessagesCFG().addDefault("Messages.WarpSystem.DelWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been deleted!");
        cfgm.getMessagesCFG().addDefault("Messages.WarpSystem.NoWarp", "&8[&3System&8] &7There is no Warp called &4%warpname%!");
        cfgm.getMessagesCFG().addDefault("Messages.WarpSystem.Warped", "&8[&3System&8] &7You've been warped!");
        //cfgm.getMessagesCFG().addDefault("Spawn.Permission", "&8[&3System&8] &7You don't have any Permissions");
        //cfgm.getMessagesCFG().addDefault("Spawn.Set", "&8[&3System&8] &7The Spawn has been set!");
        //cfgm.getMessagesCFG().addDefault("Spawn.DoesntExist", "&8[&3System&8] &7There is not Spawn set yet!");
        //cfgm.getMessagesCFG().addDefault("ChatClear.Message", "&8[&3System&8] &7Chat has been cleared!");
        //cfgm.getMessagesCFG().addDefault("AntiPlugin.Message", "&8[&3System&8] &7Nice try! Good luck, next time!");
        //cfgm.getMessagesCFG().addDefault("ReloadCMD.Message", "&8[&3System&8] &7LobbySystem2021 has been reloaded! (every LobbySystem Configs)");
        //cfgm.getMessagesCFG().addDefault("PingCMD.Message", "&8[&3System&8] &7You have a Ping of %ms% ms");
        cfgm.getMessagesCFG().options().copyDefaults(true);
        cfgm.saveMessagesCFG();
        cfgm.reloadMessagesCFG();

    }

    private void loadListener() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JQEvent(this), this);
        pm.registerEvents(new GeneralEvent(this), this);
        pm.registerEvents(new Respawn(this), this);
        pm.registerEvents(new BypassLimit(), this);
        pm.registerEvents(new AntiPlugin(this), this);
        pm.registerEvents(new TeamChat(this), this);
        pm.registerEvents(new DoubleJump(this), this);
        pm.registerEvents(new InvGui(), this);
        //pm.registerEvents(new InvOnJoin(this), this);
        //pm.registerEvents(new PlayerInformation(this), this);



        getCommand("setlobby").setExecutor(new SetLobby(this));
        getCommand("lobby").setExecutor(new Lobby(this));
        getCommand("chatclear").setExecutor(new ChatClear(this));
        getCommand("cc").setExecutor(new ChatClear(this));
        getCommand("setwarp").setExecutor(new SetWarp(this));
        getCommand("warp").setExecutor(new Warp(this));
        getCommand("delwarp").setExecutor(new DelWarp(this));
        getCommand("lobbysystem").setExecutor(new ReloadCMD(this));
        getCommand("ping").setExecutor(new PingCMD( this));
        getCommand("bug").setExecutor(new BugCMD(this));
        getCommand("warplist").setExecutor(new WarpList());

    }

    private void loadConfig()
    {
        getConfig().options().header("LobbySystem2021 by IzanamiNeko");

        getConfig().addDefault("General.NoPerm", "&8[&3System&8] &7You dont have permissions... &4[ &c%player% &4]");

        //Join/Quit System
        getConfig().addDefault("Messages.Join.Show", "false");
        getConfig().addDefault("Messages.Join.Message", "&8[&3System&8] &7Welcome %player%");
        getConfig().addDefault("Messages.Quit.Show", "false");
        getConfig().addDefault("Messages.Quit.Message", "&8[&3System&8] &7Goodbye %player%");

        //Spawn/Lobby System
        getConfig().addDefault("Spawn.Permission", "&8[&3System&8] &7You don't have any Permissions");
        getConfig().addDefault("Spawn.Set", "&8[&3System&8] &7The Spawn has been set!");
        getConfig().addDefault("Spawn.DoesntExist", "&8[&3System&8] &7There is not Spawn set yet!");

        //ChatClear System
        getConfig().addDefault("ChatClear.Enabled", "false");
        getConfig().addDefault("ChatClear.Message", "&8[&3System&8] &7Chat has been cleared!");

        //General Purpose
        getConfig().addDefault("AntiPlugin.Enabled", "false");
        getConfig().addDefault("AntiPlugin.Message", "&8[&3System&8] &7Nice try! Good luck, next time!");
        getConfig().addDefault("ReloadCMD.Message", "&8[&3System&8] &7LobbySystem2021 has been reloaded! (only the config.yml)");

        //General Events
       // getConfig().addDefault("Config.GeneralEvents.dropItem", "false");


        //HelpList
        getConfig().addDefault("HelpList.Enabled", "false");
        getConfig().addDefault("HelpList.Line1", "&c----------- &6[LobbySystem] &-----------");
        getConfig().addDefault("HelpList.Line2", "TEST");
        getConfig().addDefault("HelpList.Line3", "TEST");
        getConfig().addDefault("HelpList.Line4", "TEST");
        getConfig().addDefault("HelpList.Line5", "TEST");
        getConfig().addDefault("HelpList.Line6", "TEST");
        getConfig().addDefault("HelpList.Line7", "TEST");
        getConfig().addDefault("HelpList.Line8", "TEST");
        getConfig().addDefault("HelpList.Line9", "&c----------- &6[LobbySystem] &-----------");


        //WarpSystem
        getConfig().addDefault("WarpSystem.SetCMD", "&8[&3System&8] &7Use /setwarp [warpname]!");
        getConfig().addDefault("WarpSystem.WarpCMD", "&8[&3System&8] &7Use /warp [warpname]!");
        getConfig().addDefault("WarpSystem.SetWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been set!");
        getConfig().addDefault("WarpSystem.DelWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been deleted!");
        getConfig().addDefault("WarpSystem.NoWarp", "&8[&3System&8] &7There is no Warp called &4%warpname%!");
        getConfig().addDefault("WarpSystem.Warped", "&8[&3System&8] &7You've been warped!");

        ///TeamChat
        getConfig().addDefault("TeamChat.Enabled", "true");
        getConfig().addDefault("TeamChat.Prefix", "&e[&bTeamChat&e] %player%  >> &r");

        //DoubleJump
        getConfig().addDefault("DoubleJump.Enabled", "true");

        //PingCMD
        getConfig().addDefault("PingCMD.Message", "&8[&3System&8] &7You have a Ping of %ms% ms");

        //BugCMD


        getConfig().addDefault("BugCMD.Message", "&8[&3System&8] &c%player% &7reported a Bug");
        getConfig().addDefault("BugCMD.BugReport", "&8[&3System&8] &7%bug%");

        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }

    public void createWarpsDirectory() {
        File warps = new File("plugins/LobbySystem2021/Warps");
        if (!warps.exists()) {
            warps.mkdir();
        }
    }

}
