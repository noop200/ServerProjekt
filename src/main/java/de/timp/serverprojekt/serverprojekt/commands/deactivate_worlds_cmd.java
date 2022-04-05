package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class deactivate_worlds_cmd implements CommandExecutor , TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.isOp()) {
                if(args.length == 1) {
                    if(cmd.getName().equalsIgnoreCase("deactivate")) {
                        if(args[0].equalsIgnoreCase("nether")) {
                            Player p = (Player) sender;
                            p.sendMessage(PREFIX.NETHER + "§cDu hast den Nether für alle Spieler gesperrt!");
                            PREFIX.activate_nether = false;
                        }else if(args[0].equalsIgnoreCase("end")) {
                            Player p = (Player) sender;
                            p.sendMessage(PREFIX.END + "§cDu hast das End für alle Spieler gesperrt!");
                            PREFIX.activate_end = false;
                        }
                    }
                }else {
                    sender.sendMessage(PREFIX.ERROR + "§cBenutze /deactivate [nether/end]");
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1) {
            list.add("nether");
            list.add("end");
        }
        return list;
    }
}
