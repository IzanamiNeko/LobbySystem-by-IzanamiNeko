package aut.izanamineko.lobbysystem2021.TabScore;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.Utils.PingUtil;
import aut.izanamineko.lobbysystem2021.main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;


public class updateTablist implements Listener {

    private main plugin;

    MessagesManager mm = new MessagesManager();


    public updateTablist(main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, (Plugin) plugin);
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        updateTablist(p);
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) this.plugin, new Runnable() {
            @Override
            public void run() {
                updateTablist.this.updateTablist(p);
            }
        }, 20L, 20L);
    }

    public void updateTablist(Player e) {
        Player p = e.getPlayer();
        String prefix = PlaceholderAPI.setPlaceholders(p, ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.Tablist.List")));
        String list = prefix.replaceAll("%username%", p.getDisplayName());
        String header = PlaceholderAPI.setPlaceholders(p, ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.Tablist.Header")));
        String footer = PlaceholderAPI.setPlaceholders(p, ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.Tablist.Footer")));

        p.setPlayerListFooter(footer);
        p.setPlayerListHeader(header);
        p.setPlayerListName(list);
    }

    public void sendTablist() {

    }

}
