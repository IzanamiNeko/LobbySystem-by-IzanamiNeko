package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    MessagesManager mm = new MessagesManager();



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

            if (args.length == 0 && player.hasPermission("LobbySystem.Heal") || player.isOp()) {
                player.setHealth(20);
                player.setFoodLevel(20);
                String healed = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setBracketPlaceholders(player, this.mm.getConfig().getString("Messages.Heal.Healed")));
                player.sendMessage(healed);
            } else {
                String noperm = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, this.mm.getConfig().getString("Messages.General.NoPermissions").replaceAll("%player%", player.getPlayerListName())));
                player.sendMessage(noperm);
            }
            if (args.length == 1 && player.hasPermission("LobbySystem.Heal.Other") || player.isOp()) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    String targetm = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setBracketPlaceholders(player, this.mm.getConfig().getString("Messages.Heal.Healed")));
                    target.sendMessage(targetm);
                    String playerm = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setBracketPlaceholders(player, this.mm.getConfig().getString("Messages.Heal.OtherPlayer")).replaceAll("%healplayer%", target.getPlayerListName()));
                    player.sendMessage(playerm);
                } else {
                    String notonline = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setBracketPlaceholders(player, this.mm.getConfig().getString("Messages.Heal.NotOnline")).replaceAll("%notonline%", args[0]));
                    player.sendMessage(notonline);
                }
            } else if(!player.hasPermission("LobbySystem.Heal.Other") || player.isOp()) {
                String noperm = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, this.mm.getConfig().getString("Messages.General.NoPermissions").replaceAll("%player%", player.getPlayerListName())));
                player.sendMessage(noperm);
            } else {
                String usage = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, this.mm.getConfig().getString("Messages.Heal.Usage")));
                player.sendMessage(usage);
            }
        return false;
    }
}
