package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {

    main plugin;

    public ChatClear(main instance) {
        this.plugin = instance;
    }
    int i = 0;


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(this.plugin.getConfig().getString("Config.ChatClear.Enabled").equals("true")) {
            if (p.hasPermission("LobbySystem.ChatClear")) {
                while (i < 100) {
                    Bukkit.getServer().broadcastMessage(" ");
                    i++;
                }
                String msg = this.plugin.getConfig().getString("Config.ChatClear.Message").replace("&", "§");

                Bukkit.getServer().broadcastMessage(msg);
            } else {
                String msg1 = this.plugin.getConfig().getString("Config.General.NoPerm").replace("&", "§").replaceAll("%player%", p.getName());
                p.sendMessage(msg1);
            }
        }
        i = 0;
        return false;
    }
}
