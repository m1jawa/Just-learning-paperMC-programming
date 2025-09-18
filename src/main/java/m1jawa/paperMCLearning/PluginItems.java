package m1jawa.paperMCLearning;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PluginItems {
    public static ItemStack MagicWand;
    public static ItemStack CommonApple;
    public static ItemStack MobSpawn;
    public static ItemStack MobSpawn2;

    public static void init() {
        MagicWand = MagicWand();
        CommonApple = CommonApple();
        MobSpawn = MobSpawn();
        MobSpawn2 = MobSpawn2();
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

    private static ItemStack CommonApple() {
        ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        meta.setDisplayName("Common Apple");
        lore.add("Just an apple");
        lore.add("Common apple...");

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    private static ItemStack MobSpawn() {
        ItemStack item = new ItemStack(Material.BONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Summon mob");

        item.setItemMeta(meta);

        return item;
    }

    private static ItemStack MobSpawn2() {
        ItemStack item = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Summon another mob");

        item.setItemMeta(meta);

        return item;
    }
}
