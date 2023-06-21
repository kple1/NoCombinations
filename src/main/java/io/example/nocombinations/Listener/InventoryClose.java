package io.example.nocombinations.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static io.example.nocombinations.Main.plugin;

public class InventoryClose implements Listener {

    private Inventory inv;

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (event.getView().getTitle().equals("조합금지")) {
            inv = event.getInventory();
            for (int i = 0; i < 54; i++) {
                ItemStack item = inv.getItem(i);
                if (item != null) {
                    plugin.getConfig().set("getItems." + i + ".item", item);
                } else {
                    plugin.getConfig().set("getItems." + i + ".item", null);
                }
            }
            plugin.saveConfig();
            player.sendMessage("정보가 저장되었습니다.");
        }
    }
}
