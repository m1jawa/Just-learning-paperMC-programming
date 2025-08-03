package m1jawa.paperMCLearning;

import m1jawa.paperMCLearning.commands.ColorMsgCommand;
import m1jawa.paperMCLearning.commands.RollCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class PaperMCLearning extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("roll").setExecutor(new RollCommand());
        getCommand("color-msg").setExecutor(new ColorMsgCommand());
    }
}
