package m1jawa.paperMCLearning.Listeners;

import m1jawa.paperMCLearning.MenuHolder;
import m1jawa.paperMCLearning.PluginItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.spawner.SpawnerEntry;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;


public class InventoryClickListener implements Listener {
    @EventHandler
    private void PlayerClickInventory(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        World world = player.getWorld();
        ItemStack clickedItem = e.getCurrentItem();

        if (e.getInventory().getHolder() instanceof MenuHolder) {
            if (e.getClickedInventory().getHolder() instanceof Player) e.setCancelled(true);

            MenuHolder menuHolder = (MenuHolder) e.getClickedInventory().getHolder();
            if(menuHolder.GetMenuId() == 0) {
                if (e.getCurrentItem() == null) return;
                if (clickedItem.isSimilar(PluginItems.MagicWand)) {
                    player.getInventory().addItem(PluginItems.MagicWand);
                } else if (clickedItem.isSimilar(PluginItems.CommonApple)) {
                    player.getInventory().addItem(PluginItems.CommonApple);
                } else if (clickedItem.isSimilar(PluginItems.MobSpawn)) {
                    Location location = player.getEyeLocation().add(player.getLocation().getDirection().multiply(5));

                    ArmorStand armorStand = (ArmorStand) world.spawnEntity(location, EntityType.ARMOR_STAND);
                    armorStand.setItem(EquipmentSlot.FEET, new ItemStack(Material.IRON_BOOTS));
                    armorStand.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));

                    armorStand.setArms(true);
                    armorStand.setItem(EquipmentSlot.HAND, new ItemStack(PluginItems.MagicWand));

                    armorStand.setCustomName("Debiloid");
                    armorStand.setCustomNameVisible(true);

                    armorStand.setRotation(player.getLocation().getYaw() + 180, armorStand.getYaw());
                }
            }
            e.setCancelled(true);
        }
    }
}
