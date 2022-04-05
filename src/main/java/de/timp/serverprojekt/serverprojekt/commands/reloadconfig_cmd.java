package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.Config;
import de.timp.serverprojekt.serverprojekt.utils.LocationConfig;
import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class reloadconfig_cmd implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Config backpacks = getInstance().getConfiguration();
        LocationConfig locationConfig = getInstance().getLocationConfig();
        if (sender instanceof Player) {
            if (args.length == 1) {
                if (sender.isOp()) {
                    if (cmd.getName().equalsIgnoreCase("reloadconfig") || cmd.getName().equalsIgnoreCase("rlc")) {
                        if (args[0].equalsIgnoreCase("config.yml")) {
                            sender.sendMessage(PREFIX.CONFIG + "§aDu hast §e" + args[0] + " §aneu geladen!");
                            getInstance().reloadConfig();
                            getInstance().getConfig().set("event-started", false);
                            getInstance().saveConfig();
                        }else if(args[0].equalsIgnoreCase("backpack.yml")) {
                            sender.sendMessage(PREFIX.CONFIG + "§aDu hast §e" + args[0] + " §aneu geladen!");
                            backpacks.reload();
                        }else if(args[0].equalsIgnoreCase("locations.yml")) {
                            sender.sendMessage(PREFIX.CONFIG + "§aDu hast §e" + args[0] + " §aneu geladen!");
                            locationConfig.reload();
                        }else {
                            sender.sendMessage(PREFIX.ERROR + "§cBenutze /rlc oder /reloadconfig(/rlc) <ConfigFile>");
                            return false;
                        }

                    }
                } else {
                    sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /rlc oder /reloadconfig(/rlc) <ConfigFile>");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("config.yml");
        list.add("backpack.yml");
        list.add("locations.yml");
        return list;
    }
}
