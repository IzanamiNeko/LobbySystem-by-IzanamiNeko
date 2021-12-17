package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.ConfigManager;
import aut.izanamineko.lobbysystem2021.Utils.PermissionsListCFG;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.Utils.ScoreboardManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {

    MessagesManager mm = new MessagesManager();
    PermissionsListCFG cfgm = new PermissionsListCFG();
    ScoreboardManager sb = new ScoreboardManager();
    ConfigManager cm = new ConfigManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            System.out.println("You need to be a Player");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("lobbysystem")){
            if(!p.hasPermission("LobbySystem.MainCommand") || !p.isOp()) {
                String msg = this.mm.getConfig().getString("Messages.General.NoPermissions").replace("&", "§");
                p.sendMessage(msg);
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                this.cm.load();
                this.mm.load();
                this.sb.load();
                String msg = this.mm.getConfig().getString("Messages.General.Reload").replace("&", "§");
                p.sendMessage(msg);
                return true;
            }
        }

        return true;
    }
}
