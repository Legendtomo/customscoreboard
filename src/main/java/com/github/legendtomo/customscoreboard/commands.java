package com.github.legendtomo.customscoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;


public class commands implements CommandExecutor {
    private main plugin;
    public commands(main pl){
        plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("customscoreboard")){
            if (args[0].equalsIgnoreCase("reload")){
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "reload config");
                return true;
            }

            if (args[0].equalsIgnoreCase("change")){
                if (args.length == 3){
                    ScoreboardManager manager = Bukkit.getScoreboardManager();
                    Scoreboard scoreboard = manager.getMainScoreboard();
                    Objective objective = scoreboard.getObjective(args[1]);
                    String objectName = objective.getName();
                    String displayName = objective.getDisplayName();
                    objective.setDisplayName(args[2]);
                    sender.sendMessage(ChatColor.GREEN + "success!" + ChatColor.WHITE + " : " + ChatColor.YELLOW + displayName + ChatColor.WHITE + " » " + ChatColor.YELLOW + args[2] + ChatColor.WHITE + " (" + ChatColor.AQUA + objectName +ChatColor.WHITE+ ")" );
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "fail! : " + ChatColor.GOLD + "/cmd change [ObjectName] [ChangeName]");
                    return true;
                }
            }
        }
        return false;
    }
}
