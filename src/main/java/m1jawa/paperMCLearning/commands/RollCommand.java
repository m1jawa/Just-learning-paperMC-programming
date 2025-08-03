package m1jawa.paperMCLearning.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RollCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        Random random = new Random();
        int num = random.nextInt(1, 21);
        player.sendMessage("You got " + num);
        return false;
    }
}
