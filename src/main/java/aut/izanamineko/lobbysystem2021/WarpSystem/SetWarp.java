package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginBase;

import java.io.File;
import java.io.IOException;


public class SetWarp implements CommandExecutor {

    main plugin;

    private MessagesManager mm = new MessagesManager();



    public SetWarp(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String strings, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can use this Command only as a Player");
            return true;
        }
        Player p = (Player) sender;
        if (p.hasPermission("LobbySystem.SetWarp")) {
            if (args.length == 1) {

                File file = new File("plugins/LobbySystem", "Warps.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                String id = args[0];

                String world = p.getWorld().getName();

                double x = p.getLocation().getX();
                double y = p.getLocation().getY();
                double z = p.getLocation().getZ();

                double yaw = p.getLocation().getYaw();
                double pitch = p.getLocation().getPitch();

                cfg.set(".Warps" + "." + id + ".World", world);
                cfg.set(".Warps" + "." + id + ".X", x);
                cfg.set(".Warps" + "." + id + ".Y", y);
                cfg.set(".Warps" + "." + id + ".Z", z);
                cfg.set(".Warps" + "." + id + ".Yaw", yaw);
                cfg.set(".Warps" + "." + id + ".Pitch", pitch);

                String sucess = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.SetWarp.Set")).replaceAll("%warpname%", id);

                p.sendMessage(sucess);

                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                String usage = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.SetWarp.Usage"));
                p.sendMessage(usage);
            }
        } else {
            String noperm = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.General.NoPermissions"));
            p.sendMessage(noperm);
        }
        return false;
    }
                   /*
                        String msg = this.mm.getConfig().getString("Messages.WarpSystem.WarpExists").replace("&", "§").replaceAll("%warpname%", args[0]);
                        p.sendMessage(msg);*/
}
