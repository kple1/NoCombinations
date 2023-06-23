package io.example.nocombinations.Listener;

import io.example.nocombinations.Utils.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import static io.example.nocombinations.Main.plugin;

public class CreateItemCancel implements Listener {

    @EventHandler
    public void ClickCancel(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getType() == InventoryType.WORKBENCH) {
            for (int i = 0; i <= 100; i++) {
                for (int j = 0; j < 54; j++) {
                    ItemStack item = plugin.getConfig().getItemStack("inventory." + i + "." + j + ".item");
                    if (item == null) {
                        continue;
                    }

                    if (event.getCurrentItem() != null && event.getCurrentItem().getType() == item.getType()) {
                        player.sendMessage(Color.chat("&c&l[!] &f해당 아이템은 제작이 불가능합니다."));
                        event.setCancelled(true);
                        return;
                    }
                }
            }
        }
    }
}
