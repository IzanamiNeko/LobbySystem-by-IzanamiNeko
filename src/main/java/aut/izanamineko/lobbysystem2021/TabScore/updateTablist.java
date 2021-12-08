package aut.izanamineko.lobbysystem2021.TabScore;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;


public class updateTablist implements Listener {

    private main plugin;

    MessagesManager mm = new MessagesManager();

    public updateTablist(main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, (Plugin)plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        updateTablist(p);
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)this.plugin, new Runnable() {
            @Override
            public void run() {
                updateTablist.this.updateTablist(p);
                updateTablist.this.sendTablist(p, "&fWilkommen auf :" , "&6Wir suchen derzeit &bModeratoren! &cBewirb dich im Forum!");
            }
        }, 20L, 20L);
    }

    public void updateTablist(Player e) {
        Player p = e.getPlayer();
        String altColor = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.Tablist.Prefix"));
        String prefix = PlaceholderAPI.setPlaceholders(p, altColor);
                p.setPlayerListName(prefix + p.getDisplayName());
    }

    private void sendTablist(Player p, String header, String footer) {}
}
