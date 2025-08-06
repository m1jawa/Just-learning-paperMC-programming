package m1jawa.paperMCLearning;

import m1jawa.paperMCLearning.Listeners.BlockBreakingListener;
import m1jawa.paperMCLearning.Listeners.InventoryClickListener;
import m1jawa.paperMCLearning.Listeners.JoinQuitListener;
import m1jawa.paperMCLearning.Listeners.PlayerRightClickListener;
import m1jawa.paperMCLearning.commands.ColorMsgCommand;
import m1jawa.paperMCLearning.commands.GetItemCommand;
import m1jawa.paperMCLearning.commands.RollCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class PaperMCLearning extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("roll").setExecutor(new RollCommand());
        getCommand("color-msg").setExecutor(new ColorMsgCommand());
        getCommand("get-item").setExecutor(new GetItemCommand());


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinQuitListener(), this);
        pluginManager.registerEvents(new BlockBreakingListener(), this);
        pluginManager.registerEvents(new PlayerRightClickListener(), this);
        pluginManager.registerEvents((Listener) new InventoryClickListener(),
                (Plugin) this);

        PluginItems.init();
    }
}
