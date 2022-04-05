package de.timp.serverprojekt.serverprojekt.utils;

import de.timp.serverprojekt.serverprojekt.ServerProjekt;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class VanishManager {

    private final Plugin  plugin;
    private final List<Player> vanished;

    public VanishManager(Plugin plugin) {
        this.plugin = plugin;
        this.vanished = new ArrayList<>();
    }

    public List<Player> getVanished() {
        return vanished;
    }

    public boolean isVanished(Player p) {
        return  vanished.contains(p);
    }

    public void setVanished(Player p, boolean bool) {
        if(bool) {
            vanished.add(p);
        } else {
            vanished.remove(p);
        }

        for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if(p.equals(onlinePlayer)) continue;
            if(bool) {
                onlinePlayer.hidePlayer(plugin, p);
            }else {
                onlinePlayer.showPlayer(plugin, p);
            }
        }
    }

    public void hideAll(Player p) {
        vanished.forEach(player1 ->  p.hidePlayer(plugin, player1));
    }
}
