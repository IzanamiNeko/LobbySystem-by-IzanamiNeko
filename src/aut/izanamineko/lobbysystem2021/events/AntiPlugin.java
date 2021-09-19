package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class AntiPlugin implements Listener {

    static main plugin;

    public AntiPlugin(main instance) {
        plugin = instance;
    }


    @EventHandler
    public void onCMD2(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/plugins") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.Bypass");
                String msg2 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg2);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD3(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/pl") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg3 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg3);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD5(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/ver") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg4 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg4);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD6(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/version") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg5 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg5);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD7(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:plugins") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg6 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg6);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD8(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:pl") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg7 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg7);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD11(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:ver") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg9 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg9);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD12(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:version") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg10 = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg10);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD15(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if(this.plugin.getConfig().getString("Config.HelpList.Enabled").equals("true")){
            if(onCMD.getMessage().equals("/help") || onCMD.getMessage().equals("/?") || onCMD.getMessage().equals("/bukkit:help") || onCMD.getMessage().equals("/bukkit:?") && !onCMD.getPlayer().isOp() || !onCMD.getPlayer().hasPermission("LobbySystem.HelpCMD")) {
                String msg1 = this.plugin.getConfig().getString("Config.HelpList.Line1").replace("&", "§");
                String msg2 = this.plugin.getConfig().getString("Config.HelpList.Line2").replace("&", "§");
                String msg3 = this.plugin.getConfig().getString("Config.HelpList.Line3").replace("&", "§");
                String msg4 = this.plugin.getConfig().getString("Config.HelpList.Line4").replace("&", "§");
                String msg5 = this.plugin.getConfig().getString("Config.HelpList.Line5").replace("&", "§");
                String msg6 = this.plugin.getConfig().getString("Config.HelpList.Line6").replace("&", "§");
                String msg7 = this.plugin.getConfig().getString("Config.HelpList.Line7").replace("&", "§");
                String msg8 = this.plugin.getConfig().getString("Config.HelpList.Line8").replace("&", "§");
                String msg9 = this.plugin.getConfig().getString("Config.HelpList.Line9").replace("&", "§");

                p.sendMessage(msg1);
                p.sendMessage(msg2);
                p.sendMessage(msg3);
                p.sendMessage(msg4);
                p.sendMessage(msg5);
                p.sendMessage(msg6);
                p.sendMessage(msg7);
                p.sendMessage(msg8);
                p.sendMessage(msg9);
                onCMD.setCancelled(true);
            } else {
                onCMD.setCancelled(false);
            }
        }
    }
}
