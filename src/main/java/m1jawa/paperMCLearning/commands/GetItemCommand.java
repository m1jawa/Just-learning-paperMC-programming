package m1jawa.paperMCLearning.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import m1jawa.paperMCLearning.MenuHolder;
import m1jawa.paperMCLearning.PluginItems;
import org.bukkit.Bukkit;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class GetItemCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack source, String[] args) {

        CommandSender sender = source.getSender();
        if (sender instanceof Player player)
        {
            Inventory menu = Bukkit.createInventory(new MenuHolder(0), 9, "Shop");

            menu.setItem(1, PluginItems.MobSpawn);
            menu.setItem(3, PluginItems.MagicWand);
            menu.setItem(5, PluginItems.CommonApple);
            menu.setItem(7, PluginItems.MobSpawn2);

            player.openInventory(menu);
        }
    }
}