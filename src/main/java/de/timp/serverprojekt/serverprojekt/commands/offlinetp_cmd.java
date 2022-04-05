package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class offlinetp_cmd implements CommandExecutor, TabCompleter {
    @Override
    @Deprecated
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("otp") || cmd.getName().equalsIgnoreCase("offlinetp")) {
                if(args.length == 1) {
                    Player offlinetarget = (Player) Bukkit.getOfflinePlayer(args[0]);


                }else {
                    sender.sendMessage(PREFIX.ERROR + "§cBenutze /offlinetp(/otp) [Spieler]");
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /offlinetp(/otp) [Spieler]");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
