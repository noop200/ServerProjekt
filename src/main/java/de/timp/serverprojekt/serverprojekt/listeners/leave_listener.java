package de.timp.serverprojekt.serverprojekt.listeners;

import de.timp.serverprojekt.serverprojekt.ServerProjekt;
import de.timp.serverprojekt.serverprojekt.utils.VanishManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class leave_listener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        VanishManager vanishManager = ServerProjekt.getInstance().getVanishManager();

        if(p.isOp()) {
            if(vanishManager.isVanished(p)) {
                e.setQuitMessage("");
            }else {
                e.setQuitMessage("§e" + p.getName() + " §chat den Server verlassen!");
            }
        }else {
            e.setQuitMessage("§e" + p.getName() + " §chat den Server verlassen!");
        }
    }
}
