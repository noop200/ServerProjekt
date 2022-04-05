package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class head_cmd implements CommandExecutor {
    @Override
    @Deprecated
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player) {
                if(args.length == 0) {
                    if(p.getItemInHand().getItemMeta() == null) {
                        p.sendMessage(PREFIX.ERROR + "§cDu musst ein Item in der Hand halten!");
                        return false;
                    }
                    p.getInventory().setHelmet(p.getItemInHand());
                        p.getInventory().remove(p.getItemInHand());
                        p.sendMessage(PREFIX.HEAD + "§aDu hast nun einen neuen Kopf!");
                }else {
                   sender.sendMessage(PREFIX.ERROR + "§cBenutze /head");
                }
        }else {
         sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
        }
        return false;
    }
}
