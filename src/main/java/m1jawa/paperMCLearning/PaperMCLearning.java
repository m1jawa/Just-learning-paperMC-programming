package m1jawa.paperMCLearning;

import m1jawa.paperMCLearning.Listeners.JoinQuitListener;
import m1jawa.paperMCLearning.commands.ColorMsgCommand;
import m1jawa.paperMCLearning.commands.RollCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class PaperMCLearning extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("roll").setExecutor(new RollCommand());
        getCommand("color-msg").setExecutor(new ColorMsgCommand());


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents((Listener) new JoinQuitListener(), (Plugin) this);
    }
}
