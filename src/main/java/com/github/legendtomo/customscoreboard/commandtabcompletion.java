package com.github.legendtomo.customscoreboard;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commandtabcompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("customscoreboard")){
            if (args.length == 1){
                return Arrays.asList("change","reload");
            } else if (args.length == 2){
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                Scoreboard scoreboard = manager.getMainScoreboard();
                List<String> objectList = new ArrayList<>();

                for (Objective objective : scoreboard.getObjectives()){
                    objectList.add(objective.getName());
                }
                return objectList;
            }
            return null;
        }
        return null;
    }
}
