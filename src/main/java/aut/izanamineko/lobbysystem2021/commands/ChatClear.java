package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.ConfigManager;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {

    MessagesManager mm = new MessagesManager();
    ConfigManager cm = new ConfigManager();

    int i = 0;


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can use this Command only as a Player");
            return true;
        }
        if(this.cm.getConfig().getString("Config.ChatClear.Enabled").equals("true")) {
            if (!p.hasPermission("LobbySystem.ChatClear") || !p.isOp()) {
                String noperm = ChatColor.translateAlternateColorCodes('&',
                        this.mm.getConfig().getString("Messages.General.NoPermissions"));
                p.sendMessage(noperm);
                return true;
            }
            while (i < 100) {
                Bukkit.getServer().broadcastMessage(" ");
                i++;
            }
            String msg = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.ChatClear.Message"));

            if(this.cm.getConfig().getString("Config.ChatClear.AllChat").equals("true")) {
                Bukkit.getServer().broadcastMessage(msg);
                return true;
            }
        }
        i = 0;
        return true;
    }
}