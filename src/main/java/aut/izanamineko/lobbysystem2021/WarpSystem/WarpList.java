package aut.izanamineko.lobbysystem2021.WarpSystem;

import aut.izanamineko.lobbysystem2021.Utils.ConfigManager;
import aut.izanamineko.lobbysystem2021.Utils.MessagesManager;
import net.md_5.bungee.protocol.packet.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WarpList implements CommandExecutor {

    MessagesManager mm = new MessagesManager();
    ConfigManager cm = new ConfigManager();

    public static void CheckDir(){
        File file = new File("plugins/LobbySystem2021/Warps");
        if(!file.exists()){
            file.mkdir();
        } else {
            Bukkit.getLogger().info(ChatColor.RED + "[LobbySystem] Warps-Dir couldnt get found!");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[LobbySystem] You can only use this Command as a Player");
            return true;
        }
        Player p = (Player)sender;

        if(p.hasPermission("LobbySystem.Warplist")) {

            File file = new File("plugins/LobbySystem", "Warps.yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            String warplist = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.WarpSystem.Warplist"));
            p.sendMessage(warplist);
            String altColor = ChatColor.translateAlternateColorCodes('&', this.cm.getConfig().getString("Config.Warplist.Color"));
            p.sendMessage(altColor + cfg.getConfigurationSection(".Warps").getKeys(false));

        } else {
            String noperm = ChatColor.translateAlternateColorCodes('&', this.mm.getConfig().getString("Messages.General.NoPermissions"));
            p.sendMessage(noperm);
        }
        return false;
    }
}
