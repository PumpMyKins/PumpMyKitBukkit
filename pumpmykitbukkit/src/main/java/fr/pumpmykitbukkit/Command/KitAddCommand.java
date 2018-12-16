package fr.pumpmykitbukkit.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.pumpmykitbukkit.MainClass.ISubCommand;
import fr.pumpmykitcore.utils.KitsUtils;
import fr.pumpmykitcore.utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class KitAddCommand implements ISubCommand {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onSubCommand(Player sender, Command cmd, List<String> args) {

		if(sender.hasPermission("kit.add")) {
			Utils.debug(KitsUtils.getKit(args.get(1)));
			Utils.debug(args.get(1));
			if(KitsUtils.getKit(args.get(1)) == null) {
				Inventory invKit = Bukkit.createInventory(null, 27, ChatColor.RED + "" + ChatColor.BOLD + "Nouveau Kit : " + args.get(1));

				ItemStack bedRock = new ItemStack(Material.BEDROCK, 1);
				ItemMeta bedRockMeta = bedRock.getItemMeta();
				bedRockMeta.setDisplayName(args.get(1));
				bedRock.setItemMeta(bedRockMeta);
				invKit.setItem(7, new ItemStack(bedRock));
				invKit.setItem(25, new ItemStack(bedRock));

				//EULA SETTINGS
				ItemStack noteBlock = new ItemStack(Material.NOTE_BLOCK, 1);
				List<String> lore = new ArrayList<String>();
				ItemMeta noteBlockMeta = noteBlock.getItemMeta();
				noteBlockMeta.setDisplayName("EULA :");
				lore.add(1, "true");
				noteBlockMeta.setLore(lore);
				noteBlock.setItemMeta(noteBlockMeta);
				invKit.setItem(16, noteBlock);

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

				sender.openInventory(invKit);
				return true;

			}
			return false;
		}
		return false;
	}
}
