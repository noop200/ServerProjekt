package de.timp.serverprojekt.serverprojekt.listeners;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class login_listener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        e.allow();
        Player p = e.getPlayer();
        if(getInstance().getConfig().getBoolean("wartungsmodus")) {
            if(p.isOp()) {
                p.sendMessage(PREFIX.MAINTENANCE + "§aAuf diesem Server ist der Wartungsmodus aktiv!");
                e.allow();
            }else {

                e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "§8[§6SurvivalProjekt§8]" +
                        "\n " +
                        "\n§cDer Server ist aufgrund Wartungen geschlossen!" +
                        "\n§cProbiere es später noch einmal!");
            }
        }


    }
}
