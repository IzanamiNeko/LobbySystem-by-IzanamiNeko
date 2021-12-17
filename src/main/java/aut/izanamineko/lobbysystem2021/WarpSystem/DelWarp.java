package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class DelWarp implements CommandExecutor {

    main plugin;

    private MessagesManager mm = new MessagesManager();



    public DelWarp(main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can use this Command only as a Player");
            return true;
        }
        Player p = (Player)sender;

        if(p.hasPermission("LobbySystem.DelWarp")) {
            if(args.length == 1) {

                File file = new File("plugins/LobbySystem", "Warps.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                String id = args[0];

                cfg.set(".Warps" + "." + id, null);

                String msg = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.DelWarp.Del")).replaceAll("%warpname%", id);
                p.sendMessage(msg);

                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                String usage = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.DelWarp.Usage"));
                p.sendMessage(usage);
            }
        } else {
            String noperm = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.General.NoPermissions"));
            p.sendMessage(noperm);
        }
        return false;
    }

}
                    /*String msg = this.mm.getConfig().getString("Messages.WarpSystem.NoWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                    p.sendMessage(msg);*/
