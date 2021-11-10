package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
        Player p = (Player) sender;
            if (p.hasPermission("LobbySystem.Warp") || p.isOp()) {


                if (args.length > 0) {
                    File file = new File("plugins/LobbySystem2021/Warps/" + args[0] + ".yml");

                    if (!file.exists()) {
                        String msg = this.mm.getConfig().getString("Messages.WarpSystem.NoWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                        p.sendMessage(msg);
                        return true;
                    } else {


                        //Loading Config Values into the Game
                        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                        double x = cfg.getDouble("Location.X");
                        double y = cfg.getDouble("Location.Y");
                        double z = cfg.getDouble("Location.Z");
                        float yaw = (float) cfg.getDouble("Location.Yaw");
                        float pitch = (float) cfg.getDouble("Location.Pitch");
                        String worldname = cfg.getString("Location.World");
                        World welt = Bukkit.getWorld(worldname);
                        Location loc = p.getLocation();
                        loc.setX(x);
                        loc.setY(y);
                        loc.setZ(z);
                        loc.setYaw(yaw);
                        loc.setPitch(pitch);
                        loc.setWorld(welt);
                        //Teleports player to the location in the CONFIG
                        p.teleport(loc);


                        //String for sending the Player the Message he has been warped
                        String msg = this.mm.getConfig().getString("Messages.WarpSystem.Warped").replace("&", "§");
                        p.sendMessage(msg);

                    }
                }
                } else {
                    String msg = this.mm.getConfig().getString("General.NoPermissions").replace("&", "§").replaceAll("%player%", p.getName());
                    p.sendMessage(msg);
                }
        return true;
    }
}

