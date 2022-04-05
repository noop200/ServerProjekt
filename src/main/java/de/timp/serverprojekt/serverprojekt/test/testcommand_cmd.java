package de.timp.serverprojekt.serverprojekt.test;

import de.timp.serverprojekt.serverprojekt.utils.LocationConfig;
import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class testcommand_cmd implements CommandExecutor {
    @Override
    @Deprecated
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        LocationConfig locationConfig = getInstance().getLocationConfig();
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if(args.length == 0) {
                String name = args[0];
                String uuid = args[1];
                if(cmd.getName().equalsIgnoreCase("testcmd")) {
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /testcmd");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
        }
        return false;
    }
}
