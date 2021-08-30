package aut.izanamineko.lobbysystem2021;

import aut.izanamineko.lobbysystem2021.commands.ChatClear;
import aut.izanamineko.lobbysystem2021.commands.Lobby;
import aut.izanamineko.lobbysystem2021.commands.SetLobby;
import aut.izanamineko.lobbysystem2021.events.BypassLimit;
import aut.izanamineko.lobbysystem2021.events.GeneralEvent;
import aut.izanamineko.lobbysystem2021.events.JQEvent;
import aut.izanamineko.lobbysystem2021.events.Respawn;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    private static main plugin;

    public static main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {        //Beim Start wird alles was in onEnable steht ausgeführt
        System.out.println("LobbySystem V2021 wird gestartet");
        loadListener();
        loadConfig();
    }


    @Override
    public void onDisable() {       //Beim Stoppen wird alles was in onDisable steht ausgeführt
        System.out.println("LobbySystem V2021 wird gestoppt");

    }

    private void loadListener() {
        plugin = this;
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JQEvent(this), (Plugin)this);
        pm.registerEvents(new GeneralEvent(this), (Plugin)this);
        pm.registerEvents(new Respawn(), this);
        pm.registerEvents(new BypassLimit(), this);
        getCommand("setlobby").setExecutor(new SetLobby(this));
        getCommand("lobby").setExecutor(new Lobby(this));
        getCommand("chatclear").setExecutor(new ChatClear(this));

    }

    private void loadConfig()
    {
        getConfig().options().header("LobbySystem2021 by IzanamiNeko");
        getConfig().addDefault("Config.GeneralEvents.dropItem", "false");
        getConfig().addDefault("Config.GeneralEvents.pickupItem", "false");
        getConfig().addDefault("Config.Messages.Join.Message", "Welcome %player%");
        getConfig().addDefault("Config.Messages.Join.Show", "true");
        getConfig().addDefault("Config.Messages.Quit.Message", "Goodbye %player%");
        getConfig().addDefault("Config.Messages.Quit.Show", "true");
        /*getConfig().addDefault("Config.WarpSystem.DeleteWarp", "The Warp has been deleted.");
        getConfig().addDefault("Config.WarpSystem.DoesntExist", "The Warp doesnt exist.");
        getConfig().addDefault("Config.WarpSystem.CreateWarp", "The Warp | %warp% | has been created.");*/
        getConfig().addDefault("Config.Spawn.Permission", "You don't have any Permissions");
        getConfig().addDefault("Config.Spawn.Set", "The Spawn has been set!");
        getConfig().addDefault("Config.Spawn.DoesntExist", "There is not Spawn set yet!");
        getConfig().addDefault("Config.DataCollect.On", "true");
        getConfig().addDefault("Config.DataCollect.Note", "The moment you joined our Server, there is a File created with");
        getConfig().addDefault("Config.DataCollect.Note2", "your current Information, like DisplayName, UUID and Inventory.");
        getConfig().addDefault("Config.DataCollect.Note3", "The moment you leave this Server this file gets deleted!");
        getConfig().addDefault("Config.ChatClear.On", "true");
        getConfig().addDefault("Config.ChatClear.Message", "Chat has been cleared!");
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }


}
