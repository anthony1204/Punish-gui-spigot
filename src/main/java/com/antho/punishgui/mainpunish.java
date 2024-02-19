package com.antho.punishgui;

import me.kodysimpson.simpapi.exceptions.MenuManagerException;
import me.kodysimpson.simpapi.exceptions.MenuManagerNotSetupException;
import me.kodysimpson.simpapi.menu.Menu;
import me.kodysimpson.simpapi.menu.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;


public class mainpunish extends Menu {
    public mainpunish(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Punishment Menu";
    }

    @Override
    public int getSlots() {
        return 9;
    }

    @Override
    public boolean cancelAllClicks() {
        return true;
    }

    @Override
    public void handleMenu(InventoryClickEvent inventoryClickEvent) throws MenuManagerNotSetupException, MenuManagerException {
        playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","chatevent"), PersistentDataType.INTEGER,1);
        p.sendMessage("type your target player in chat:");
        p.closeInventory();
        switch(inventoryClickEvent.getRawSlot()){
            case 0:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,1);
                break;
            case 1:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,2);
                break;
            case 2:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,3);
                break;
            case 3:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,4);
                break;
            case 4:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,5);
                break;
            case 5:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,6);
                break;
            case 6:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,7);
                break;
            case 7:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,8);
                break;
            case 8:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,9);
                break;
            case 9:
                playerMenuUtility.getOwner().getPersistentDataContainer().set(new NamespacedKey("pg","tempwaittype"), PersistentDataType.INTEGER,10);
                break;
            default:
                playerMenuUtility.getOwner().sendMessage("invalud click slot pmu "+inventoryClickEvent.getRawSlot());
                p.sendMessage("invalud click slot p "+inventoryClickEvent.getRawSlot());
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack b1m = new ItemStack(Material.LIME_WOOL);
        ItemMeta b1mm = b1m.getItemMeta();
        b1mm.setDisplayName("Ban for 1 min");
        b1m.setItemMeta(b1mm);

        ItemStack b5m = new ItemStack(Material.LIME_WOOL);
        ItemMeta b5mm = b5m.getItemMeta();
        b5mm.setDisplayName("Ban for 5 min");
        b5m.setItemMeta(b5mm);

        ItemStack b1h = new ItemStack(Material.BROWN_WOOL);
        ItemMeta b1hm = b1h.getItemMeta();
        b1hm.setDisplayName("Ban for 1 hour");
        b1h.setItemMeta(b1hm);

        ItemStack b12h = new ItemStack(Material.CYAN_WOOL);
        ItemMeta b12hm = b12h.getItemMeta();
        b12hm.setDisplayName("Ban for 12 hours");
        b12h.setItemMeta(b12hm);

        ItemStack b1d = new ItemStack(Material.CYAN_WOOL);
        ItemMeta b1dm = b1d.getItemMeta();
        b1dm.setDisplayName("Ban for 1 day");
        b1d.setItemMeta(b1dm);

        ItemStack b1w = new ItemStack(Material.BLUE_WOOL);
        ItemMeta b1wm = b1w.getItemMeta();
        b1wm.setDisplayName("Ban for 1 week");
        b1w.setItemMeta(b1wm);

        ItemStack b1mt = new ItemStack(Material.YELLOW_WOOL);
        ItemMeta b1mtm = b1mt.getItemMeta();
        b1mtm.setDisplayName("Ban for 1 month");
        b1mt.setItemMeta(b1mtm);

        ItemStack b3m = new ItemStack(Material.ORANGE_WOOL);
        ItemMeta b3mm = b3m.getItemMeta();
        b3mm.setDisplayName("Ban for 3 months");
        b3m.setItemMeta(b3mm);

        ItemStack b11m = new ItemStack(Material.RED_WOOL);
        ItemMeta b11mm = b11m.getItemMeta();
        b11mm.setDisplayName("Ban for 1 year");
        b11m.setItemMeta(b11mm);

        inventory.addItem(b11m,b3m,b1mt,b1w,b1d,b12h,b1h,b5m,b1m);
    }
}
