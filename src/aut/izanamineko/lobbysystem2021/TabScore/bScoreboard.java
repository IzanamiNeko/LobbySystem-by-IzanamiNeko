package aut.izanamineko.lobbysystem2021.TabScore;

import aut.izanamineko.lobbysystem2021.Utils.ScoreboardManager;
import aut.izanamineko.lobbysystem2021.main;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class bScoreboard implements Listener {


    private main plugin;

    ScoreboardManager sb = new ScoreboardManager();

    public bScoreboard(main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, (Plugin)plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        updateScoreBoard(p);
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)this.plugin, new Runnable() {
            public void run() {
                bScoreboard.this.updateScoreBoard(p);
            }
        },  20L, 20L);
    }

    public void updateScoreBoard(Player e) {
        Player p = e.getPlayer();
        int stunden = this.plugin.getConfig().getInt(e.getPlayer().getName() + ".Stunden");
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objekt = board.registerNewObjective("bla", "blub");
        int online = Bukkit.getOnlinePlayers().size();
        int maxplayer = Bukkit.getMaxPlayers();

        String title = this.sb.getConfig().getString("Scoreboard.Title").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String dreizehn = this.sb.getConfig().getString("Scoreboard.13").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zwoelf = this.sb.getConfig().getString("Scoreboard.12").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String elf = this.sb.getConfig().getString("Scoreboard.11").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zehn = this.sb.getConfig().getString("Scoreboard.10").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String neun = this.sb.getConfig().getString("Scoreboard.9").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String acht = this.sb.getConfig().getString("Scoreboard.8").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String sieben = this.sb.getConfig().getString("Scoreboard.7").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String sechs = this.sb.getConfig().getString("Scoreboard.6").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String fuenf = this.sb.getConfig().getString("Scoreboard.5").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String vier = this.sb.getConfig().getString("Scoreboard.4").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String drei = this.sb.getConfig().getString("Scoreboard.3").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zwei = this.sb.getConfig().getString("Scoreboard.2").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String eins = this.sb.getConfig().getString("Scoreboard.1").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
        String zero = this.sb.getConfig().getString("Scoreboard.0").replace("&", "§").replaceAll("%online%", String.valueOf(online)).replaceAll("%maxplayer%", String.valueOf(maxplayer));
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
    }
}