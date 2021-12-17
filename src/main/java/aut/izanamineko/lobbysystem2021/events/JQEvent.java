package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.Utils.ConfigManager;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.io.IOException;

public class JQEvent implements Listener {


    MessagesManager mm = new MessagesManager();
    ConfigManager cm = new ConfigManager();



    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException             //Das PlayerJoinEvent wird mit einer Variablen versehen
    {
        Player p = e.getPlayer();
        String msg = this.mm.getConfig().getString("Messages.Join.Message");
        msg = msg.replace("&", "§");
        msg = msg.replaceAll("%player%", p.getDisplayName());
        if (this.cm.getConfig().getString("Config.Join.Show").equals("true")) {
            p.sendMessage(msg);
            p.playSound(p.getLocation(), Sound.valueOf(this.mm.getConfig().getString("Messages.Join.Sound")) , 10.0F, 10.0F);
            e.setJoinMessage("");
        } else {
            p.sendMessage("");
            e.setJoinMessage("");
        }


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        String msg = this.mm.getConfig().getString("Messages.Quit.Message").replace("&", "§").replaceAll("%player%", p.getDisplayName());
        if (this.cm.getConfig().getString("Config.Quit.Show").equals("true")) {
            p.sendMessage(msg);
            e.setQuitMessage("");
        } else {
            e.setQuitMessage("");
        }

    }


}
