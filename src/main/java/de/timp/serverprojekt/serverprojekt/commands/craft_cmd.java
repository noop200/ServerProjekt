package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class craft_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(args.length == 0) {
                if(sender instanceof Player) {
                    Player p = (Player) sender;
                    p.openWorkbench(p.getLocation(), true);
                    p.sendMessage(PREFIX.WORKBENCH + "§aÖffne Crafting menu!");


                }else {
                    sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /test");
            }
        return false;
    }
}
