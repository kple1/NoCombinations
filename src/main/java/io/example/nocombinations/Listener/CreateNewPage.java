package io.example.nocombinations.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateNewPage implements Listener {
    private int page = 1; // Initial page value

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.getType() == Material.ARROW && event.getRawSlot() == 53) {
            event.setCancelled(true);

            Inventory newInventory = Bukkit.createInventory(null, 54, event.getView().getTitle() + " " + (page + 1) + "Page");
            newInventory.setContents(inventory.getContents());
            player.openInventory(newInventory);

            player.sendMessage("새로운 인벤토리가 생성되었습니다!");

            page++; // Increment the page variable
        }
    }
}
