package de.timp.serverprojekt.serverprojekt.backpack;

import de.timp.serverprojekt.serverprojekt.utils.Base64;
import de.timp.serverprojekt.serverprojekt.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.UUID;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class Backpack<itemStack> {

    private final UUID uuid;
    private final Inventory inventory;
    Config config = getInstance().getConfiguration();
    int size = 5*9;
    ItemStack[] itemStacks = new ItemStack[0];

    public Backpack(UUID uuid) {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, size, "§c§lBackpack");
    }

    public Backpack(UUID uuid, String base64) throws IOException {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, size, "§c§lBackpack");
        this.inventory.setContents(Base64.itemStackArrayFromBase64(base64));
    }

    public UUID getUuid() {
        return uuid;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void reset() {
        this.getInventory().setContents(itemStacks);
        config.save();
    }

    public String toBase64() {
        return Base64.itemStackArrayToBase64(inventory.getContents());
    }
}
