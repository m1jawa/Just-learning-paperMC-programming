package m1jawa.paperMCLearning.commands;

import com.mojang.brigadier.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ColorMsgCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        Player player = (Player) commandSender;
        if (strings.length < 2) {
            player.sendMessage("§cYou didn't write all arguments!");
            return false;
        }

        Player target = Bukkit.getPlayer(strings[0]);

        if (target == null) {
            player.sendMessage("§cPlayer is not online!");
            return false;
        }

        String message = "";

        if (strings[1].equals("red")) {
            message = "§4";
        } else if (strings[1].equals("blue")) {
            message = "§1";
        } else if (strings[1].equals("green")) {
            message = "§2";
        }

        for ( int i = 2; i < strings.length; i ++) {
            message += strings[i] + " ";
        }

        player.sendMessage("You wrote to " + target.getName() + ": " + message);
        target.sendMessage(player.getName() + " wrote you: " + message);

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        List<String> tab = new ArrayList<>();

        if (strings.length == 1) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                tab.add(players.getName());
            }
        }

        if (strings.length == 2) {
            tab.add("red");
            tab.add("blue");
            tab.add("green");
        }

        return tab;
    }
}
