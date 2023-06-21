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
            for (int i = 0; i < 54; i++) {
                ItemStack item = plugin.getConfig().getItemStack("inventory." + i + ".item");
                if (item == null) {
                    continue;
                }

                if (event.getCurrentItem().getType() == item.getType()) {  // 수정: item.getType()으로 비교
                    player.sendMessage(Color.chat("&c&l[!] &f해당 아이템은 제작이 불가능합니다."));
                    event.setCancelled(true);
                }
            }
        }
    }
}
