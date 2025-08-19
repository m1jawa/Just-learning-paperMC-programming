package m1jawa.paperMCLearning.commands;

import m1jawa.paperMCLearning.MenuHolder;
import m1jawa.paperMCLearning.PluginItems;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class GetItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        Player player = (Player) commandSender;

        Inventory menu = Bukkit.createInventory(new MenuHolder(0), 9, "Shop");

        menu.setItem(3, PluginItems.MagicWand);
        menu.setItem(5, PluginItems.CommonApple);

        player.openInventory(menu);

        return false;
    }
}