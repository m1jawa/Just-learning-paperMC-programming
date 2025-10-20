package m1jawa.paperMCLearning.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import m1jawa.paperMCLearning.PaperMCLearning;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LaterCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack source, String[] args) {
        CommandSender sender = source.getSender();
        if (sender instanceof Player player) {
            World world = player.getWorld();

            if (args[0].equals("test")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage("test");
                    }
                }.runTaskLater(PaperMCLearning.getPlugin(), 60);
            } else if (args[0].equals("cycle")) {
                new BukkitRunnable() {

                    Random random = new Random();
                    int timer = 0;

                    @Override
                    public void run() {

                        timer++;
                        player.sendMessage("cycle (every 1s)");

                        Vector vector = new Vector(random.nextFloat(-7, 7), random.nextFloat(1, 7), random.nextFloat(-7, 7));
                        player.setVelocity(vector);

                        if(timer == 10) {
                            player.sendMessage("Stop");
                            cancel();
                        }

                    }
                }.runTaskTimer(PaperMCLearning.getPlugin(), 0, 10);
            } else if (args[0].equals("particle")) {

                world.spawnParticle(Particle.FLAME, player.getLocation(), 10, 0, 0.5, 2, 0.1);

            } else if (args[0].equals("particle-line")) {

                Location location = player.getEyeLocation();

                for (int i = 0; i < 50; i++) {
                    location.add(location.getDirection());
                    world.spawnParticle(Particle.END_ROD, location, 1, 0, 0, 0, 0);

                    if (location.getBlock().isSolid()) {
                        i = 50;
                    }
                }

            }

        }

    }

    @Override
    public @Nullable List<String> suggest(CommandSourceStack source, String[] args){
        List<String> tab = new ArrayList<>();

        if (args.length == 1) {
            tab.add("test");
            tab.add("cycle");
            tab.add("particle");
            tab.add("particle-line");
        }

        return tab;
    }

}
