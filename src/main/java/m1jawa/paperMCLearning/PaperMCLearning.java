package m1jawa.paperMCLearning;

import io.papermc.paper.command.brigadier.BasicCommand;
import m1jawa.paperMCLearning.Listeners.BlockBreakingListener;
import m1jawa.paperMCLearning.Listeners.InventoryClickListener;
import m1jawa.paperMCLearning.Listeners.JoinQuitListener;
import m1jawa.paperMCLearning.Listeners.PlayerRightClickListener;
import m1jawa.paperMCLearning.commands.ColorMsgCommand;
import m1jawa.paperMCLearning.commands.GetItemCommand;
import m1jawa.paperMCLearning.commands.LaterCommand;
import m1jawa.paperMCLearning.commands.RollCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.print.Paper;


public final class PaperMCLearning extends JavaPlugin {

    static PaperMCLearning plugin;

    @Override
    public void onEnable() {

        plugin = this;

        BasicCommand getItemCommand = new GetItemCommand();
        BasicCommand colorMsgCommand = new ColorMsgCommand();
        BasicCommand rollCommand = new RollCommand();
        BasicCommand laterCommand = new LaterCommand();

        registerCommand("get-item", getItemCommand);
        registerCommand("color-msg", colorMsgCommand);
        registerCommand("roll", rollCommand);
        registerCommand("later", laterCommand);


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinQuitListener(), this);
        pluginManager.registerEvents(new BlockBreakingListener(), this);
        pluginManager.registerEvents(new PlayerRightClickListener(), this);
        pluginManager.registerEvents((Listener) new InventoryClickListener(),
                (Plugin) this);

        PluginItems.init();
    }

    public static PaperMCLearning getPlugin(){
        return plugin;
    }
}
