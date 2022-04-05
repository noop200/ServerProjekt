package de.timp.serverprojekt.serverprojekt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class bed_listener implements Listener {

    @EventHandler
    public void BedEnter(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        String pname = p.getDisplayName();
        p.sendMessage("§8Gute Nacht zZZ");
        Bukkit.broadcastMessage("§8" + pname + " §8liegt jetzt im Bett!");
    }
}
