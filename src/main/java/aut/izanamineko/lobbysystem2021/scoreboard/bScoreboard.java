package aut.izanamineko.lobbysystem2021.scoreboard;

import aut.izanamineko.lobbysystem2021.Utils.ScoreboardConfigManager;
import aut.izanamineko.lobbysystem2021.main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;


public class bScoreboard implements Listener {


   /* private main plugin;

    ScoreboardConfigManager sb = new ScoreboardConfigManager();

    public bScoreboard(main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, (Plugin)plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e, OfflinePlayer offline) {
        Player p = e.getPlayer();
        updateScoreBoard(p);
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)this.plugin, new Runnable() {
            public void run() {
                bScoreboard.this.updateScoreBoard(p);
            }
        },  20L, 20L);
    }


    public void updateScoreBoard(Player p) {
        Player player  = p.getPlayer();
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objekt = board.registerNewObjective("one", "two");
        int online = Bukkit.getOnlinePlayers().size();
        int maxplayer = Bukkit.getMaxPlayers();

        String title = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.Title"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String dreizehn = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.13"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zwoelf = ChatColor.translateAlternateColorCodes('&',PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.12"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String elf = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.11"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zehn = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.10"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String neun = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.9"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String acht = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.8"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String sieben = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.7"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String sechs = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.6"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String fuenf = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.5"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String vier = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.4"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String drei = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.3"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zwei = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.2"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String eins = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.1"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zero = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, this.sb.getConfig().getString("Scoreboard.0"))).replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        objekt.getScore(dreizehn).setScore(13);
        objekt.getScore(zwoelf).setScore(12);
        objekt.getScore(elf).setScore(11);
        objekt.getScore(zehn).setScore(10);
        objekt.getScore(neun).setScore(9);
        objekt.getScore(acht).setScore(8);
        objekt.getScore(sieben).setScore(7);
        objekt.getScore(sechs).setScore(6);
        objekt.getScore(fuenf).setScore(5);
        objekt.getScore(vier).setScore(4);
        objekt.getScore(drei).setScore(3);
        objekt.getScore(zwei).setScore(2);
        objekt.getScore(eins).setScore(1);
        objekt.getScore(zero).setScore(0);
        objekt.setDisplayName(title);
        objekt.setDisplaySlot(DisplaySlot.SIDEBAR);


        e.setScoreboard(board);
    }*/
}