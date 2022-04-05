package de.timp.serverprojekt.serverprojekt.listeners;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chat_listener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage();
        String player = p.getDisplayName();
        if(p.isOp()) {
            message = ChatColor.translateAlternateColorCodes('&', message);
            e.setFormat("§8»" +
                    "\n§8[§4§lOwner§8] §7" + player + "§7: §a§l" + message+
                    "\n§8»");
        }else {
            if(message.equals("&a&l")) {
                p.sendMessage(PREFIX.ERROR + "§cUm diesen Prefix zu benutzen hat du keine Rechte!");
                Bukkit.getOnlinePlayers().forEach(op -> {
                    if(op.isOp()) {
                        op.sendMessage(PREFIX.CHATLOG + "§e" + e.getPlayer().getDisplayName() + " §8used » " + e.getMessage());
                    }
                });
                e.setCancelled(true);
            }else {
                message = ChatColor.translateAlternateColorCodes('&', message);
                e.setFormat("§8[§aNormies§8] §7" + player + "§7: §8" + message);
            }
        }
        if(PREFIX.chat == true) {
            if(p.isOp()) {
                message = ChatColor.translateAlternateColorCodes('&', message);
                e.setFormat("§8»" +
                        "\n§8[§4§lOwner§8] §7" + player + "§7: §a§l" + message+
                        "\n§8»");
            }else {
                e.setCancelled(PREFIX.chat);
                p.sendMessage(PREFIX.ERROR + "§cDer Chat ist gerade deaktiviert!");
            }
        }

    }
}
