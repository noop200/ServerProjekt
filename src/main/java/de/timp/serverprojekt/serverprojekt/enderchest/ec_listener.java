package de.timp.serverprojekt.serverprojekt.enderchest;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ec_listener implements Listener {

    @EventHandler
    public void onEnderChestClick(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;
        if(e.getView().getTitle().equals("Ender Chest")) {
            Player p = (Player) e.getWhoClicked();
            if(p.isOp()) {

            }else {


                e.setCancelled(true);
            }
        }
    }
}
