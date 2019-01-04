package fr.pumpmykitbukkit.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import fr.pumpmykitbukkit.MainClass.ISubCommand;
import fr.pumpmykitcore.command.CommandHandler;
import fr.pumpmykitcore.config.ConfigUtils;

public class KitRandom implements ISubCommand {

	@Override
	public boolean onSubCommand(Player sender, Command cmd, List<String> args) {

		if(sender.hasPermission("vip.random")) {
			if(ConfigUtils.getConfigFile().getBoolean("AllowRandom")) {
				
				List<String> newargs = new ArrayList<String>();
				newargs.add(CommandHandler.randomKit().getKitname());
				newargs.add("true");
				new KitGiverCommand().onSubCommand(sender, cmd, newargs);
			}
		} else {
			sender.sendMessage("noperm");
		}
		return false;
	}

}
