package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {

    main plugin;

    MessagesManager mm = new MessagesManager();

    public ChatClear(main instance) {
        this.plugin = instance;
    }
    int i = 0;


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(this.plugin.getConfig().getString("ChatClear.Enabled").equals("true")) {
            if (p.hasPermission("LobbySystem.ChatClear")) {
                while (i < 100) {
                    Bukkit.getServer().broadcastMessage(" ");
                    i++;
                }
                String msg = this.mm.getConfig().getString("Messages.ChatClear.Message").replace("&", "§");

                if(this.plugin.getConfig().getBoolean("ChatClear.AllChat", true)){
                    Bukkit.getServer().broadcastMessage(msg);
                }
                if(this.plugin.getConfig().getBoolean("ChatClear.PlayerChat", true)){
                    p.sendMessage(msg);
                }

            } else {
                String msg1 = this.mm.getConfig().getString("Messages.General.NoPermissions").replace("&", "§").replaceAll("%player%", p.getName());
                p.sendMessage(msg1);
            }
        }
        i = 0;
        return false;
    }
}
