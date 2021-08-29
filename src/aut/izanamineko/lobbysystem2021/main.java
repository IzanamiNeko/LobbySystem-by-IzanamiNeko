package aut.izanamineko.lobbysystem2021;

import aut.izanamineko.lobbysystem2021.events.GeneralEvent;
import aut.izanamineko.lobbysystem2021.events.JQEvent;
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
    }

    private void loadConfig()
    {
        getConfig().options().header("LobbySystem2021 by IzanamiNeko");
        getConfig().addDefault("Config.GeneralEvents.DropItem", "false");
        getConfig().addDefault("Config.GeneralEvents.pickupItem", "false");
        getConfig().addDefault("Config.Messages.Join.Message", "Welcome %player%");
        getConfig().addDefault("Config.Messages.Join.Show", "true");
        getConfig().addDefault("Config.Messages.Quit.Message", "Goodbye %player%");
        getConfig().addDefault("Config.Messages.Quit.Show", "true");
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }


}
