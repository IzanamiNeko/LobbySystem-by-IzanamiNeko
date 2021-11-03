package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
        Player p = (Player) sender;
        if (p.hasPermission("LobbySystem.SetWarp") || p.isOp()) {
            if (sender instanceof Player) {
                if (args.length < 1) {
                    String test = this.mm.getConfig().getString("Messages.WarpSystem.SetCMD").replace("&", "§");
                    //String msg = this.plugin.getConfig().getString("WarpSystem.SetCMD").replace("&", "§");
                    p.sendMessage(test);
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
                        String msg = this.mm.getConfig().getString("Messages.WarpSystem.SetWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                        p.sendMessage(msg);
                    } else {
                        String msg = this.mm.getConfig().getString("Messages.WarpSystem.WarpExists").replace("&", "§").replaceAll("%warpname%", args[0]);
                        p.sendMessage(msg);
                    }
                }
            }
        } else {
            String msg = this.plugin.getConfig().getString("General.NoPermissions").replace("&", "§").replaceAll("%player%", p.getDisplayName());
            p.sendMessage(msg);
        }
        return true;
    }
}
