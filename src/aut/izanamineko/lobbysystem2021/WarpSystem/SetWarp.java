package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.ConfigManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SetWarp implements CommandExecutor {

    ConfigManager cfgm;

    public SetWarp(ConfigManager instance) {
        cfgm = instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String strings, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("LobbySystem.SetWarp") || p.isOp()) {
            if (sender instanceof Player) {
                if (args.length < 1) {
                    String msg = cfgm.getMessagesCFG().getString("WarpSystem.SetCMD").replace("&", "§");
                    p.sendMessage(msg);
                    return true;
                }
                if (args.length > 0) {
                    File file = new File("plugins/LobbySystem2021/Warps/" + args[0] + ".yml");


                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
                        yamlConfiguration.set("Warplist.Location.X", Double.valueOf(p.getLocation().getX()));
                        yamlConfiguration.set("Warplist.Location.Y", Double.valueOf(p.getLocation().getY()));
                        yamlConfiguration.set("Warplist.Location.Z", Double.valueOf(p.getLocation().getZ()));
                        yamlConfiguration.set("Warplist.Location.Yaw", Float.valueOf(p.getLocation().getYaw()));
                        yamlConfiguration.set("Warplist.Location.Pitch", Float.valueOf(p.getLocation().getPitch()));
                        yamlConfiguration.set("Warplist.Location.World", p.getWorld().getName());
                        try {
                            yamlConfiguration.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String msg = cfgm.getMessagesCFG().getString("WarpSystem.SetWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                        p.sendMessage(msg);
                    } else {
                        String msg = cfgm.getMessagesCFG().getString("WarpSystem.NoWarp").replace("&", "§");
                        p.sendMessage(msg);
                    }
                }
            }
        } else {
            String msg = cfgm.getMessagesCFG().getString("General.NoPerm").replace("&", "§").replaceAll("%player%", p.getDisplayName());
            p.sendMessage(msg);
        }
        return true;
    }
}
