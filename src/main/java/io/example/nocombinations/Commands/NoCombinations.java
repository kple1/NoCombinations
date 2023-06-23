package io.example.nocombinations.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static io.example.nocombinations.Main.plugin;

public class NoCombinations implements CommandExecutor {

    private Inventory inv;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            this.inv = Bukkit.createInventory(null, 54, "0Page");
            for (int i = 0; i < 53; i++) {
                ItemStack item = plugin.getConfig().getItemStack("inventory." + i + ".item");
                inv.setItem(i, item);
                ItemStack itemStack = new ItemStack(Material.ARROW);
                inv.setItem(53, itemStack);
            }
            player.openInventory(inv);
        }
        return false;
    }
}
