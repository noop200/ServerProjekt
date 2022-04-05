package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class togglevanish_cmd implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                Player p = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("togglevanish") || cmd.getName().equalsIgnoreCase("togglev")) {
                    if(getInstance().getConfig().getBoolean("auto-vanish")) {
                        if(getInstance().getConfig().getBoolean("auto-vanish") == false) {
                            p.sendMessage(PREFIX.ERROR + "§cDer Auto-Vanish ist schon deaktiviert!");
                            return false;
                        }
                        getInstance().getConfig().set("auto-vanish", false);
                        getInstance().saveConfig();
                        PREFIX.togglevanish = false;
                        p.sendMessage(PREFIX.VANISH + "§cDer Auto-Vanish wurde deaktiviert!");
                    }else {
                        if(getInstance().getConfig().getBoolean("auto-vanish") == true) {
                            p.sendMessage(PREFIX.ERROR + "§cDer Auto-Vanish ist schon aktiviert!");
                            return false;
                        }
                        getInstance().getConfig().set("auto-vanish", true);
                        getInstance().saveConfig();
                        PREFIX.togglevanish = true;
                        p.sendMessage(PREFIX.VANISH + "§aDer Auto-Vanish wurde aktiviert!");
                    }
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /togglev oder /togglevanish!");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("on");
        list.add("off");
        return list;
    }
}
