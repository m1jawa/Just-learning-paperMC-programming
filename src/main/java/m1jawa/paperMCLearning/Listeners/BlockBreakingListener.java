package m1jawa.paperMCLearning.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakingListener implements Listener {
    @EventHandler
    private void BlockBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType().equals(Material.OAK_WOOD)) {
            player.sendMessage("Я ЗАПРЕЩАЮ ВАМ ломать блоки Деревом.");
            e.setCancelled(true);
        }

    }
}
