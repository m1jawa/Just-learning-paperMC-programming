package m1jawa.paperMCLearning.Listeners;

import m1jawa.paperMCLearning.PluginItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerRightClickListener implements Listener {
    @EventHandler
    private void RightClick(PlayerInteractEvent e) {

        if (e.getAction().isLeftClick()) return;
        if (e.getItem() == null) return;
        if (!e.getItem().isSimilar(PluginItems.MagicWand)) return;

        Block block = e.getClickedBlock();

        if (block == null);
        if (block.getType().equals(Material.STONE)) {
            block.setType(Material.GOLD_BLOCK);
        } else return;


    }
}
