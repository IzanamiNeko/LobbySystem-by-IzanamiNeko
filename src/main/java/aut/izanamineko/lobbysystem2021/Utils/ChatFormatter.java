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





    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (this.mm.getConfig().getString("Chat-Format.Enabled").equals("true")) {
            String config = PlaceholderAPI.setPlaceholders(p, this.mm.getConfig().getString("Messages.Chat-Format.Format"));
            String altColor = ChatColor.translateAlternateColorCodes('&', config);
            String msg = altColor;

            if(p.hasPermission("LobbySystem.ColorChat")) {
                e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            }
            e.setFormat(msg + e.getMessage());

        }
    }
}
