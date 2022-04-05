package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.ServerProjekt;
import de.timp.serverprojekt.serverprojekt.backpack.Backpack;
import de.timp.serverprojekt.serverprojekt.utils.Config;
import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class backpack_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Config config = getInstance().getConfiguration();
        if(!(sender instanceof Player)) {
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("bp") || cmd.getName().equalsIgnoreCase("backpack")) {
            Player player = (Player) sender;
            if(args.length == 0) {
                Backpack backpack = ServerProjekt.getInstance().getBackpackManager().getBackpack(player.getUniqueId());


                player.openInventory(backpack.getInventory());
                player.sendMessage(PREFIX.BACKPACK + "§aDu hast dein Backpack geöffnet!");
                return true;
            }else if(args.length == 1) {

                if(!player.isOp()) {
                    Backpack backpack = ServerProjekt.getInstance().getBackpackManager().getBackpack(player.getUniqueId());
                    player.openInventory(backpack.getInventory());
                    player.sendMessage(PREFIX.ERROR + "§cDu kannst nicht in andere Backpacks gucken!");
                    return false;
                }
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null) {
                    if(args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("resetall")) {
                        return true;
                    }
                    player.sendMessage(PREFIX.ERROR + "§cDer Spieler §e" + args[0] + " §cist nicht Online!");
                    return false;
                }
                Backpack backpack12 = ServerProjekt.getInstance().getBackpackManager().getBackpack(target.getUniqueId());
                player.openInventory(backpack12.getInventory());
                player.sendMessage(PREFIX.BACKPACK + "§aDu hast das Backpack von §e" + target.getDisplayName() + " §ageöffnet!");
                return true;

            }else if(args.length == 2) {
                if(args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("resetall")) {
                    player.sendMessage(PREFIX.INFO + "§aBist du dir sicher §cALLE §aBackpacks zurückzusetzten?" +
                            "\n" + PREFIX.INFO + "§aWenn ja. §eBenutze /bp(/backpack) reset confirm");
                    if(args[1].equalsIgnoreCase("confirm")) {
                        player.sendMessage(PREFIX.BACKPACK);
                    }
                }

            }else {
                player.sendMessage(PREFIX.ERROR + "§cBenutze /bp (/backpack) [Player]");
            }
        }
        return false;
    }
}