package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clearchat_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender.isOp()) {
            if(args.length == 0) {
                for(int i = 1; i < 100; i++) {
                    Bukkit.broadcastMessage("  ");
                }
                Bukkit.broadcastMessage(PREFIX.CHAT + "§e§lDer Chat wurde geleert!");
                p.sendMessage(PREFIX.CHAT + "§aDu hast den Chat geleert!");
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /chat [on/off]");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
        }
        return false;
    }
}
