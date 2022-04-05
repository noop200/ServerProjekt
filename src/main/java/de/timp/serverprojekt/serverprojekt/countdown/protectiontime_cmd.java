package de.timp.serverprojekt.serverprojekt.countdown;

import de.timp.serverprojekt.serverprojekt.ServerProjekt;
import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class protectiontime_cmd implements CommandExecutor {
    private int protection_time;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(sender.isOp()) {

            protection_time = 30;
            BossBar bossBar1 = Bukkit.createBossBar("§a§lSchutzzeit", BarColor.BLUE , BarStyle.SOLID);
            bossBar1.setVisible(true);

            BukkitRunnable runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    switch (protection_time) {
                        case 15:
                            Bukkit.broadcastMessage(PREFIX.PROTECTIONTIME + "§aIhr habt nur mehr §e" + protection_time + " §aSekunden Schutzzeit!");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 3:
                            Bukkit.broadcastMessage(PREFIX.PROTECTIONTIME + "§aIhr habt nur mehr §e" + protection_time + " §aSekunden Schutzzeit!");
                            bossBar1.setColor(BarColor.BLUE);
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 2:
                            Bukkit.broadcastMessage(PREFIX.PROTECTIONTIME + "§aIhr habt nur mehr §e" + protection_time + " §aSekunden Schutzzeit!");
                            bossBar1.setColor(BarColor.YELLOW);
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 1:
                            Bukkit.broadcastMessage(PREFIX.PROTECTIONTIME + "§aIhr habt nur mehr §e" + protection_time + " §aSekunde Schutzzeit!");
                            bossBar1.setColor(BarColor.RED);
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                    }



                    Bukkit.getOnlinePlayers().forEach(player ->  {

                        bossBar1.addPlayer(player);
                        bossBar1.setProgress(protection_time/30F);

                    });

                    //Timer run down last sec
                    if(protection_time == 0) {
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            bossBar1.removePlayer(player);
                            bossBar1.removePlayer(p);
                            PREFIX.pvp = false;
                            Location location = player.getLocation();
                            float sec = 1;
                            float amount = 1;
                            player.playSound(location, Sound.ENTITY_EVOKER_PREPARE_WOLOLO, sec , amount);


                        });
                        Bukkit.broadcastMessage(PREFIX.SERVER + "§a§l30 Sekunden Schutzzeit ist jetzt vorbei!");

                        cancel();
                        return;

                    }
                    protection_time--;
                }
            };
            p.sendMessage(PREFIX.SERVER + "§aAlle Spieler haben ab jetzt 30 Sekunden Schutzzeit!");
            runnable.runTaskTimer(ServerProjekt.getPlugin(), 0, 20);
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
        }
        return false;
    }
}