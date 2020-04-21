package com.github.legendtomo.customscoreboard;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{

     FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        getCommand("customscoreboard").setExecutor(new commands(this));
        getCommand("customscoreboard").setTabCompleter(new commandtabcompletion());

        getConfig().options().copyDefaults(true);
        saveConfig();


        Bukkit.getServer().getPluginManager().registerEvents(new animation(this), this);

    }


}
