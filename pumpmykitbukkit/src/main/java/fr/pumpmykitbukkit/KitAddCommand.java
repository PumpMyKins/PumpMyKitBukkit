package fr.pumpmykitbukkit;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class KitAddCommand implements ISubCommand {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onSubCommand(Player sender, Command cmd, List<String> args) {

		Inventory invKit = Bukkit.createInventory(null, 27, ChatColor.RED + "" + ChatColor.BOLD + "Nouveau Kit : " + args.get(1));
		invKit.setItem(7, new ItemStack(Material.getMaterial(7),(short) 0));
		invKit.setItem(16, new ItemStack(Material.getMaterial(7),(short) 0));
		invKit.setItem(25, new ItemStack(Material.getMaterial(7),(short) 0));
		
		//XP SETTINGS
		ItemStack addXp = new ItemStack(Material.getMaterial(95), 1,(short) 0, (byte) 5);
		ItemMeta addXpMeta = addXp.getItemMeta();
		addXpMeta.setDisplayName(ChatColor.GREEN +"Ajouter 5 Niveau !");
		addXp.setItemMeta(addXpMeta);
		invKit.setItem(8, addXp);
		
		ItemStack delXp = new ItemStack(Material.getMaterial(95), 1,(short) 0, (byte) 14);
		ItemMeta delXpMeta = delXp.getItemMeta();
		delXpMeta.setDisplayName(ChatColor.RED + "Retirer 5 Niveau !");
		delXp.setItemMeta(delXpMeta);
		invKit.setItem(26, delXp);
		
		ItemStack infoXp = new ItemStack(Material.getMaterial(95), 1,(short) 0);
		ItemMeta infoXpMeta = infoXp.getItemMeta();
		infoXpMeta.setDisplayName(ChatColor.WHITE + "Retirer 5 Niveau !");
		infoXp.setItemMeta(infoXpMeta);
		invKit.setItem(17, infoXp);
		
		return false;
	}

}
