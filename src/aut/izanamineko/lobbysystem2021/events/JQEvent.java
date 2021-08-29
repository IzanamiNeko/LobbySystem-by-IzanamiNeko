package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class JQEvent implements Listener {

    main plugin;

    public JQEvent(main instance) {
        this.plugin = instance;
    }

    public static void CheckOrdner() {
        File file = new File("plugins/LobbySystem2021/PlayerInformation");
        if (!file.isDirectory())
            file.mkdirs();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException             //Das PlayerJoinEvent wird mit einer Variablen versehen
    {
        Player p = e.getPlayer();
        String msg = this.plugin.getConfig().getString("Config.Messages.Join.Message");
        msg = msg.replaceAll("&", "§");
        msg = msg.replaceAll("%player%", p.getDisplayName());
        if (this.plugin.getConfig().getString("Config.Messages.Join.Show").equals("true")) {
            e.setJoinMessage(msg);
        } else {
            e.setJoinMessage("");
        }
        File file = new File("plugins/LobbySystem2021/PlayerInformation/", p.getDisplayName().toLowerCase() + ".yml");
        CheckOrdner();
        if (!file.exists()) {
            file.createNewFile();
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
            yamlConfiguration.set("Username", p.getDisplayName());
            yamlConfiguration.set("UUID", p.getUniqueId());
            yamlConfiguration.set("Inventory", p.getInventory());
            yamlConfiguration.save(file);
        } else {
            System.out.println("No Player Information found.");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        String msg = this.plugin.getConfig().getString("Config.Messages.Quit.Message");
        msg = msg.replaceAll("&", "§");
        msg = msg.replaceAll("%player%", p.getDisplayName());
        if (this.plugin.getConfig().getString("Config.Messages.Quit.Show").equals("true")) {
            e.setQuitMessage(msg);
        } else {
            e.setQuitMessage("");
        }
        File file = new File("plugins/LobbySystem2021/PlayerInformation/", p.getDisplayName().toLowerCase() + ".yml");
        file.delete();
    }



}
