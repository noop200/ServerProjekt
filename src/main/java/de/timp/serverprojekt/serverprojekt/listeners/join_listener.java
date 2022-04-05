package de.timp.serverprojekt.serverprojekt.listeners;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import de.timp.serverprojekt.serverprojekt.utils.VanishManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class join_listener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        VanishManager vanishManager = getInstance().getVanishManager();
        Player p = e.getPlayer();
        String player = p.getDisplayName();

        if(p.isOp()) {
            if(vanishManager.isVanished(p)) {
                e.setJoinMessage("");
            }
            if(getInstance().getConfig().getBoolean("auto-vanish")) {
                p.sendMessage(PREFIX.VANISH + "§aDu bist nun im Auto-Vanish!");
                vanishManager.setVanished(p, true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1, true));
                e.setJoinMessage("");
            }else {
                e.setJoinMessage("§e" + p.getName() + " §ahat den Server betreten!");
                vanishManager.setVanished(p, false);
                p.removePotionEffect(PotionEffectType.INVISIBILITY);
            }
        }else {
            vanishManager.hideAll(e.getPlayer());
            e.setJoinMessage("§e" + p.getName() + " §ahat den Server betreten!");
            p.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
        p.sendMessage(PREFIX.SERVER + "§6Hallo §e" + player + "§6, willkommen auf dem SurvivalProjekt!");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

        p.teleport(new Location((Bukkit.getWorld("world")), 0, 100 ,0));
    }
}

