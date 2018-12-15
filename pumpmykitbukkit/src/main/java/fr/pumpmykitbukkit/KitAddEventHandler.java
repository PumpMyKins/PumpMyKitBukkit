package fr.pumpmykitbukkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

import fr.pumpmykitcore.obj.Kit;

public class KitAddEventHandler {

	//XP SETTINGS
	int xp;
	boolean xpOn;
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		
		if(e.getInventory().getName().equals("Nouveau Kit : ")) {
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(8))) {
				e.setCancelled(true);
				xp = xp + 5;
				if(!xpOn) {
					xpOn = true;
				}
			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(26))) {
				e.setCancelled(true);
				xp = xp - 5;
				if(!xpOn) {
					xpOn = true;
				}
				if(xp < 0) {
					xp = 0;
				}
			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(17))) {
				if(xpOn) {
					xpOn = false;
				}
				else {
					xpOn = true;
				}
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInventoryMoveItemEvent(InventoryMoveItemEvent e) {
		
		if(e.getSource().getName().equals("Nouveau Kit : ")) {
			if(e.getItem().isSimilar(e.getSource().getItem(8)) || e.getItem().isSimilar(e.getSource().getItem(26)) || e.getItem().isSimilar(e.getSource().getItem(8))) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInventoryCloseEvent(InventoryCloseEvent e) {
		
		if(e.getInventory().getName().equals("Nouveau Kit : ")) {
			Kit k = new Kit();
			k.setKitname(" ");
			
		}
	}
	
}
