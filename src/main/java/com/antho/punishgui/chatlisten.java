package com.antho.punishgui;

import me.kodysimpson.simpapi.colors.ColorTranslator;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class chatlisten implements Listener {
    private JavaPlugin pl;
    public chatlisten(JavaPlugin plug){
        this.pl = plug;
    }
    @EventHandler
    public void ochat(PlayerChatEvent e){
        PersistentDataContainer d = e.getPlayer().getPersistentDataContainer();
        if (d.has(new NamespacedKey("pg","chatevent"), PersistentDataType.INTEGER)){
            e.getPlayer().getPersistentDataContainer().remove(new NamespacedKey("pg","chatevent"));
            e.setCancelled(true);
            switch (d.get(new NamespacedKey("pg","tempwaittype"),PersistentDataType.INTEGER)){
                case 1:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1y "+  ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 2:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 3mo " + ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 3:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1mo "+  ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 4:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1w "+  ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 5:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1d "+ ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 6:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 12h "+  ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 7:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1h "+  ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 8:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 5m "+  ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
                case 9:
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tempban "+Bukkit.getPlayer(e.getMessage()).getName()+" 1m "+ ColorTranslator.translateColorCodes(Punish_gui.getconfig().getString("banReason")));
                    break;
            }
            e.getPlayer().sendMessage("banned "+Bukkit.getOfflinePlayer(e.getMessage()).getName());
            e.getPlayer().closeInventory();
            e.getPlayer().getPersistentDataContainer().remove(new NamespacedKey("pg","tempwaittype"));
        }

    }

}
