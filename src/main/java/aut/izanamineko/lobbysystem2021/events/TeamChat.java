package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.Utils.ConfigManager;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class TeamChat implements Listener {

    ConfigManager cm = new ConfigManager();
    MessagesManager mm = new MessagesManager();

    @EventHandler
    public boolean onTC(PlayerChatEvent e) {
        Player p = e.getPlayer();
        String tc = ChatColor.translateAlternateColorCodes('&', this.cm.getConfig().getString("Config.TeamChat.Prefix")).replaceAll("%player%", p.getName());

        if (this.cm.getConfig().getString("Config.TeamChat.Enabled").equals("true")){
            if (e.getMessage().startsWith("!")) {
                if (p.hasPermission("LobbySystem.TeamChat") || p.isOp()) {
                    e.setCancelled(true);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if (players.hasPermission("LobbySystem.TeamChat")) {
                            players.sendMessage(tc + e.getMessage().replaceAll("!", ""));
                        }
                    }
                }
            } else {
                e.setCancelled(false);
            }
        }
        return false;
    }
}
