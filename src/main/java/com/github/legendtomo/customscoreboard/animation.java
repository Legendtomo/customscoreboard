package com.github.legendtomo.customscoreboard;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.List;
import java.util.Set;

public class animation implements Listener {
    private main plugin;

    public animation(main pl) {
        this.plugin = pl;
    }

    int a = 0;

    @EventHandler
    public void EnableEvent(PluginEnableEvent e) {
        boolean enabled = plugin.getConfig().getBoolean("animation");
        if (enabled) {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = manager.getMainScoreboard();
            Set<String> objectivesName = plugin.getConfig().getConfigurationSection("objective").getKeys(false);
            for (String objectiveName : objectivesName) {
                List<String> animations = plugin.getConfig().getStringList("objective." + objectiveName + ".display");
                Objective objective = scoreboard.getObjective(objectiveName);
                int delay = plugin.getConfig().getInt("objective." + objectiveName + ".delay");

                new BukkitRunnable() {
                    int count = 0;

                    @Override
                    public void run() {
                        if (count < animations.size()) {
                            objective.setDisplayName(animations.get(count));
                            count++;
                            if (count == animations.size()) {
                                count = 0;
                            }
                        }
                    }
                }.runTaskTimer(plugin, 10, 10);
            }
        }
    }
}


