package de.timp.serverprojekt.serverprojekt.commands;

import de.timp.serverprojekt.serverprojekt.ServerProjekt;
import de.timp.serverprojekt.serverprojekt.backpack.Backpack;
import de.timp.serverprojekt.serverprojekt.utils.ItemBuilder;
import de.timp.serverprojekt.serverprojekt.utils.PREFIX;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.UUID;

import static de.timp.serverprojekt.serverprojekt.ServerProjekt.getInstance;
import static org.bukkit.Bukkit.getWorld;
import static org.bukkit.Material.*;


public class inventory_cmd implements CommandExecutor, Listener {


    private UUID uuid;
    public static Inventory inventory;
    public static Inventory inventory1;
    public static Backpack backpack;

    @Override
    @Deprecated
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        inventory = Bukkit.createInventory(null, 6*9, "§c§lServerProjekt §2§lPage 1/2");
        inventory1 = Bukkit.createInventory(null, 6*9, "§c§lServerProjekt §2§lPage 2/2");


        String name = "natatos";
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD, (short) 1);
        SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
        assert skullMeta != null;
        skullMeta.setOwner(name);
        skullMeta.setDisplayName("§aNächste Seite ->");
        skullMeta.setLocalizedName("next.page");
        itemStack.setItemMeta(skullMeta);
        inventory.setItem(8, itemStack);

        String name1 = "vvvvvvvvvvvv";
        ArrayList<String> lore = new ArrayList<>();
        ItemStack itemStack1 = new ItemStack(Material.PLAYER_HEAD, (short) 1);
        SkullMeta skullMeta1 = (SkullMeta)itemStack1.getItemMeta();
        assert skullMeta1 != null;
        skullMeta1.setOwner(name1);
        skullMeta1.setDisplayName("§aPatchnotes");
        lore.add("  ");
        lore.add(getInstance().getConfig().getString("patchnotes_line_1"));
        lore.add(getInstance().getConfig().getString("patchnotes_line_2"));
        lore.add(getInstance().getConfig().getString("patchnotes_line_3"));
        lore.add(getInstance().getConfig().getString("patchnotes_line_4"));
        lore.add(getInstance().getConfig().getString("patchnotes_line_5"));
        skullMeta1.setLocalizedName("patchnotes");
        skullMeta1.setLore(lore);
        itemStack1.setItemMeta(skullMeta1);
        inventory.setItem(0, itemStack1);


        inventory.setItem(9, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(11, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(12, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(13, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(14, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(15, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(16, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(17, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(36, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(37, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(38, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(39, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(40, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(41, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(42, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(43, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory.setItem(44, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());


        inventory.setItem(22, new ItemBuilder(COMPASS).setDisplayname("§6Spawn").setLocalizedName("tp.spawn").build());
        inventory.setItem(53, new ItemBuilder(BARRIER).setDisplayname("§c❌ Schließen ❌").setLocalizedName("close.inv").build());
        inventory.setItem(45, new ItemBuilder(BUNDLE).setDisplayname("§c§lBackpack").setLocalizedName("open.backpack").build());
        inventory.setItem(46, new ItemBuilder(ENDER_CHEST).setDisplayname("§5§lEnderchest").setLocalizedName("open.enderchest").build());
        inventory.setItem(47, new ItemBuilder(CRAFTING_TABLE).setDisplayname("§6§lWorkbench").setLocalizedName("open.workbench").build());

        if(PREFIX.activate_nether) {
            inventory.setItem(21, new ItemBuilder(Material.NETHERRACK).setDisplayname("§6Nether").setLocalizedName("tp.nether").build());
        }else {
            inventory.setItem(21, new ItemBuilder(Material.BARRIER).setDisplayname("§cWurde noch nicht freigeschalten!").setLocalizedName("canceled").build());
        }

        if(PREFIX.activate_end) {
            inventory.setItem(23, new ItemBuilder(Material.END_STONE).setDisplayname("§6End").setLocalizedName("tp.end").build());
        }else {
            inventory.setItem(23, new ItemBuilder(Material.BARRIER).setDisplayname("§cWurde noch nicht freigeschalten!").setLocalizedName("canceled").build());
        }




        p.openInventory(inventory);
        p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_TRADE, 1, 1);

        return false;
    }

    @EventHandler
    @Deprecated
    public void onClick(InventoryClickEvent e) {
        String name = "saidus2";
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD, (short) 1);
        SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
        assert skullMeta != null;
        skullMeta.setOwner(name);
        skullMeta.setDisplayName("§a<- Seite zurück");
        skullMeta.setLocalizedName("back.page");
        itemStack.setItemMeta(skullMeta);
        inventory1.setItem(0, itemStack);
        inventory1.setItem(53, new ItemBuilder(BARRIER).setDisplayname("§c❌ Schließen ❌").setLocalizedName("close.inv").build());


        if(e.getCurrentItem() == null) return;
        if(e.getView().getTitle() == "§c§lServerProjekt §2§lPage 1/2") {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            backpack = ServerProjekt.getInstance().getBackpackManager().getBackpack(p.getUniqueId());

            if(e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "close.inv":
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
                        p.sendMessage(PREFIX.SERVER + "§cInventar geschlossen!");
                        break;

                    case "survival":
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu bist nun in " + p. getGameMode() + " §aMode");
                        p.closeInventory();
                        break;

                    case "creative":
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu bist nun in " + p. getGameMode() + " §aMode");
                        p.closeInventory();
                        break;

                    case "spectator":
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu bist nun in " + p. getGameMode() + " §aMode");
                        p.closeInventory();
                        break;

                    case "adventure":
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(PREFIX.GAMEMODE + "§aDu bist nun in " + p. getGameMode() + " §aMode");
                        p.closeInventory();
                        break;

                    case "tp.spawn":
                        p.teleport(new Location((getWorld("world")), 0, 100, 0));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        break;

                    case "tp.end":
                        p.teleport(new Location((getWorld("world_the_end")), 100, 49, 0));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        break;

                    case "tp.nether":
                        p.teleport(new Location((getWorld("world_nether")), 0,92,0));
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        break;

                    case "canceled":
                        p.sendMessage(PREFIX.SERVER + "§cHättest du wohl gerne :)");
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1 ,1);
                        break;

                    case "next.page":
                        if(p.isOp()) {
                            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 1 , 1);
                            p.openInventory(inventory1);
                        }else {
                            p.sendMessage(PREFIX.ERROR + "§cDazu hast du keine Rechte");
                            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                            p.closeInventory();
                        }
                        break;
                    case "cancel":
                        p.sendMessage(PREFIX.ERROR + "§cDas Item ist gerade gesperrt!");
                        p.closeInventory();
                        break;
                    case "open.backpack":
                        e.getWhoClicked().openInventory(backpack.getInventory());
                        p.sendMessage(PREFIX.BACKPACK + "§aDu hast dein Backpack geöffnet!");
                        p.playSound(p.getLocation(), Sound.ITEM_BUNDLE_INSERT, 1, 1);
                        break;
                    case "open.enderchest":
                        e.getWhoClicked().openInventory(e.getWhoClicked().getEnderChest());
                        p.sendMessage(PREFIX.EC + "§aDu hast deine Enderchest geöffnet!");
                        p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
                        break;
                    case "open.workbench":
                        e.getWhoClicked().openWorkbench(p.getLocation(), true);
                        p.sendMessage(PREFIX.WORKBENCH + "§aÖffne Crafting menu!");
                        break;
                }
            }
        }
        if(e.getWhoClicked().isOp()) {
            inventory1.setItem(28, new ItemBuilder(BUNDLE).setDisplayname("§6Du bist operator!").setLocalizedName("test").build());
        }else {
            inventory1.setItem(28, new ItemBuilder(Material.BARRIER).setDisplayname("§cWurde noch nicht freigeschalten!").setLocalizedName("canceled").build());
        }

        inventory1.setItem(9, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(10, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(11, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(12, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(13, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(14, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(15, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(16, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(17, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(36, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(37, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(38, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(39, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(40, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(41, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(42, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(43, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());
        inventory1.setItem(44, new ItemBuilder(BLACK_STAINED_GLASS_PANE).setDisplayname(" ").setLore("  ").build());





        inventory1.setItem(45, new ItemBuilder(WATER_BUCKET).setDisplayname("§b§lWATER-MLG").setLocalizedName("water.mlg").build());
    }


    @EventHandler
    public void onClick1(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;
        if(e.getView().getTitle() == "§c§lServerProjekt §2§lPage 2/2") {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);

            if(e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "back.page":
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 1 , 1);
                        ItemStack[] invcontent = inventory.getContents();
                        inventory.setContents(invcontent);
                        p.openInventory(inventory);
                        break;
                    case "water.mlg":
                        p.teleport(new Location(Bukkit.getWorld("world"), -3, 200, -32));
                        p.getInventory().addItem(new ItemStack(WATER_BUCKET));
                        break;
                    case "close.inv":
                        p.closeInventory();
                        p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
                        p.sendMessage(PREFIX.SERVER + "§cInventar geschlossen!");
                        break;
                    case "canceled":
                        p.sendMessage(PREFIX.SERVER + "§cHättest du wohl gerne :)");
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1 ,1);
                        break;
                    case "forcefield":
                        p.sendMessage(PREFIX.PLUGINS + "§a");

                        break;
                }
            }
        }
    }
}