package m1jawa.paperMCLearning.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ColorMsgCommand implements BasicCommand {
    @Override
    public void execute(CommandSourceStack source, String[] args) {
        CommandSender sender = source.getSender();
        if (sender instanceof Player player) {
            if (args.length < 3) {
                player.sendMessage("§cYou didn't write all arguments!");
            }
            Player target = Bukkit.getPlayer(args[0]);
            String message = "";

            if (target == null) {
                player.sendMessage("§cPlayer is not online!");
            }

            if (args.length >= 3 && target != null) {
                if (args[1].equals("red")) {
                    message = "§4";
                } else if (args[1].equals("blue")) {
                    message = "§1";
                } else if (args[1].equals("green")) {
                    message = "§2";
                }

                for (int i = 2; i < args.length; i++) {
                    message += args[i] + " ";
                }

                player.sendMessage("You wrote to " + target.getName() + ": " + message);
                target.sendMessage(player.getName() + " wrote you: " + message);
            }
        }
    }

    @Override
    public @Nullable List<String> suggest(CommandSourceStack source, String[] args) {
        List<String> tab = new ArrayList<>();

        if (args.length == 1) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                tab.add(players.getName());
            }
        }

        if (args.length == 2) {
            tab.add("red");
            tab.add("blue");
            tab.add("green");
        }

        return tab;
    }
}
