package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pvp_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.isOp()) {
                if(args.length == 1) {
                    if(cmd.getName().equalsIgnoreCase("pvp")) {
                        if(args[0].equalsIgnoreCase("on")) {
                            PREFIX.pvp = false;
                            sender.sendMessage(PREFIX.PVP + "§aPlayer vs Player ist jetzt aktiviert!");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                player.sendMessage(PREFIX.SERVER + "§a§lPVP ist nun aktiviert!");
                            });
                        }else if(args[0].equalsIgnoreCase("off")) {
                            PREFIX.pvp = true;
                            sender.sendMessage(PREFIX.PVP + "§cPlayer vs Player ist nun deaktiviert!");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                player.sendMessage(PREFIX.SERVER + "§c§lPVP ist nun deaktiviert!");
                            });
                        }
                    }
                }else {
                    sender.sendMessage(PREFIX.ERROR + "§cBenutze /pvp [on/off]!");
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
        }
        return false;
    }
}
