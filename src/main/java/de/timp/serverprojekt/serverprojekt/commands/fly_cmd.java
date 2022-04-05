package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly_cmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if(sender.isOp()) {
                if(args.length == 0) {
                    if(cmd.getName().equalsIgnoreCase("fly")) {
                        if(p.isFlying()) {
                            p.sendMessage(PREFIX.FLY + "§cDein Flugmodus wurde deaktiviert!");
                            p.setFlying(true);
                            p.setAllowFlight(false);
                            return false;
                        }else {
                            p.sendMessage(PREFIX.FLY + "§aDein Flugmodus wurde aktiviert!");
                            p.setAllowFlight(true);
                            return false;
                        }
                    }
                }else if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target == null) {
                        p.sendMessage(PREFIX.ERROR + "§cDer Spieler exestiert nicht!");
                    }
                    if(target.isFlying()) {
                        p.sendMessage(PREFIX.FLY + "§cDu hast den Flugmodus von §e" + target.getDisplayName() + " §cdeaktiviert!");
                        target.sendMessage(PREFIX.FLY + "§cDein Flugmodus wurde deaktiviert!");
                        target.setFlying(false);
                        target.setAllowFlight(false);
                    }else {
                        p.sendMessage(PREFIX.FLY + "§aDu hast den Flugmodus von §e" + target.getDisplayName() + " §aaktiviert!");
                        target.sendMessage(PREFIX.FLY + "§aDein Flugmodus wurde aktiviert!");
                        target.setAllowFlight(true);
                    }
                }else {
                    sender.sendMessage(PREFIX.ERROR + "§cBenutze /fly [Player]");
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
