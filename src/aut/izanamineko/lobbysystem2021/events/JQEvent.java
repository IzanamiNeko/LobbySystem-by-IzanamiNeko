package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JQEvent implements Listener {

    main plugin;

    public JQEvent(main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)             //Das PlayerJoinEvent wird mit einer Variablen versehen
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
    }



}
