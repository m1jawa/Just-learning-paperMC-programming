package m1jawa.paperMCLearning.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class JoinQuitListener implements Listener {
    @EventHandler
    private void JoinServer(PlayerJoinEvent e) {
        Player player = (Player) e.getPlayer();
        e.setJoinMessage(player.getName() + " joined. Welcome!");

        ItemStack item = new ItemStack(Material.APPLE, 2);
        player.getInventory().addItem(item);

    }

    @EventHandler
    private void QuitServer(PlayerQuitEvent e) {
        Player player = (Player) e.getPlayer();
        e.setQuitMessage(player.getName() + " quited. Bye(");
    }
}
