package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class gamemode_cmd implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.isOp()) {
            if (args.length == 1) {
                if (sender instanceof Player) {
                    if (cmd.getName().equalsIgnoreCase("gm")) {
                        if (args[0].equalsIgnoreCase("0")) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Survival");
                        } else if (args[0].equalsIgnoreCase("1")) {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Creative");
                        } else if (args[0].equalsIgnoreCase("2")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Adventure");
                        } else if (args[0].equalsIgnoreCase("3")) {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Spectator");
                        }

                    } else if (cmd.getName().equalsIgnoreCase("gamemode")) {
                        if (args[0].equalsIgnoreCase("0")) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Survival");
                        } else if (args[0].equalsIgnoreCase("1")) {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Creative");
                        } else if (args[0].equalsIgnoreCase("2")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Adventure");
                        } else if (args[0].equalsIgnoreCase("3")) {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Spectator");
                        }

                    }
                } else {
                    sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
                }
            }  else if(args.length == 2){
                Player target = Bukkit.getPlayer(args[1]);

                if(target == null) {
                    p.sendMessage(PREFIX.ERROR + "§cDer Spieler exestiert nicht!");
                    return false;
                }
                if (cmd.getName().equalsIgnoreCase("gm")) {
                    if (args[0].equalsIgnoreCase("0")) {
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Survival");
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Survival gesetzt!");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        target.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Creative gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Creative");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Adventure gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Adventure");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Spectator gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Spectator");
                    }
                }else if (cmd.getName().equalsIgnoreCase("gamemode")) {
                    if (args[0].equalsIgnoreCase("0")) {
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Survival");
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Survival gesetzt!");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        target.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Creative gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Creative");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Adventure gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Adventure");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Spectator gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Spectator");
                    }
                }


            }else {
                sender.sendMessage(PREFIX.ERROR + "§cBenutze /gm oder gamemode [0,1,2,3]");
            }
            if(sender instanceof ConsoleCommandSender) {
                Player target = Bukkit.getPlayer(args[1]);

                if(target == null) {
                    p.sendMessage(PREFIX.ERROR + "§cDer Spieler exestiert nicht!");
                    return false;
                }
                if (cmd.getName().equalsIgnoreCase("gm")) {
                    if (args[0].equalsIgnoreCase("0")) {
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Survival");
                        sender.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Survival gesetzt!");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        target.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Creative gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Creative");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Adventure gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Adventure");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Spectator gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Spectator");
                    }
                }else if (cmd.getName().equalsIgnoreCase("gamemode")) {
                    if (args[0].equalsIgnoreCase("0")) {
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Survival");
                        sender.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Survival gesetzt!");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        target.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Creative gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Creative");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Adventure gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Adventure");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(PREFIX.GAMEMODE + "§aDu hast §e" + target.getDisplayName() +" §ain den Gamemode Spectator gesetzt!");
                        target.sendMessage(PREFIX.GAMEMODE + "§aDu bist jetzt im Gamemode Spectator");
                    }
                }
            }

        } else {
            sender.sendMessage(PREFIX.ERROR + "§cDazu hat du keine Rechte!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1) {
            list.add("0");
            list.add("1");
            list.add("2");
            list.add("3");
        }
        return list;
    }
}
