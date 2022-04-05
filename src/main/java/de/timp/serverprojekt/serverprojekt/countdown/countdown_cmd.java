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

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;

public class countdown_cmd implements CommandExecutor {
    private int time;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (sender.isOp()) {
            if (getInstance().getConfig().getBoolean("event-started") == true) {
                p.sendMessage(PREFIX.ERROR + "§cDas Event hat schon gestarted!");
                return false;
            }
            time = 60;
            BossBar bossBar = Bukkit.createBossBar("§a§lEvent Start in...", BarColor.GREEN, BarStyle.SOLID);
            bossBar.setVisible(true);


            BukkitRunnable runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    switch (time) {
                        case 60:
                            Bukkit.broadcastMessage(PREFIX.SERVER + "§c§lDas Event Started in " + time + " §c§lSekunden!");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, sec, amount);
                            });
                            break;
                        case 15:
                            Bukkit.broadcastMessage(PREFIX.COUNTDOWN + "§a" + time + " §aSekunden!");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 10:
                            Bukkit.broadcastMessage(PREFIX.COUNTDOWN + "§a" + time + " §aSekunden!");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 5:
                            Bukkit.broadcastMessage(PREFIX.COUNTDOWN + "§a" + time + " §aSekunden!");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, sec, amount);
                            });
                            break;
                        case 3:
                            Bukkit.broadcastMessage(PREFIX.COUNTDOWN + "§a" + time + " §aSekunden!");
                            bossBar.setColor(BarColor.GREEN);
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, sec, amount);
                            });
                            break;
                        case 2:
                            Bukkit.broadcastMessage(PREFIX.COUNTDOWN + "§a" + time + " §aSekunden!");
                            bossBar.setColor(BarColor.YELLOW);
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, sec, amount);
                            });
                            break;
                        case 1:
                            Bukkit.broadcastMessage(PREFIX.COUNTDOWN + "§a" + time + " §aSekunde!");
                            bossBar.setColor(BarColor.RED);
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_PLING, sec, amount);
                            });
                            break;
                    }


                    Bukkit.getOnlinePlayers().forEach(player -> {

                        bossBar.addPlayer(player);
                        bossBar.setProgress(time / 60F);

                        player.setLevel(time);
                        player.setExp(time / 60F);

                    });

                    //Timer run down last sec
                    if (time == 0) {
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            bossBar.removePlayer(player);
                            bossBar.removePlayer(p);
                            player.setHealth(20);
                            player.setFoodLevel(20);
                            player.setExp(0);
                            player.setLevel(0);
                            PREFIX.pvp = false;
                            Location location = player.getLocation();
                            float sec = 1;
                            float amount = 1;
                            player.playSound(location, Sound.ENTITY_ENDER_DRAGON_GROWL, sec, amount);
                            if(player.isOp()) {

                            }else {
                                player.teleport(new Location((Bukkit.getWorld("world")), 0, 100, 0));
                            }
                            getInstance().getConfig().set("event-started", true);
                            getInstance().saveConfig();
                        });
                        Bukkit.broadcastMessage(PREFIX.SERVER + "§c§lDas Event beginnt");
                        Bukkit.broadcastMessage(PREFIX.SERVER + "§a§lVon nun an habt ihr 30 Sekunden Schutzzeit!");
                        PREFIX.pvp = true;

                        cancel();
                        return;


                    }
                    time--;
                }
            };
            sender.sendMessage(PREFIX.COUNTDOWN + "§aDas Event started in kürze...");
            runnable.runTaskTimer(ServerProjekt.getPlugin(), 40, 20);
        } else {
            sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
        }
        return false;
    }
}
