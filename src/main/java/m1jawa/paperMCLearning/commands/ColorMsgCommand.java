package m1jawa.paperMCLearning.commands;

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
        if (strings.length < 1) return false;
        Player player = (Player) commandSender;
        String message = "";

        if (strings[0].equals("red")) {
            message = "§4";
        } else if (strings[0].equals("blue")) {
            message = "§1";
        } else if (strings[0].equals("green")) {
            message = "§2";
        }

        for ( int i = 1; i < strings.length; i ++) {
            message += strings[i] + " ";
        }

        player.sendMessage(message);

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        List<String> tab = new ArrayList<>();

        if (strings.length == 1) {
            tab.add("red");
            tab.add("blue");
            tab.add("green");
        }

        return tab;
    }
}
