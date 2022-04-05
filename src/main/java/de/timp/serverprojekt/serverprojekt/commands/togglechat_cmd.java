package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class togglechat_cmd implements CommandExecutor , TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender.isOp()) {
            if(args.length == 1) {
                if(cmd.getName().equalsIgnoreCase("chat")) {
                       if(args[0].equalsIgnoreCase("on")) {
                           if(PREFIX.chat == true) {
                               Bukkit.broadcastMessage(PREFIX.CHAT + "§a§lDer Chat ist wieder aktiviert!");
                               PREFIX.chat = false;
                               return false;
                           }else {
                               p.sendMessage(PREFIX.ERROR + "§cDer Chat ist bereits aktiviert!");
                           }
                       }else if(args[0].equalsIgnoreCase("off")) {
                           if(PREFIX.chat == false) {
                               Bukkit.broadcastMessage(PREFIX.CHAT + "§c§lDer Chat ist nun deaktiviert!");
                               PREFIX.chat = true;
                               return false;
                           }else {
                               p.sendMessage(PREFIX.ERROR + "§cDer Chat ist bereits deaktiviert!");
                           }
                       }
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /chat [on/off]");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1) {
            list.add("on");
            list.add("off");
        }
        return list;
    }
}
