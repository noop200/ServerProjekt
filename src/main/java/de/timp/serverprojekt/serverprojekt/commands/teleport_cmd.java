package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class teleport_cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            if(sender.isOp()) {
                if(cmd.getName().equalsIgnoreCase("tp") || cmd.getName().equalsIgnoreCase("teleport") || cmd.getName().equalsIgnoreCase("tpo")) {
                    Player p = (Player) sender;
                    if(args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target == null) {
                            p.sendMessage(PREFIX.ERROR + "§cDer Spieler §e" + args[0] + " §cist nicht Online!");
                            return false;
                        }
                        p.sendMessage(PREFIX.TELEPORT + "§aDu hast dich erfolgreich zu §e" + target.getDisplayName() + " §ateleportiert!");
                        p.teleport(target.getLocation());
                    }else if(args.length == 2){
                        Player target = Bukkit.getPlayer(args[0]);
                        Player target1 = Bukkit.getPlayer(args[1]);
                        if(target == null) {
                            p.sendMessage(PREFIX.ERROR + "§cDer Spieler §e" + args[0] + " §cist nicht Online!");
                            return false;
                        }
                        if(target1 == null) {
                            p.sendMessage(PREFIX.ERROR + "§cDer Spieler §e" + args[1] + " §cist nicht Online!");
                            return false;
                        }
                        p.sendMessage(PREFIX.TELEPORT + "§aDu hast erfolgreich §e" + target.getDisplayName() + " §azu §e" + target1.getDisplayName() + " §ateleportiert!");
                        target.sendMessage(PREFIX.TELEPORT + "§aDu wurdest zu §e" + target1.getDisplayName() + " §ateleportiert!");
                        target.teleport(target1.getLocation());
                    }else if(args.length == 3) {
                        double x = Double.parseDouble(args[0]);
                        double y = Double.parseDouble(args[1]);
                        double z = Double.parseDouble(args[2]);
                        p.sendMessage(PREFIX.TELEPORT + "§aDu hast dich erfolgreich zu den Koordinaten: §e" + x + ", §e" + y + ", §e" + z + " §atelportiert!");
                        p.teleport(new Location(Bukkit.getWorld("world"), x, y ,z));

                    }else if(args.length == 4) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target == null) {
                            p.sendMessage(PREFIX.ERROR + "§cDer Spieler §e" + args[0] + " §cist nicht Online!");
                            return false;
                        }
                        double x = Double.parseDouble(args[1]);
                        double y = Double.parseDouble(args[2]);
                        double z = Double.parseDouble(args[3]);
                        target.sendMessage(PREFIX.TELEPORT + "§aDu wurdest zu den Koordinaten: §e" + x + ", §e" + y + ", §e" + z + " §atelportiert!");
                        p.sendMessage(PREFIX.TELEPORT + "§aDu hast den Spieler §e" + target.getDisplayName() + " §aerfolgreich zu den Koordinaten: §e" + x + ", §e" + y + ", §e" + z + " §ateleportiert!");
                        target.teleport(new Location(Bukkit.getWorld("world"), x, y ,z));
                    }else {
                        p.sendMessage(PREFIX.ERROR + "§cBenutze /tp [Player], /tp [Player] [Player], /tp [x] [y] [z], /tp [Player] [x], [y] [z]!");
                        return false;
                    }
                    return true;
                }else if(cmd.getName().equalsIgnoreCase("tpall")){
                    if(args.length == 0) {
                        Player p = (Player)sender;
                        int onlineplayers = Bukkit.getOnlinePlayers().size();
                        if(Bukkit.getOnlinePlayers().size() == 1) {
                            p.sendMessage(PREFIX.ERROR + "§cEs sind nicht genug Spieler Online!");
                            return false;
                        }else if(Bukkit.getOnlinePlayers().size() > 1){
                            int numplayers = 0;
                            for(Player player: Bukkit.getOnlinePlayers()) {
                                numplayers++;
                                player.teleport(p.getLocation());
                                if(player == sender) {

                                }else {
                                    player.sendMessage(PREFIX.TELEPORT + "§aDu wurdest zu §e" + p.getDisplayName() + " §ateleportiert!");
                                }
                            }
                            p.sendMessage(PREFIX.TELEPORT + "§aDu hast alle §e" + (numplayers - 1) +" §aSpieler zu dir Telportiert!");
                        }

                    }else {
                        sender.sendMessage(PREFIX.ERROR + "§cBenutze /tpall!");
                        return false;
                    }
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
                return false;
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
        }
        return false;
    }
}
