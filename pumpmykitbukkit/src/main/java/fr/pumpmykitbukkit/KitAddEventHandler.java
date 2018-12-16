package fr.pumpmykitbukkit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.pumpmykitcore.obj.Item;
import fr.pumpmykitcore.obj.Kit;

public class KitAddEventHandler {

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {

		if(e.getInventory().getName().equals("Nouveau Kit : ")) {

			int xp = 0;
			boolean xpOn = Boolean.valueOf(e.getInventory().getItem(17).getItemMeta().getLore().get(1));
			boolean isEula = Boolean.valueOf(e.getInventory().getItem(16).getItemMeta().getLore().get(1));

			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(8))) {

				xp = xp + 5;
				if(!xpOn) {
					xpOn = true;
					List<String> itemLore = e.getInventory().getItem(17).getItemMeta().getLore();
					itemLore.add(1, "true");
					itemLore.remove(2);
					itemLore.add(2, Integer.toString(xp) + "Niveau(x)");
					itemLore.remove(3);
					ItemMeta itemMeta = e.getInventory().getItem(17).getItemMeta();
					itemMeta.setLore(itemLore);
					e.getInventory().getItem(17).setItemMeta(itemMeta);
				}
			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(26))) {
				xp = xp - 5;
				if(xp < 0) {
					xp = 0;
				}
				if(!xpOn) {
					xpOn = true;
					List<String> itemLore = e.getInventory().getItem(17).getItemMeta().getLore();
					itemLore.add(1, String.valueOf(xpOn));
					itemLore.remove(2);
					itemLore.add(2, Integer.toString(xp) + "Niveau(x)");
					itemLore.remove(3);
					ItemMeta itemMeta = e.getInventory().getItem(17).getItemMeta();
					itemMeta.setLore(itemLore);
					e.getInventory().getItem(17).setItemMeta(itemMeta);
				}
			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(17))) {
				if(xpOn) {
					xpOn = false;
				}
				else {
					xpOn = true;
				}
				List<String> itemLore = e.getInventory().getItem(17).getItemMeta().getLore();
				itemLore.add(1, String.valueOf(xpOn));
				itemLore.remove(2);
				ItemMeta itemMeta = e.getInventory().getItem(17).getItemMeta();
				itemMeta.setLore(itemLore);
				e.getInventory().getItem(17).setItemMeta(itemMeta);

			}
			if(e.getCurrentItem().isSimilar(e.getInventory().getItem(16))) {
				if(isEula) {
					isEula = false;
				} else {
					isEula = true;
				}
				List<String> itemLore = e.getInventory().getItem(16).getItemMeta().getLore();
				itemLore.add(1, String.valueOf(isEula));
				itemLore.remove(2);
				ItemMeta itemMeta = e.getInventory().getItem(16).getItemMeta();
				itemMeta.setLore(itemLore);
				e.getInventory().getItem(16).setItemMeta(itemMeta);

			}
			e.setCancelled(true);
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
