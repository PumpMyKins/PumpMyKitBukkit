package fr.pumpmykitbukkit.Command;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.pumpmykitbukkit.MainClass.ISubCommand;
import fr.pumpmykitcore.obj.Item;
import fr.pumpmykitcore.obj.Kit;
import fr.pumpmykitcore.utils.KitsUtils;
import net.md_5.bungee.api.ChatColor;

public class KitGiverCommand implements ISubCommand {

	@Override
	public boolean onSubCommand(Player sender, Command cmd, List<String> args) {
		
		if(KitsUtils.canUse(sender.getUniqueId().toString(), args.get(0)) || args.get(1).equals("true")) {
			Kit k = KitsUtils.getKit(args.get(0));
			Inventory invKit = Bukkit.createInventory(null, 27,ChatColor.RED + "" + ChatColor.BOLD + k.getKitname());
			for(Item i : k.getItemList()) {
				
				ItemStack item = new ItemStack(Material.getMaterial(i.getId()), i.getQuantity(), (short) i.getMeta());
				invKit.setItem(invKit.firstEmpty(), item);
			}
			if(k.getXp()>0) {
				sender.setExp(sender.getExp()+ k.getXp());
			}
			sender.openInventory(invKit);
		}
		return false;
	}

}
