package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class BugCMD implements CommandExecutor {

    main plugin;

    MessagesManager mm = new MessagesManager();


    public BugCMD(main plugin) {
        this.plugin = plugin;
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        String bug = "";

        Random rand = new Random();
        int upperbound = 2147483647;
        int int_random = rand.nextInt(upperbound);

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can use this Command only as a Player");
            return true;
        }
        if(args.length < 1) {
            String usage = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.BugCMD.Usage"));
            p.sendMessage(usage);
            return true;
        }


        for (int i = 0; i < args.length; i++)
            bug = bug + args[i] + " ";
        for (Player players : Bukkit.getOnlinePlayers()) {
            String sendmsg = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.BugCMD.BugReported")).replaceAll("%id%", String.valueOf(int_random));
            p.sendMessage(sendmsg);
            if (players.hasPermission("LobbySystem.ReceiveBug")) {
                String msg = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.BugCMD.ID-Message")).replaceAll("%player%", sender.getName()).replaceAll("%id%", String.valueOf(int_random));
                players.sendMessage(msg);

                players.playSound(players.getLocation(), Sound.BLOCK_ANVIL_USE, 10.0F, 10.0F);
                File file = new File("plugins/LobbySystem/Bugs/ID" + int_random + ".yml");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[LobbySystem] Somebody reported a new Bug!");
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
                cfg.set("Time", new Date(System.currentTimeMillis()));
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                continue;
            }
        }
        return true;
    }
}