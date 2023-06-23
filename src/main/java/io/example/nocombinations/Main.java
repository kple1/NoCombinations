package io.example.nocombinations;

import io.example.nocombinations.Commands.MainCommand;
import io.example.nocombinations.Listener.CreateItemCancel;
import io.example.nocombinations.Listener.CreateNewPage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginCommand("noCombinations").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new CreateItemCancel(), this);
        Bukkit.getPluginManager().registerEvents(new CreateNewPage(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }
}
