package fr.pumpmykitbukkit.Command;

import java.sql.Timestamp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pumpmykitcore.utils.KitsUtils;
import fr.pumpmykitcore.utils.Utils;

public class KitBuyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		//Schéma Commmande /buykit idPurchase buyeruuid kitname
		//SChéma KitsUtils : String buyerUuid, String kitname, Timestamp date, String idPurchase
		/*
		Timestamp timekit = new Timestamp(System.currentTimeMillis());
		KitsUtils.kitBuyLog(args[1], args[2], timekit , args[0]);
		*/
		Player sufike = Bukkit.getPlayer(sender.getName());
		Timestamp date = new Timestamp(System.currentTimeMillis());
		KitsUtils.kitBuyLog(sufike.getUniqueId().toString(), args[0], date, args[1]);
		return false;
	}	
}