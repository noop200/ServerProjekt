package de.timp.serverprojekt.serverprojekt.listeners;

import de.timp.serverprojekt.serverprojekt.utils.LocationConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class move_listener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
       LocationConfig locationConfig = getInstance().getLocationConfig();
        Player p = e.getPlayer();
        locationConfig.getConfig().createSection("Spieler: " + p.getDisplayName() + " | " + "UUID: " + p.getUniqueId());
        locationConfig.getConfig().set("Spieler: " + p.getDisplayName() + " | " + "UUID: " + p.getUniqueId(), "Standort: " + p.getLocation());
        locationConfig.save();

        if(getInstance().getConfig().getBoolean("wartungsmodus")) {
            if(p.isOp()) {

            }else {
                p.kickPlayer("§8[§6SurvivalProjekt§8]" +
                        "\n " +
                        "\n§cDer Server ist aufgrund Wartungen geschlossen!" +
                        "\n§cProbiere es später noch einmal!");
            }
        }

    }
}
