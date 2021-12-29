package aut.izanamineko.lobbysystem2021.commands;

import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import aut.izanamineko.lobbysystem2021.Utils.RepairUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

import static aut.izanamineko.lobbysystem2021.Utils.RepairUtils.repairAll;

public class RepairCommand implements CommandExecutor {

    MessagesManager mm = new MessagesManager();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        String repairall = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, this.mm.getConfig().getString("Messages.Repair.RepairAll")));
        String usage = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, this.mm.getConfig().getString("Messages.Repair.Usage")));

        String noperm = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, this.mm.getConfig().getString("Messages.General.NoPermissions").replaceAll("%player%", player.getPlayerListName())));

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can use this Command only as a Player");
            return true;
        }
        if (!player.hasPermission("LobbySystem.Repair")) {
            player.sendMessage(noperm);
            return true;
        }
        if (args.length == 0) {
            player.sendMessage(ChatColor.DARK_RED + "TEST");
            RepairUtils.repairHand(player);
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("all")) {
                RepairUtils.repairAll(player);
                player.sendMessage(repairall);
            } else {
                player.sendMessage(usage);
            }
        }
        return false;
    }
}
