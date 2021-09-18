package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;


public class SetWarp implements CommandExecutor {

    main plugin;

    public SetWarp(main instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String strings, String[] args) {

        Player p = (Player)sender;
        if(p.hasPermission("LobbySystem.SetWarp")) {
        if(sender instanceof Player){
            if(args.length < 1) {
                String msg = this.plugin.getConfig().getString("Config.WarpSystem.SetCMD").replace("&", "§");
                p.sendMessage(msg);
                return true;
            }
          if(args.length > 0) {

                  File file = new File("plugins/LobbySystem2021/WarpSystem/Warps", args[0] + ".yml");
                  if (!file.exists()) {
                      try {
                          file.createNewFile();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                      YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
                      yamlConfiguration.set("Location.X", Double.valueOf(p.getLocation().getX()));
                      yamlConfiguration.set("Location.Y", Double.valueOf(p.getLocation().getY()));
                      yamlConfiguration.set("Location.Z", Double.valueOf(p.getLocation().getZ()));
                      yamlConfiguration.set("Location.Yaw", Float.valueOf(p.getLocation().getYaw()));
                      yamlConfiguration.set("Location.Pitch", Float.valueOf(p.getLocation().getPitch()));
                      yamlConfiguration.set("Location.World", p.getWorld().getName());
                      try {
                          yamlConfiguration.save(file);
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                      String msg = this.plugin.getConfig().getString("Config.WarpSystem.SetWarp").replace("&", "§").replaceAll("%warpname%", args[0]);
                      p.sendMessage(msg);
                  } else {
                      String msg = this.plugin.getConfig().getString("Config.WarpSystem.NoWarp").replace("&", "§");
                      p.sendMessage(msg);
                  }
              }  else {
                  String msg = this.plugin.getConfig().getString("Config.General.NoPerm").replace("&", "§");
                  p.sendMessage(msg);
              }
          }
        }



        return true;
    }
}
