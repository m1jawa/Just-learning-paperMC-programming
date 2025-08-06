package m1jawa.paperMCLearning.Listeners;

import m1jawa.paperMCLearning.PluginItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.EventListener;

public class InventoryClickListener implements Listener {
    @EventHandler
    private void PlayerClickInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        if (e.getCurrentItem() == null) return;
        if (clickedItem.isSimilar(PluginItems.MagicWand)) {
            player.getInventory().addItem(PluginItems.MagicWand);
        } else if (clickedItem.isSimilar(PluginItems.CommonApple)) {
            player.getInventory().addItem(PluginItems.CommonApple);
        }

        e.setCancelled(true);
    }
}
