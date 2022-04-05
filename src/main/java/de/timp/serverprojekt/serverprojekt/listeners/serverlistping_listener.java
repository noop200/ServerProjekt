package de.timp.serverprojekt.serverprojekt.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class serverlistping_listener implements Listener {


    @EventHandler
    public void onListPing(ServerListPingEvent e) {
        if(getInstance().getConfig().getBoolean("wartungsmodus")) {
            String motd_wartung = getInstance().getConfig().getString("Server_MOTD_MAINTENANCE");
            motd_wartung = ChatColor.translateAlternateColorCodes('&', motd_wartung);
            e.setMotd(motd_wartung);
            e.setMaxPlayers(0);
        }else {
            String motd_normal = getInstance().getConfig().getString("Server_MOTD_NORMAL");
            motd_normal = ChatColor.translateAlternateColorCodes('&', motd_normal);
            e.setMotd(motd_normal);
        }
    }
}
