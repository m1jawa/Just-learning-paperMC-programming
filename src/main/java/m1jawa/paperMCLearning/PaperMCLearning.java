package m1jawa.paperMCLearning;

import m1jawa.paperMCLearning.commands.RollCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperMCLearning extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("roll").setExecutor(new RollCommand());
    }
}
