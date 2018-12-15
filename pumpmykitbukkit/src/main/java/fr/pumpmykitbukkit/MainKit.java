package fr.pumpmykitbukkit;

import org.bukkit.plugin.java.JavaPlugin;

public class MainKit  extends JavaPlugin{
	
private static MainKit instance;
	
	@Override
	public void onEnable() {
			
			instance = this;

			CommandManager.init();
			
	}
	public void onDisable() {
			
			
	}
	
	public static MainKit getInstance() {
		return instance;
	}
}
