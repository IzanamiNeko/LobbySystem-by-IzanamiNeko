package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class DelWarp implements CommandExecutor {

    main plugin;

    private MessagesManager mm = new MessagesManager();



    public DelWarp(main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("LobbySystem.DelWarp")) {
            if (args.length > 0) {
                File file = new File("plugins/LobbySystem2021/Warps/", args[0] + ".yml");
                if (file.exists()) {
                    String msg = this.mm.getConfig().getString("Messages.WarpSystem.DelWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                    p.sendMessage(msg);
                    file.delete();
                } else {
                    String msg = this.mm.getConfig().getString("Messages.WarpSystem.NoWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                    p.sendMessage(msg);
                }
            } else {
                String msg = this.mm.getConfig().getString("General.NoPermissions").replace("&", "§").replaceAll("%player%", p.getName());
                p.sendMessage(msg);
            }
        }
        return true;
    }
}
