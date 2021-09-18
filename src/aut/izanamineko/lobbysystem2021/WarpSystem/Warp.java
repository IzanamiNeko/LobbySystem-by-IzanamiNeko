package aut.izanamineko.lobbysystem2021.WarpSystem;

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

    public Warp(main instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("LobbySystem.Warp")) {
            if (sender instanceof Player) {
                if (args.length < 1) {
                    String msg = this.plugin.getConfig().getString("Config.WarpSystem.WarpCMD").replace("&", "§");
                    p.sendMessage(msg);
                    return true;
                }
                if (args.length > 0) {
                    File file = new File("plugins/LobbySystem2021/WarpSystem/Warps", args[0] + ".yml");
                    if (!file.exists()) {
                        String msg = this.plugin.getConfig().getString("Config.WarpSystem.NoWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                        p.sendMessage(msg);
                        return true;
                    }
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
                    p.teleport(loc);
                    String msg = this.plugin.getConfig().getString("Config.WarpSystem.Warped").replace("&", "§");
                    p.sendMessage(msg);
                } else {
                    String msg = this.plugin.getConfig().getString("Config.General.NoPerm").replace("&", "§");
                    p.sendMessage(msg);
                }
            }
        }
        return true;
    }
}
