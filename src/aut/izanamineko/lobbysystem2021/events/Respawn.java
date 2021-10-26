package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.io.File;

public class Respawn implements Listener {
    main plugin;

    public Respawn(main instance) {
        this.plugin = instance;
    }


    @EventHandler
        public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        File file = new File("plugins/LobbySystem2021/spawnloc.yml");
        if (!file.exists())
            return;
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Location loc = p.getLocation();
        double x = cfg.getDouble("X");
        double y = cfg.getDouble("Y");
        double z = cfg.getDouble("Z");
        double yaw = cfg.getDouble("Yaw");
        double pitch = cfg.getDouble("Pitch");
        String worldname = cfg.getString("Worldname");
        World welt = Bukkit.getWorld(worldname);
        loc.setX(x);
        loc.setY(y);
        loc.setZ(z);
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);
        loc.setWorld(welt);
        e.setRespawnLocation(loc);
    }
}

