package com.antho.punishgui;

import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.MenuManager;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public final class Punish_gui extends JavaPlugin {
    private static FileConfiguration config;
    private File customConfigFile;
    private static BukkitAudiences adventure;

    @Override
    public void onEnable() {
        // Plugin startup logic
        MenuManager.setup(getServer(),this);
        adventure = BukkitAudiences.create(this);
        getCommand("credits").setExecutor(new creditscmd());
        getCommand("punish").setExecutor(new punishcmd());
        getServer().getPluginManager().registerEvents(new listeners(),this);
        getServer().getPluginManager().registerEvents(new chatlisten(this),this);
        createCustomConfig();
    }

    public static FileConfiguration getconfig() {
        return config;
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        config = new YamlConfiguration();
        try {
            config.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if(adventure != null) {
            adventure.close();
            adventure = null;
        }
    }

    class creditscmd implements CommandExecutor{
        @Override
        public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {
            Audience p = l.adv().player((Player) commandSender);
            Component c = l.mm().deserialize("<color:#00ff00><color:#00f7ff>ᴘᴜɴɪѕʜ ɢᴜɪ ʙʏ ᴅɪѕᴄᴏʀᴅ ⁄ᴀɴᴛʜᴏɴʏ₄₉₃₃\n</color></color><color:#ffe640><hover:show_text:'yep, click me'><click:open_url:'https://discord.com/users/851745927000621087'>ᴄʟɪᴄᴋ ᴍᴇ ᴛᴏ ɢᴏ ᴛᴏ ᴘʀᴏꜰɪʟᴇ</click></hover></color>");
            p.sendMessage(c);
            return true;
        }
    }

    class punishcmd implements CommandExecutor{

        @Override
        public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
            try {
                MenuManager.openMenu(mainpunish.class,(Player) commandSender);
            } catch (MenuManagerException | MenuManagerNotSetupException e) {
                getLogger().warning("unable to open gui! error: "+e.getMessage());
            }
            return true;
        }
    }

    public static class l{
        //decompiling my plugins? sure. this is for returning the libaries...
        public static BukkitAudiences adv(){
            return adventure;
        }

        public static MiniMessage mm(){
            return MiniMessage.miniMessage();
        }


    }

    public class listeners implements Listener{
        /*@EventHandler
        public void ochat(AsyncPlayerChatEvent e){
            PersistentDataContainer d = e.getPlayer().getPersistentDataContainer();
            if (d.has(new NamespacedKey("pg","chatevent"), PersistentDataType.INTEGER)){
                switch (d.get(new NamespacedKey("pg","tempwaittype"),PersistentDataType.INTEGER)){
                    case 1:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1y");
                        break;
                    case 2:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 3mo");
                        break;
                    case 3:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1mo");
                        break;
                    case 4:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1w");
                        break;
                    case 5:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1d");
                        break;
                    case 6:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 12h");
                        break;
                    case 7:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1h");
                        break;
                    case 8:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 5m");
                        break;
                    case 9:
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1m");
                        break;
                }
                e.getPlayer().sendMessage("banned :)");
                e.getPlayer().closeInventory();
            }
            e.getPlayer().getPersistentDataContainer().remove(new NamespacedKey("pg","chatwait"));
            e.getPlayer().getPersistentDataContainer().remove(new NamespacedKey("pg","tempwaittype"));
        }
         */
    }
}
