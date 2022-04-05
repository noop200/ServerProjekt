package de.timp.serverprojekt.serverprojekt.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class motd_listener implements Listener {

    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        e.setMotd(getInstance().getConfig().getString("Server_MOTD_NORMAL"));

    }
}
