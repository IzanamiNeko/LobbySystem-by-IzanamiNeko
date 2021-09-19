package aut.izanamineko.lobbysystem2021.events;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;


public class PlayerInformation implements Listener {

    main plugin;

    public PlayerInformation(main instance) {
        this.plugin = instance;
    }

    public static void CheckPI() {
        File file = new File("plugins/LobbySystem2021/PlayerInformation");
        if (!file.isDirectory())
            file.mkdirs();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException             //Das PlayerJoinEvent wird mit einer Variablen versehen
    {
        Player p = e.getPlayer();
        if (this.plugin.getConfig().getString("Config.DataCollect.Enabled").equals("true")) {
            File file = new File("plugins/LobbySystem2021/PlayerInformation/", p.getDisplayName().toLowerCase() + ".yml");
            CheckPI();
            String msg1 = this.plugin.getConfig().getString("Config.DataCollect.Note").replace("&", "§");
            String msg2 = this.plugin.getConfig().getString("Config.DataCollect.Note2").replace("&", "§");
            String msg3 = this.plugin.getConfig().getString("Config.DataCollect.Note3").replace("&", "§");
            p.sendMessage(msg1);
            p.sendMessage(msg2);
            p.sendMessage(msg3);

            if (!file.exists()) {
                file.createNewFile();
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("Username", p.getDisplayName());
                cfg.set("Displayname", p.getDisplayName());
                cfg.set("UUID", p.getUniqueId());
                //yamlConfiguration.set("Inventory", p.getInventory());
                //fg.set("Location", p.getPlayer().getLocation().getWorld().getName());
                cfg.save(file);
            } else {
                System.out.println("No Player Information found.");
            }
        } else {
            return;
        }
    }

    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        File file = new File("plugins/LobbySystem2021/PlayerInformation/", p.getDisplayName() + ".yml");
        file.delete();

}
}
