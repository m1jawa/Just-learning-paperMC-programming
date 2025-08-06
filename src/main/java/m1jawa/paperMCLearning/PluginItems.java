package m1jawa.paperMCLearning;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class PluginItems {
    public static ItemStack MagicWand;

    public static void init() {
        MagicWand = MagicWand();
    }

    private static ItemStack MagicWand() {
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("Magic Stick");
        meta.setLore(Collections.singletonList("While touches stone, makes gold from it."));
        meta.addEnchant(Enchantment.PUNCH, 2, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        return item;
    }
}
