package de.timp.serverprojekt.serverprojekt;

import de.timp.serverprojekt.serverprojekt.commands.backpack_cmd;
import de.timp.serverprojekt.serverprojekt.utils.*;
import de.timp.serverprojekt.serverprojekt.commands.*;
import de.timp.serverprojekt.serverprojekt.countdown.countdown_cmd;
import de.timp.serverprojekt.serverprojekt.countdown.protectiontime_cmd;
import de.timp.serverprojekt.serverprojekt.enderchest.ec_cmd;
import de.timp.serverprojekt.serverprojekt.listeners.*;
import de.timp.serverprojekt.serverprojekt.test.testcommand_cmd;
import de.timp.serverprojekt.serverprojekt.test.testsound_cmd;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ServerProjekt extends JavaPlugin implements Listener {

    private static ServerProjekt plugin;
    public static Object getInstance;
    private static ServerProjekt instance;
    private VanishManager vanishManager;
    private BackPackManager backPackManager;
    private Config config;
    private LocationConfig locationConfig;
    public void onLoad() {
        instance = this;
        config = new Config();
        locationConfig = new LocationConfig();
    }


    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX.SERVER + "§aDas Plugin wurde erfolgreich geladen!");
        plugin = this;
        instance = this;
        this.vanishManager = new VanishManager( this);
        saveDefaultConfig();



        //Registering Recipes
        Bukkit.addRecipe(COBWEB());
        Bukkit.addRecipe(OP_GAP());
        Bukkit.addRecipe(NETHERITE_INGOT());

        //Command register
        getCommand("countdown").setExecutor(new countdown_cmd());
        getCommand("event-start").setExecutor(new countdown_cmd());
        getCommand("protectiontime").setExecutor(new protectiontime_cmd());

        getCommand("gui").setExecutor(new inventory_cmd());
        getCommand("settings").setExecutor(new inventory_cmd());
        getCommand("spawn").setExecutor(new spawn_cmd());
        getCommand("craft").setExecutor(new craft_cmd());
        getCommand("wartung").setExecutor(new wartung_cmd());
        getCommand("rlc").setExecutor(new reloadconfig_cmd());
        getCommand("reloadconfig").setExecutor(new reloadconfig_cmd());
        getCommand("activate").setExecutor(new activate_world_cmd());
        getCommand("deactivate").setExecutor(new deactivate_worlds_cmd());
        getCommand("patchnotes").setExecutor(new setpathnotes_cmd());
        getCommand("gm").setExecutor(new gamemode_cmd());
        getCommand("gamemode").setExecutor(new gamemode_cmd());
        getCommand("pvp").setExecutor(new pvp_cmd());
        getCommand("testsound").setExecutor(new testsound_cmd());
        getCommand("heal").setExecutor(new heal_cmd());
        getCommand("shutdown").setExecutor(new shutdown_cmd());
        getCommand("fly").setExecutor(new fly_cmd());
        getCommand("head").setExecutor(new head_cmd());
        getCommand("testcmd").setExecutor(new testcommand_cmd());
        getCommand("chat").setExecutor(new togglechat_cmd());
        getCommand("clearchat").setExecutor(new clearchat_cmd());
        getCommand("ec").setExecutor(new ec_cmd());
        getCommand("enderchest").setExecutor(new ec_cmd());
        getCommand("v").setExecutor(new vanish_cmd());
        getCommand("vanish").setExecutor(new vanish_cmd());
        getCommand("togglevanish").setExecutor(new togglevanish_cmd());
        getCommand("togglev").setExecutor(new togglevanish_cmd());
        getCommand("backpack").setExecutor(new backpack_cmd());

        //Teleport Command
        getCommand("tp").setExecutor(new teleport_cmd());
        getCommand("teleport").setExecutor(new teleport_cmd());
        getCommand("tpo").setExecutor(new teleport_cmd());
        getCommand("tpall").setExecutor(new teleport_cmd());


        //BlockedCommands
        getCommand("pl").setExecutor(new plugins_cmd());
        getCommand("plugins").setExecutor(new plugins_cmd());
        getCommand("help").setExecutor(new plugins_cmd());


        //Listener register
        PluginManager plm = Bukkit.getPluginManager();
        plm.registerEvents(this , this);
        plm.registerEvents(new chat_listener(), this);
        plm.registerEvents(new inventory_cmd(), this);
        plm.registerEvents(new pvp_listener(), this);
        plm.registerEvents(new motd_listener(), this);
        plm.registerEvents(new bed_listener(), this);
        //plm.registerEvents(new ec_listener(), this);
        plm.registerEvents(new serverlistping_listener(), this);
        plm.registerEvents(new join_listener(), this);
        plm.registerEvents(new leave_listener(), this);
        plm.registerEvents(new login_listener(), this);
        plm.registerEvents(new move_listener() ,this);


        backPackManager = new BackPackManager();
    }



    public static ServerProjekt getInstance() {
        return instance;
    }

    public VanishManager getVanishManager() {
        return vanishManager;
    }


    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX.SERVER + "§cDas Plugin ist nun deaktiviert!");
        backPackManager.save();

        config.save();
        locationConfig.save();

    }

    public Config getConfiguration() {
        return config;
    }

    public LocationConfig getLocationConfig() {
        return locationConfig;
    }

    public BackPackManager getBackpackManager() {
        return backPackManager;
    }

    public ShapedRecipe COBWEB() {
        ItemStack item = new ItemStack(Material.COBWEB);
        NamespacedKey key = new NamespacedKey((Plugin) this, "cobweb");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("SSS", "SSS", "SSS");
        recipe.setIngredient('S', Material.STRING);


        return recipe;
    }

    public ShapedRecipe OP_GAP() {
        ItemStack item = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta itemMeta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("  ");
        lore.add("§cWurde bei Hand gecrafted!");
        item.setItemMeta(itemMeta);
        NamespacedKey key = new NamespacedKey((Plugin) this, "enchated_golden_apple");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("NGN", "GAG", "NGN");
        recipe.setIngredient('A', Material.GOLDEN_APPLE);
        recipe.setIngredient('N', Material.NETHERITE_SCRAP);
        recipe.setIngredient('G', Material.GOLD_BLOCK);

        return recipe;
    }

    public ShapedRecipe NETHERITE_INGOT() {
        ItemStack item = new ItemStack(Material.NETHERITE_INGOT);
        NamespacedKey key = new NamespacedKey((Plugin) this, "netherite_ingot");

        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("NNN", "N  ", "   ");
        recipe.setIngredient('N', Material.NETHERITE_SCRAP);


        return recipe;
    }
}
