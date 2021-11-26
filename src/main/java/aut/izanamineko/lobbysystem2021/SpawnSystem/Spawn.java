package aut.izanamineko.lobbysystem2021.SpawnSystem;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class Spawn implements CommandExecutor {

    main plugin;

    MessagesManager mm = new MessagesManager();

    public Spawn(main instance) {
        this.plugin = instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("You need to be a Player");
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("LobbySystem.Spawn")) {
            String msg = this.mm.getConfig().getString("Messages.General.NoPermissions").replace("&", "§").replaceAll("%player%", p.getName());
            p.sendMessage(msg);
            return true;
        }

        File file = new File("plugins/LobbySystem2021/spawnloc.yml");
        if (!file.exists()) {
            String msg = this.mm.getConfig().getString("Messages.Spawn.DoesntExist").replace("&", "§");
            p.sendMessage(msg);
            return true;
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Location loc = p.getLocation();
        double x = cfg.getDouble("X");
        double y = cfg.getDouble("Y");
        double z = cfg.getDouble("Z");
        double yaw = cfg.getDouble("Yaw");
        double pitch = cfg.getDouble("Pitch");
        String worldname = cfg.getString("Worldname");
        World w = Bukkit.getWorld(worldname);
        loc.setX(x);
        loc.setY(y);
        loc.setZ(z);
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);
        loc.setWorld(w);
        p.teleport(loc);
        return true;
    }
}
