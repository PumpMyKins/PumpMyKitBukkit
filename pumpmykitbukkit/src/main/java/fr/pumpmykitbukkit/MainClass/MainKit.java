package fr.pumpmykitbukkit.MainClass;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pumpmykitcore.config.ConfigUtils;

public class MainKit  extends JavaPlugin{
	
private static MainKit instance;
	
	@Override
	public void onEnable() {
			
			instance = this;

			CommandManager.init();
			ConfigUtils.init();
			
	}
	public void onDisable() {
			
			
	}
	
	public static MainKit getInstance() {
		return instance;
	}
}
