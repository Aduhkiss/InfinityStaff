package net.angusbeefgaming.staff;

import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.staff.freeze.FreezeCommand;
import net.angusbeefgaming.staff.freeze.FreezeManager;
import net.angusbeefgaming.staff.report.ReportCommand;
import net.angusbeefgaming.staff.report.ResoveReportCommand;
import net.angusbeefgaming.staff.report.ReviewReportsCommand;
import net.angusbeefgaming.staff.staffchat.StaffChatCommand;
import net.angusbeefgaming.staff.teleport.RandomTPCommand;

public class Core extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("freeze").setExecutor(new FreezeCommand());
		getCommand("randomtp").setExecutor(new RandomTPCommand());
		getCommand("sc").setExecutor(new StaffChatCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("reviewreports").setExecutor(new ReviewReportsCommand());
		getCommand("resolve").setExecutor(new ResoveReportCommand());
		
		getServer().getPluginManager().registerEvents(new FreezeManager(), this);
		
	}
	
	@Override
	public void onDisable() {
		
		
	}

}
