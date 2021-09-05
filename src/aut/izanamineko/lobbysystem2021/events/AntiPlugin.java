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
    public void onCMD(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/?") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.General.NoPerm").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD2(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/plugins") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.Bypass");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD3(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/pl") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

   /* @EventHandler
    public void onCMD4(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/help") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }*/

    @EventHandler
    public void onCMD5(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/ver") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD6(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/version") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD7(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:plugins") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD8(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:pl") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }
    @EventHandler
    public void onCMD9(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:help") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD10(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:?") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD11(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:ver") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD12(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if (this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
            if (onCMD.getMessage().equals("/bukkit:version") && !onCMD.getPlayer().isOp()) {
                p.hasPermission("LobbySystem.CommandProtection");
                String msg = this.plugin.getConfig().getString("Config.AntiPlugin.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                        p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
    }

    @EventHandler
    public void onCMD13(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if(this.plugin.getConfig().getString("Config.AntiPlugin.Enabled").equals("true"))
        {
            if(onCMD.getMessage().equals("/chatclear") && !onCMD.getPlayer().isOp() || !onCMD.getPlayer().hasPermission("LobbySystem.ChatClear"))
            {
                String msg = this.plugin.getConfig().getString("Config.General.NoPerm").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                p.sendMessage(msg);
                onCMD.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onCMD14(PlayerCommandPreprocessEvent onCMD) {
        Player p = onCMD.getPlayer();
        if(this.plugin.getConfig().getString("Config.ReloadCMD.Enabled").equals("true")){
            if(onCMD.getMessage().equals("/reload") && !onCMD.getPlayer().isOp()){
                String msg = this.plugin.getConfig().getString("Config.ReloadCMD.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                Bukkit.getServer().broadcastMessage(msg);
            }
        }
    }

    @EventHandler
    public void onCMD15(PlayerCommandPreprocessEvent onCMD)
    {
        Player p = onCMD.getPlayer();
        if(this.plugin.getConfig().getString("Config.HelpList.Enabled").equals("true")){
            if(onCMD.getMessage().equals("/help") || !onCMD.getPlayer().isOp()) {
                String msg = this.plugin.getConfig().getString("Config.HelpList.Message").replace("&", "§").replaceAll("%player%", onCMD.getPlayer().getPlayerListName());
                p.sendMessage(msg);
            }
        }
    }
}
