package fr.pumpmykitbukkit.Command;

import java.sql.Timestamp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.pumpmykitcore.utils.KitsUtils;
import fr.pumpmykitcore.utils.Utils;

public class KitBuyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		//Schéma Commmande /buykit idPurchase buyeruuid kitname
		//SChéma KitsUtils : String buyerUuid, String kitname, Timestamp date, String idPurchase
		
		Timestamp timekit = new Timestamp(System.currentTimeMillis());
		Utils.debug(args);
		KitsUtils.kitBuyLog(args[1], args[2], timekit , args[0]);
		return false;
	}

	
}
