package m1jawa.paperMCLearning.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RollCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack source, String[] args){
        CommandSender sender = source.getSender();
        if (sender instanceof Player player) {
            Random random = new Random();
            int num = random.nextInt(1, 21);
            player.sendMessage("You got " + num);
        }
    }
}
