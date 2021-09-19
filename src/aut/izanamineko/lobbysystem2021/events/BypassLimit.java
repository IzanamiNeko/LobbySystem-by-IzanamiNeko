package aut.izanamineko.lobbysystem2021.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class BypassLimit implements Listener {

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event) {

        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {

            if (event.getPlayer().hasPermission("LobbySystem.PlayerLimit.Bypass"))

                event.allow();
        }

    }
}
