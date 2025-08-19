package m1jawa.paperMCLearning;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class MenuHolder implements InventoryHolder {
    int menuId;

    public MenuHolder(int menuId) {
        this.menuId = menuId;
    }

    public int GetMenuId() {
        return menuId;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return null;
    }
}
