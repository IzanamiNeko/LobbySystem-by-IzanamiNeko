package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.ConfigManager;
import aut.izanamineko.lobbysystem2021.main;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCMD implements CommandExecutor {

    main plugin;


    public PingCMD(main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        double ms = getPing(p);
        if (cmd.getName().equals("ping")) {
            if (p.hasPermission("LobbySystem.PingCMD")) {
                String msg = this.plugin.getConfig().getString("PingCMD.Message").replace("&", "§").replaceAll("%ms%", String.valueOf(ms));
                p.sendMessage(msg);
            } else {
                String msg1 = this.plugin.getConfig().getString("General.NoPerm").replace("&", "§").replaceAll("%player%", p.getName());
                p.sendMessage(msg1);
            }
        }
        return true;
    }


   public double getPing(Player p) {
        CraftPlayer pinger = (CraftPlayer)p;
        EntityPlayer pings = pinger.getHandle();
       return 0;
    }
}
