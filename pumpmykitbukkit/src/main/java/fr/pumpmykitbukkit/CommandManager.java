package fr.pumpmykitbukkit;

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
