package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class heal_cmd implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if(sender.isOp()) {
                if(cmd.getName().equalsIgnoreCase("heal")) {
                    if(args.length == 0) {
                        p.sendMessage(PREFIX.HEAL + "§aDu hast dich geheilt!");
                        for (PotionEffect effect : p.getActivePotionEffects())
                            p.removePotionEffect(effect.getType());
                        p.setHealth(20);
                        p.setFoodLevel(20);

                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(args[0].equalsIgnoreCase("*")) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                player.sendMessage(PREFIX.HEAL + "§aDu wurdest geheilt!");
                                for (PotionEffect effect : player.getActivePotionEffects())
                                    player.removePotionEffect(effect.getType());
                                player.setHealth(20);
                                player.setFoodLevel(20);
                                p.sendMessage(PREFIX.HEAL + "§aDu hast §e" + player.getName() + " §aerfolgreich geheilt!");
                            });
                            return false;
                        }
                        if(target == null) {
                            p.sendMessage(PREFIX.ERROR + "§cDer Spieler ist nicht Online!");
                            return false;
                        }
                        String targetname = target.getName();
                        target.sendMessage(PREFIX.HEAL + "§aDu wurdest geheilt");
                        p.sendMessage(PREFIX.HEAL + "§aDu hast §e" + targetname + " §aerfolgreich geheilt!");
                        for (PotionEffect effect : target.getActivePotionEffects())
                            target.removePotionEffect(effect.getType());
                        target.setHealth(20);
                        target.setFoodLevel(20);

                    }else {
                        p.sendMessage(PREFIX.ERROR + "§cBenutze /heal <Player>!");
                    }
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "Dazu hast du keine Rechte!");
            }
        }else {
            sender.sendMessage(PREFIX.ERROR + "Du musst ein Spieler sein!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1) {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    String name = player.getDisplayName();
                    list.add(name);
                });
                list.add("*");
        }
        return list;
    }
}
