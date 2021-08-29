package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;

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
        if(this.plugin.getConfig().getString("Config.DataCollect.On").equals("true")) {
            File file = new File("plugins/LobbySystem2021/PlayerInformation/", p.getDisplayName().toLowerCase() + ".yml");
            CheckOrdner();
            String msg1 = this.plugin.getConfig().getString("Config.DataCollect.Note");
            String msg2 = this.plugin.getConfig().getString("Config.DataCollect.Note2");
            String msg3 = this.plugin.getConfig().getString("Config.DataCollect.Note3");
            p.sendMessage(msg1);
            p.sendMessage(msg2);
            p.sendMessage(msg3);
            if (!file.exists()) {
                file.createNewFile();
                YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
                yamlConfiguration.set("Username", p.getDisplayName());
                yamlConfiguration.set("Displayname", p.getDisplayName());
                yamlConfiguration.set("UUID", p.getUniqueId());
                yamlConfiguration.set("Inventory", p.getInventory());
                yamlConfiguration.save(file);
            } else {
                System.out.println("No Player Information found.");
            }
        } else {
            return;
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
        File file = new File("plugins/LobbySystem2021/PlayerInformation/", p.getDisplayName() + ".yml");
        file.delete();
    }


}
