package aut.izanamineko.lobbysystem2021.TabScore;

import aut.izanamineko.lobbysystem2021.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class bScoreboard implements Listener {
    private main plugin;

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
        int stunden = this.plugin.getConfig().getInt(e.getPlayer().getName() + ".Stunden");
        //String gruppe = PermissionsEx.getUser(e.getPlayer()).getGroupNames()[0];
        //String prefix = PermissionsEx.getUser(e.getPlayer()).getGroups()[0].getPrefix().replace("&", ");
        String server = Bukkit.getServer().getName().replace("&","§");
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objekt = board.registerNewObjective("bla", "blub");
        objekt.setDisplayName(ChatColor.BLACK + "The-Gaming-Project");
        objekt.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score lobby = objekt.getScore(ChatColor.DARK_PURPLE + "Server:");
        Score lobby1 = objekt.getScore(server);
        Score frei = objekt.getScore(ChatColor.DARK_AQUA.toString());
        Score spielzeit = objekt.getScore(ChatColor.DARK_BLUE + "Online:");
        Score eleven = objekt.getScore("Kommt noch!");
        Score ten = objekt.getScore(ChatColor.AQUA.toString());
        Score nine = objekt.getScore(ChatColor.DARK_BLUE + "Rang und Name:");
        Score eight = objekt.getScore(e.getPlayer().getDisplayName());
        Score seven = objekt.getScore(ChatColor.RED.toString());
        Score five = objekt.getScore(ChatColor.DARK_BLUE + "Coins:");
        Score four = objekt.getScore("Verfuegbar!");
        Score three = objekt.getScore(ChatColor.GOLD.toString());
        Score one = objekt.getScore(ChatColor.DARK_PURPLE + "TeamSpeak:");
        Score zero = objekt.getScore("");
        lobby.setScore(13);
        lobby1.setScore(12);
        frei.setScore(11);
        spielzeit.setScore(7);
        eleven.setScore(6);
        ten.setScore(8);
        nine.setScore(10);
        eight.setScore(9);
        seven.setScore(5);
        five.setScore(4);
        four.setScore(3);
        three.setScore(2);
        one.setScore(1);
        zero.setScore(0);
        e.setScoreboard(board);
    }
}