package de.timp.serverprojekt.serverprojekt.test;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class testsound_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender.isOp()) {
            if(args.length == 0) {
                p.playSound(p.getLocation(), Sound.ENTITY_EVOKER_PREPARE_WOLOLO, 1 , 1);
            }else {
                return false;
            }
        }else {
            return false;
        }

        return false;
    }
}
