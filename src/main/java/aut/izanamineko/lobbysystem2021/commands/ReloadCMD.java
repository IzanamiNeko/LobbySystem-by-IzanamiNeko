package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.ConfigManager;
import aut.izanamineko.lobbysystem2021.Utils.PermissionsListCFG;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.Utils.ScoreboardConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {

    MessagesManager mm = new MessagesManager();
    PermissionsListCFG cfgm = new PermissionsListCFG();
    ScoreboardConfigManager sb = new ScoreboardConfigManager();
    ConfigManager cm = new ConfigManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can use this Command only as a Player");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("lobbysystem")){
            if(!p.hasPermission("LobbySystem.MainCommand") || !p.isOp()) {
                String msg = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.General.NoPermissions"));
                p.sendMessage(msg);
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                String msg = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.General.Reload"));
                cm.loadConfigManager();
                mm.loadMessagesManager();
                sb.loadScoreboardManager();
                p.sendMessage(msg);
                return true;
            }
        }

        return true;
    }
}
