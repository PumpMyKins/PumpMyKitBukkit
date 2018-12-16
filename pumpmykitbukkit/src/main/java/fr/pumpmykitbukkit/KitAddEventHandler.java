package fr.pumpmykitbukkit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

import fr.pumpmykitcore.obj.Item;
import fr.pumpmykitcore.obj.Kit;

public class KitAddEventHandler {

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {

		if(e.getInventory().getName().equals("Nouveau Kit : ")) {
			
			//TODO fix dynamic lore !! Make a cool method to not manipulate like a dragon
			
			int xp = 0;
			boolean xpOn = Boolean.valueOf(e.getInventory().getItem(17).getItemMeta().getLore().get(1));
			
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(8))) {
				
				xp = xp + 5;
				if(!xpOn) {
					xpOn = true;
					e.getInventory().getItem(17).setItemMeta(e.getInventory().getItem(17).getItemMeta().setLore(e.getInventory().getItem(17).getItemMeta().getLore().add(1, "true")));
					e.getInventory().getItem(17).getItemMeta().getLore().remove(2);
					e.getInventory().getItem(17).getItemMeta().getLore().add(2, Integer.toString(xp) + "Niveau(x)");
					e.getInventory().getItem(17).getItemMeta().getLore().remove(3);

				}
				e.setCancelled(true);
			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(26))) {
				xp = xp - 5;
				if(!xpOn) {
					xpOn = true;
					e.getInventory().getItem(17).getItemMeta().getLore().add(1, "true");
					e.getInventory().getItem(17).getItemMeta().getLore().remove(2);
					e.getInventory().getItem(17).getItemMeta().getLore().add(2, Integer.toString(xp) + "Niveau(x)");
					e.getInventory().getItem(17).getItemMeta().getLore().remove(3);
				}
				e.setCancelled(true);
			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(17))) {
				if(xpOn) {
					xpOn = false;
					e.getInventory().getItem(17).getItemMeta().getLore().add(1, "false");
					e.getInventory().getItem(17).getItemMeta().getLore().remove(2);
				}
				else {
					xpOn = true;
					e.getInventory().getItem(17).getItemMeta().getLore().add(1, "true");
					e.getInventory().getItem(17).getItemMeta().getLore().remove(2);
				}
				e.setCancelled(true);
			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(16))) {
				if(Boolean.valueOf(e.getInventory().getItem(16).getItemMeta().getLore().get(1))) {
					e.getInventory().getItem(16).getItemMeta().getLore().add(1, "false");
					e.getInventory().getItem(16).getItemMeta().getLore().remove(2);
				} else {
					e.getInventory().getItem(16).getItemMeta().getLore().add(1, "true");
					e.getInventory().getItem(16).getItemMeta().getLore().remove(2);
				}
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

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryCloseEvent(InventoryCloseEvent e) {

		if(e.getInventory().getName().equals("Nouveau Kit : ")) {
			Kit k = new Kit();
			List<Item> listItem = new ArrayList<Item>();
			List<String> itemNameList = new ArrayList<String>();
			for(ItemStack i : e.getInventory().getContents()) {
				Item itemForKit = new Item();
				String itemName = new String();
				if(!i.isSimilar(e.getInventory().getItem(8)) || !i.isSimilar(e.getInventory().getItem(26)) || !i.isSimilar(e.getInventory().getItem(17)) || !i.isSimilar(e.getInventory().getItem(7)) || !i.isSimilar(e.getInventory().getItem(16))) {

					itemForKit.setQuantity(i.getAmount());
					itemForKit.setId(Integer.toString(i.getTypeId()));
					itemForKit.setMeta(i.getDurability());
					itemForKit.setItemName(i.getItemMeta().getDisplayName());
					listItem.add(itemForKit);

					itemName = i.getItemMeta().getDisplayName();
					itemNameList.add(itemName);
				}
			}
			k.setKitname(e.getInventory().getItem(7).getItemMeta().getDisplayName());
			k.setEula(Boolean.valueOf(e.getInventory().getItem(16).getItemMeta().getDisplayName()));
			k.setItemList(listItem);
			k.setItemNameList(itemNameList);


		}
	}

}
