package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;


public class Warp implements CommandExecutor {


    main plugin;

    MessagesManager mm = new MessagesManager();

    public Warp(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can use this Command only as a Player");
            return true;
        }
        Player p = (Player)sender;

        if(p.hasPermission("LobbySystem.Warp")) {
            if(args.length == 1) {

                File file = new File("plugins/LobbySystem", "Warps.yml");
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                String id = args[0];

                if(cfg.getString(".Warps." + id) != null) {

                } else {
                    String nowarp = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.NoWarp")).replaceAll("%warpname%", id);
                    sender.sendMessage(nowarp);
                    return true;
                }

                World world = Bukkit.getWorld(cfg.getString(".Warps" + "." + id + ".World"));

                double x = cfg.getDouble(".Warps" + "." + id + ".X");
                double y = cfg.getDouble(".Warps" + "." + id + ".Y");
                double z = cfg.getDouble(".Warps" + "." + id + ".Z");

                float yaw = (float) cfg.getDouble(".Warps" + "." + id + ".Yaw");
                float pitch = (float) cfg.getDouble(".Warps" + "." + id + ".Pitch");

                p.teleport(new Location(world, x, y, z, yaw, pitch));

                String warped = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.Warp.Warped")).replaceAll("%warpname%", id );
                p.sendMessage(warped);

            } else {
                String usage = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.Warp.Usage"));
                p.sendMessage(usage);
            }
        } else {
            String noperm = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.General.NoPermissions"));
            p.sendMessage(noperm);
        }
        return false;
    }

}

