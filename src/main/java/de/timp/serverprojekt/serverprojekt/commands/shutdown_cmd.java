package de.timp.serverprojekt.serverprojekt.commands;

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

public class shutdown_cmd implements CommandExecutor {

    private int shutdown;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(sender.isOp()) {
            shutdown = 60;
            BossBar bossBar1 = Bukkit.createBossBar("§4Server wird heruntergefahren...", BarColor.RED , BarStyle.SOLID);
            Bukkit.broadcastMessage(PREFIX.SHUTDOWN + "§c§lServer wird in 1 Minute neugestarted!");
            bossBar1.setVisible(true);

            BukkitRunnable runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    switch (shutdown) {
                        case 30:
                            Bukkit.broadcastMessage("§8»" +
                                    "\n§4§lIhr habt nur mehr §e§l" + shutdown + " §4§lSekunden!" +
                                    "\n§8»");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BANJO, sec, amount);
                            });
                            break;
                        case 15:
                            Bukkit.broadcastMessage("§8»" +
                                    "\n§4§lIhr habt nur mehr §e§l" + shutdown + " §4§lSekunden!" +
                                    "\n§8»");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 5:
                            Bukkit.broadcastMessage("§8»" +
                                    "\n§4§lIhr habt nur mehr §e§l" + shutdown + " §4§lSekunden!" +
                                    "\n§8»");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if(player.isOp()) {
                                }else {
                                    player.closeInventory();
                                }
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 3:
                            Bukkit.broadcastMessage("§8»" +
                                    "\n§4§lIhr habt nur mehr §e§l" + shutdown + " §4§lSekunden!" +
                                    "\n§8»");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                if(player.isOp()) {
                                }else {
                                    player.closeInventory();
                                }
                                if(player.isOp()) {
                                    player.sendMessage(PREFIX.SERVER + "§aAlle normalen Spieler werden vom Server geworfen!");
                                }else {
                                    player.kickPlayer(PREFIX.SHUTDOWN + "§4§lDer Server wird neugestarted!");
                                }
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 2:
                            Bukkit.broadcastMessage("§8»" +
                                    "\n§4§lIhr habt nur mehr §e§l" + shutdown + " §4§lSekunden!" +
                                    "\n§8»");
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                Location location = player.getLocation();
                                float sec = 1;
                                float amount = 1;
                                player.playSound(location, Sound.BLOCK_NOTE_BLOCK_BASS, sec, amount);
                            });
                            break;
                        case 1:
                            Bukkit.broadcastMessage("§8»" +
                                    "\n§4§lIhr habt nur mehr §e§l" + shutdown + " §4§lSekunde!" +
                                    "\n§8»");
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
                        bossBar1.setProgress(shutdown/60F);

                    });

                    //Timer run down last sec
                    if(shutdown == 0) {
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            bossBar1.removePlayer(player);
                            bossBar1.removePlayer(p);
                            Bukkit.getServer().shutdown();
                            player.kickPlayer(PREFIX.SHUTDOWN + "§4§lDer Server wird neugestarted!");
                        });

                        cancel();
                        return;

                    }
                    shutdown--;
                }
            };
            p.sendMessage(PREFIX.SERVER + "§aServer wird gleich neugestarted!");
            runnable.runTaskTimer(ServerProjekt.getPlugin(), 40, 20);
        }else {
            sender.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte!");
        }
        return false;
    }
}
