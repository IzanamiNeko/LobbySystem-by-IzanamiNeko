package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class TeamChat implements Listener {

    private main plugin;

    public TeamChat(main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public boolean onTC(PlayerChatEvent e) {
        Player p = e.getPlayer();
        String tc = this.plugin.getConfig().getString("TeamChat.Prefix").replace("&", "§").replaceAll("%player%", p.getName());

        if (this.plugin.getConfig().getString("TeamChat.Enabled").equals("true")){
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
