package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class plugins_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if(args.length == 0) {
                p.sendMessage(PREFIX.PLUGINS + "§cHilfe zum Server findest du auf dem ServerProjekt Discord!");
            }else {
                sender.sendMessage(PREFIX.ERROR + "");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst eine Spieler sein!");
        }
        return false;
    }
}
