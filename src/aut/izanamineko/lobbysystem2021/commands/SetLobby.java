package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetLobby implements CommandExecutor {

    main plugin;

    public SetLobby(main instance) {
        this.plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("You need to be a Player");
            return true;
        }
        Player p = (Player)sender;
        if (!p.hasPermission("LobbySystem.SetLobby")) {
            String msg = this.plugin.getConfig().getString("Config.Spawn.Permissions").replace("&", "§");
            p.sendMessage(msg);
            return true;
        }
        File file = new File("plugins/LobbySystem2021/spawnloc.yml");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                p.sendMessage("!");
            }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Location loc = p.getLocation();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double yaw = loc.getYaw();
        double pitch = loc.getPitch();
        String worldname = loc.getWorld().getName();
        cfg.set("X", Double.valueOf(x));
        cfg.set("Y", Double.valueOf(y));
        cfg.set("Z", Double.valueOf(z));
        cfg.set("Yaw", Double.valueOf(yaw));
        cfg.set("Pitch", Double.valueOf(pitch));
        cfg.set("Worldname", worldname);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String msg = this.plugin.getConfig().getString("Config.Spawn.Set");
        msg.replace("&", "§");
        p.sendMessage(msg);
        return true;
    }
}
