package de.timp.serverprojekt.serverprojekt.enderchest;

import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ec_cmd implements CommandExecutor {

    private Inventory enderchest = Bukkit.createInventory(null, 3*9, "Ender Chest");


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
            if(sender instanceof Player) {
                if(cmd.getName().equalsIgnoreCase("ec") ||cmd.getName().equalsIgnoreCase("enderchest")) {
                    if(args.length == 0) {
                        p.sendMessage(PREFIX.EC + "§aDu hast deine Enderchest geöffnet!");
                        p.openInventory(p.getEnderChest());
                        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
                    }else {
                        sender.sendMessage(PREFIX.ERROR + "§cBenutze /ec");
                    }
                }
            }else {
                sender.sendMessage(PREFIX.ERROR + "§cDu musst ein Spieler sein!");
            }
        return false;
    }
}
