package aut.izanamineko.lobbysystem2021.Utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {

    MessagesManager mm = new MessagesManager();
    ConfigManager cm = new ConfigManager();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (this.cm.getConfig().getString("Config.ChatFormat.Enabled").equals("true")) {
            String config = ChatColor.translateAlternateColorCodes('&',
                    PlaceholderAPI.setPlaceholders(p, this.mm.getConfig().getString("Messages.ChatFormat.Format")));

            e.setFormat(config + e.getMessage());

        }
    }
}
