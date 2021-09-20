package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.main;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCMD implements CommandExecutor {
    private main plugin;

    public PingCMD(main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        double ms = getPing(p);
        if(p.hasPermission("LobbySystem.Ping")) {
            String msg = this.plugin.getConfig().getString("Config.PingCMD.Message").replace("&", "§").replaceAll("%ms%", String.valueOf(ms));
            p.sendMessage(msg);
        } else {
            String msg1 = this.plugin.getConfig().getString("Config.General.NoPerm").replace("&", "§").replaceAll("%player%", p.getName());
            p.sendMessage(msg1);
        }
        return true;
    }

    public double getPing(Player p) {
        CraftPlayer pinger = (CraftPlayer)p;
        EntityPlayer pings = pinger.getHandle();
        return pings.ping;
    }
}
