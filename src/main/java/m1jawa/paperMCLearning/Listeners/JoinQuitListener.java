package m1jawa.paperMCLearning.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {
    @EventHandler
    private void JoinServer(PlayerJoinEvent e) {
        Player player = (Player) e.getPlayer();
        e.setJoinMessage(player.getName() + " joined. Welcome!");
    }

    @EventHandler
    private void QuitServer(PlayerQuitEvent e) {
        Player player = (Player) e.getPlayer();
        e.setQuitMessage(player.getName() + " quited. Bye(");
    }
}
