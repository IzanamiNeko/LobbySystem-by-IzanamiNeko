package aut.izanamineko.lobbysystem2021.WarpSystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class WarpList implements CommandExecutor {


    public static void CheckDir(){
        File file = new File("plugins/LobbySystem2021/Warps");
        if(!file.exists()){
            file.mkdir();
        } else {
            System.out.println("WarpList Directory was found!");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player)sender;
        CheckDir();
        if(cmd.getName().equalsIgnoreCase("warplist") && p.hasPermission("LobbySystem.Warplist")) {





            p.sendMessage("----- Warplist -----");
            p.sendMessage("");

        } else {
            p.sendMessage("Didnt work out yet");
        }

        return true;
    }
}
