package net.angusbeefgaming.staff;

import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.staff.freeze.FreezeCommand;
import net.angusbeefgaming.staff.freeze.FreezeManager;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("freeze").setExecutor(new FreezeCommand());
		
		getServer().getPluginManager().registerEvents(new FreezeManager(), this);
		
	}
	
	@Override
	public void onDisable() {
		
		
	}

}
