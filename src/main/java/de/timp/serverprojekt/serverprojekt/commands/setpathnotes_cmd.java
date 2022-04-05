package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class setpathnotes_cmd implements CommandExecutor , TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            if (sender.isOp()) {
                if (cmd.getName().equalsIgnoreCase("patchnotes")) {
                    if (args[0].equalsIgnoreCase("set1")) {
                        if (args.length == 1) {
                            sender.sendMessage(PREFIX.ERROR + "§c/Benutze /setpatchnotes <set0-4> <message>!");
                            return true;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            stringBuilder.append(args[i] + " ");
                        }
                        String setpatchnotes = stringBuilder.toString();
                        setpatchnotes = ChatColor.translateAlternateColorCodes('&', setpatchnotes);
                        getInstance().getConfig().set("patchnotes_line_1", setpatchnotes);
                        getInstance().saveConfig();
                        p.sendMessage("§6Die Patchnotes(Zeile 1) lauten: §e" + setpatchnotes);

                    } else if (args[0].equalsIgnoreCase("set2")) {
                        if (args.length == 1) {
                            sender.sendMessage(PREFIX.ERROR + "§c/Benutze /setpatchnotes <message>!");
                            return true;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            stringBuilder.append(args[i] + " ");
                        }
                        String setpatchnotes = stringBuilder.toString();
                        setpatchnotes = ChatColor.translateAlternateColorCodes('&', setpatchnotes);
                        getInstance().getConfig().set("patchnotes_line_2", setpatchnotes);
                        getInstance().saveConfig();
                        p.sendMessage("§6Die Patchnotes(Zeile 2) lauten: §e" + setpatchnotes);

                    } else if (args[0].equalsIgnoreCase("set3")) {
                        if (args.length == 1) {
                            sender.sendMessage(PREFIX.ERROR + "§c/Benutze /setpatchnotes <message>!");
                            return true;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            stringBuilder.append(args[i] + " ");
                        }
                        String setpatchnotes = stringBuilder.toString();
                        setpatchnotes = ChatColor.translateAlternateColorCodes('&', setpatchnotes);
                        getInstance().getConfig().set("patchnotes_line_3", setpatchnotes);
                        getInstance().saveConfig();
                        p.sendMessage("§6Die Patchnotes(Zeile 3) lauten: §e" + setpatchnotes);

                    } else if (args[0].equalsIgnoreCase("set4")) {
                        if (args.length == 1) {
                            sender.sendMessage(PREFIX.ERROR + "§c/Benutze /setpatchnotes <message>!");
                            return true;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            stringBuilder.append(args[i] + " ");
                        }
                        String setpatchnotes = stringBuilder.toString();
                        setpatchnotes = ChatColor.translateAlternateColorCodes('&', setpatchnotes);
                        getInstance().getConfig().set("patchnotes_line_4", setpatchnotes);
                        getInstance().saveConfig();
                        p.sendMessage("§6Die Patchnotes(Zeile 4) lauten: §e" + setpatchnotes);

                    } else if (args[0].equalsIgnoreCase("set5")) {
                        if (args.length == 1) {
                            sender.sendMessage(PREFIX.ERROR + "§c/Benutze /setpatchnotes <message>!");
                            return true;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            stringBuilder.append(args[i] + " ");
                        }
                        String setpatchnotes = stringBuilder.toString();
                        setpatchnotes = ChatColor.translateAlternateColorCodes('&', setpatchnotes);
                        getInstance().getConfig().set("patchnotes_line_5", setpatchnotes);
                        getInstance().saveConfig();
                        p.sendMessage("§6Die Patchnotes(Zeile 5) lauten: §e" + setpatchnotes);

                    }
                } else {
                    sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
                }
            } else {
                sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1) {
            list.add("set1");
            list.add("set2");
            list.add("set3");
            list.add("set4");
            list.add("set5");
        }
        return list;
    }
}
