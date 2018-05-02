package net.angusbeefgaming.staff;

import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.staff.freeze.FreezeCommand;
import net.angusbeefgaming.staff.freeze.FreezeManager;
import net.angusbeefgaming.staff.staffchat.StaffChatCommand;
import net.angusbeefgaming.staff.teleport.RandomTPCommand;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("freeze").setExecutor(new FreezeCommand());
		getCommand("randomtp").setExecutor(new RandomTPCommand());
		getCommand("sc").setExecutor(new StaffChatCommand());
		
		getServer().getPluginManager().registerEvents(new FreezeManager(), this);
		
	}
	
	@Override
	public void onDisable() {
		
		
	}

}
