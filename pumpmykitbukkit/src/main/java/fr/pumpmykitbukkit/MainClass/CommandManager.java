package fr.pumpmykitbukkit.MainClass;

import fr.pumpmykitbukkit.Command.KitAddCommand;
import fr.pumpmykitbukkit.Command.KitChgCommand;
import fr.pumpmykitbukkit.Command.KitDelCommand;
import fr.pumpmykitbukkit.Command.KitGiverCommand;
import fr.pumpmykitbukkit.Command.KitHelpCommand;
import fr.pumpmykitbukkit.Command.KitListCommand;
import fr.pumpmykitcore.command.CommandHandler;
import fr.pumpmykitcore.obj.Kit;

public class CommandManager {

	public static CommandManager init() {

		return new CommandManager();
	}
	
	private KitCommandExecutor kitCmd;
	
	public CommandManager() {
		
		kitCmd = new KitCommandExecutor();
		
		MainKit.getInstance().getCommand("kit").setExecutor(kitCmd);
		kitCmd.addSubCommand("help", new KitHelpCommand());
		kitCmd.addSubCommand("list", new KitListCommand());
		
		for(Kit k : CommandHandler.kitList()) {
			kitCmd.addSubCommand(k.getKitname(), new KitGiverCommand());
		}
		
		kitCmd.addSubCommand("add", new KitAddCommand());
		kitCmd.addSubCommand("del", new KitDelCommand());
		kitCmd.addSubCommand("change", new KitChgCommand());
		
	}

}
