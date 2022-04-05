package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import de.timp.serverprojekt.serverprojekt.utils.VanishManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class vanish_cmd implements CommandExecutor, Listener, TabCompleter {

    @Override
    @Deprecated
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        VanishManager vanishManager = getInstance().getVanishManager();
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if(args.length == 0) {
                if (vanishManager.isVanished(p)) {
                    vanishManager.setVanished(p, false);
                    p.sendMessage(PREFIX.VANISH + "§cDein Vanish ist nun deaktiviert!");
                    p.removePotionEffect(PotionEffectType.INVISIBILITY);
                }else {
                    vanishManager.setVanished(p, true);
                    p.sendMessage(PREFIX.VANISH + "§aDein Vanish ist nun aktiviert!");
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1, true));
                }
            }else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null) {
                    p.sendMessage(PREFIX.ERROR + "§cDer Spieler ist nicht Online!");
                    return false;
                }

                if (vanishManager.isVanished(target)) {
                    vanishManager.setVanished(target, false);
                    p.sendMessage(PREFIX.VANISH + "§cDer Spieler §e" + target.getName() + " §cist nun nicht mehr im Vanish!");
                    target.sendMessage(PREFIX.VANISH + "§cDein Vanish ist nun deaktiviert!");
                    target.removePotionEffect(PotionEffectType.INVISIBILITY);
                }else {
                    vanishManager.setVanished(target, true);
                    p.sendMessage(PREFIX.VANISH + "§aDer Spieler §e" + target.getName() + " §aist nun im Vanish!");
                    target.sendMessage(PREFIX.VANISH + "§aDein Vanish ist nun aktiviert!");
                    target.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1, true));
                }

            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /vanish, /v!");
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
