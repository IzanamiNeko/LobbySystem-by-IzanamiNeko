package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.Utils.PingUtil;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class PingCMD implements CommandExecutor {

    main plugin;

    MessagesManager mm = new MessagesManager();

    public PingCMD(main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equals("ping")) {
            if (p.hasPermission("LobbySystem.PingCMD")) {
                String ping = "" + PingUtil.getPing(p);
                String msg = this.mm.getConfig().getString("Messages.General.Ping").replace("&", "§").replaceAll("%ms%", ping);
                p.sendMessage(msg);
            } else {
                String msg1 = this.mm.getConfig().getString("Messages.General.NoPermissions").replace("&", "§").replaceAll("%player%", p.getName());
                p.sendMessage(msg1);
            }
        }
        return true;
    }
}
