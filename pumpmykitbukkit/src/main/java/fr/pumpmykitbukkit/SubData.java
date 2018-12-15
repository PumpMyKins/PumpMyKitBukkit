package fr.pumpmykitbukkit;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class SubData {

	private String subCommand;
	private ISubCommand iSubCommand;
	
	public SubData(String s, String p, ISubCommand i) {
		
		this(s, i);
	}
	
	public SubData(String s, ISubCommand i) {
		
		this.subCommand = s;
		this.iSubCommand = i;
		
	}
	
	public boolean execute(Player sender, Command cmd, List<String> args) {
		
		return this.iSubCommand.onSubCommand(sender, cmd, args);
	}

	public String getSubCommand() {
		return subCommand;
	}

	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

	public ISubCommand getiSubCommand() {
		return iSubCommand;
	}

	public void setiSubCommand(ISubCommand iSubCommand) {
		this.iSubCommand = iSubCommand;
	}
	
	
}
