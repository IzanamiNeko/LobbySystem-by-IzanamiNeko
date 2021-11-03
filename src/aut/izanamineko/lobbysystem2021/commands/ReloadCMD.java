package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.PermissionsListCFG;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {

    main plugin;

    MessagesManager mm = new MessagesManager();
    PermissionsListCFG cfgm = new PermissionsListCFG();

    public ReloadCMD(main instance) {
        this.plugin = instance;
    }

    public ReloadCMD(PermissionsListCFG instance){
        cfgm = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;
        if (!(sender instanceof Player)) {
            System.out.println("You need to be a Player");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("lobbysystem")){
            if(!p.hasPermission("LobbySystem.Reload") || !p.isOp()) {
                String msg = this.mm.getConfig().getString("Messages.General.NoPermissions").replace("&", "§");
                p.sendMessage(msg);
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                this.plugin.reloadConfig();
                this.mm.load();
                String msg = this.plugin.getConfig().getString("ReloadCMD.Message").replace("&", "§");
                p.sendMessage(msg);
                return true;
            }
        }

        return true;
    }
}
