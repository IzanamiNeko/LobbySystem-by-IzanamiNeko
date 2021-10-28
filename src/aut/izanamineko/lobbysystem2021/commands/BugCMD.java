package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.ConfigManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class BugCMD implements CommandExecutor {

     main plugin;


    public BugCMD(main plugin) {
        this.plugin = plugin;
    }



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        String bug = "";

                if (sender instanceof Player) {
            if (args.length < 1) {
                p.sendMessage("Nutze /bug <bug> einen Bug zu reporten!");
                return true;
            }
            for (int i = 0; i < args.length; i++)
                bug = bug + args[i] + " ";
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (players.hasPermission("LobbySystem.ReceiveBug")) {
                    String msg = this.plugin.getConfig().getString("BugCMD.Message").replaceAll("%player%", sender.getName()).replace("&", "§");
                    players.sendMessage(msg);
                    String msg2 = this.plugin.getConfig().getString("BugCMD.BugReport").replace("&", "§").replaceAll("%bug%", bug);
                    players.sendMessage(msg2);
                    players.playSound(players.getLocation(), Sound.BLOCK_ANVIL_USE, 10.0F, 10.0F);
                    File file = new File("plugins/LobbySystem2021/ReportBugs/Bug found by " + p.getDisplayName() + ".yml");
                    if(!file.exists()){
                        try {
                            file.createNewFile();
                            Bukkit.getConsoleSender().sendMessage("A new Bug got reported");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Bukkit.getConsoleSender().sendMessage("");
                    }
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                    cfg.options().header("Bug-Report by IzanamiNeko");
                    cfg.set("Displayname", p.getDisplayName());
                    cfg.set("UUID", p.getUniqueId());
                    cfg.set("Bug-Report", bug);
                    cfg.set("Ping (MS)", p.getPing());
                    cfg.set("Location", p.getLocation());
                    cfg.set("Time", new  Date(System.currentTimeMillis()));
                    try {
                        cfg.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    continue;
                }

            }
        } else {
            System.out.println(ChatColor.RED + "Dies ist ein Ingame Command!");
        }
        return true;
    }
}