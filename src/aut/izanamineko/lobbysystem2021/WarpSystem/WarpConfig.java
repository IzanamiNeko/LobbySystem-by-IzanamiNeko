package aut.izanamineko.lobbysystem2021.WarpSystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WarpConfig {



    public static void WarpSysConf(){
        File file = new File("plugins/LobbySystem2021/WarpSystem/WarpSysConfig.yml");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        cfg.options().header("WarpSystem Config by IzanamiNeko");
        cfg.addDefault("WarpSystem.Warp", "&8[&3System&8] &7You've been warped!");
        cfg.addDefault("WarpSystem.SetWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been set!");
        cfg.addDefault("WarpSystem.DelWarp", "&8[&3System&8] &7The Warp &4%warpname%  &7has been deleted!");
        cfg.addDefault("WarpSystem.WarpCMD", "&8[&3System&8] &7Use /warp [warpname]!");
        cfg.addDefault("WarpSystem.SetCMD", "&8[&3System&8] &7Use /setwarp [warpname]!\"");

        }

}
