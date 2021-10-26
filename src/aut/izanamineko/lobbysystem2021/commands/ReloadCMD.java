package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.ConfigManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {

    main plugin;

    public ReloadCMD(main instance) {
        this.plugin = instance;
    }

    ConfigManager cfgm;

    public ReloadCMD(ConfigManager instance) {
        this.cfgm = instance;
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
                String msg = this.plugin.getConfig().getString("General.NoPerms").replace("&", "§");
                p.sendMessage(msg);
                return true;
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                this.plugin.reloadConfig();
                this.cfgm.reloadMessagesCFG();
                String msg = this.plugin.getConfig().getString("ReloadCMD.Message").replace("&", "§");
                p.sendMessage(msg);
                return true;
            }
        }

        return true;
    }
}
