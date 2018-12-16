package fr.pumpmykitbukkit;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import fr.pumpmykitcore.command.CommandHandler;
import fr.pumpmykitcore.utils.Utils;

public class KitDelCommand implements ISubCommand {

	@Override
	public boolean onSubCommand(Player sender, Command cmd, List<String> args) {
		
		if(sender.hasPermission("kit.del")) {
			
			Utils.debug(args.get(1));
			Utils.debug(args);
			CommandHandler.deleteKit(args.get(1));
		}
		return false;
	}

}
