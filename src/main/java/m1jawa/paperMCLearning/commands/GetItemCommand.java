package m1jawa.paperMCLearning.commands;

import m1jawa.paperMCLearning.PluginItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        Player player = (Player) commandSender;

        player.getInventory().addItem(PluginItems.MagicWand);
        player.getInventory().addItem(PluginItems.CommonApple);

        return false;
    }
}