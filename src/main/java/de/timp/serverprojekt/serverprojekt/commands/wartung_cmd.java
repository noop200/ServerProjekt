package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class wartung_cmd implements CommandExecutor, Listener, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            if (p.isOp() || p.hasPermission("serverprojekt.wartung")) {
                if (cmd.getName().equalsIgnoreCase("wartung")) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("on")) {
                            PREFIX.wartung = true;
                            getInstance().getConfig().set("wartungsmodus", true);
                            getInstance().saveConfig();

                            p.sendMessage(PREFIX.MAINTENANCE + "§aDer Wartungsmodus wurde aktiviert!");

                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if (player.isOp()) {
                                    //nothin
                                } else {
                                    player.kickPlayer("§8[§6Wartung§8]" +
                                            "\n " +
                                            "\n §cDer Server ist ab jetzt im Wartungsmodus!");
                                }
                            });

                        }else if (args[0].equalsIgnoreCase("off")) {
                            PREFIX.wartung = false;
                            getInstance().getConfig().set("wartungsmodus", false);
                            getInstance().saveConfig();

                            p.sendMessage(PREFIX.MAINTENANCE + "§cDer Wartungsmodus ist nun deaktiviert!");
                        }
                    } else {
                        sender.sendMessage(PREFIX.ERROR + "§cBenutze /wartung [on/off]");
                    }
                } else {
                    sender.sendMessage(PREFIX.ERROR + "§cBenutze /wartung [on/off]");
                }
            } else {
                sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
            }
        } else {
            sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
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