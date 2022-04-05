package de.timp.serverprojekt.serverprojekt.listeners;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class pvp_listener implements Listener {


    @EventHandler
    public void onPVP(EntityDamageEvent e) {
        e.setCancelled(PREFIX.pvp);
    }
}

