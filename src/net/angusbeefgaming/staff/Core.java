package net.angusbeefgaming.staff;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.staff.freeze.FreezeCommand;
import net.angusbeefgaming.staff.freeze.FreezeManager;
import net.angusbeefgaming.staff.report.ReportCommand;
import net.angusbeefgaming.staff.report.ResoveReportCommand;
import net.angusbeefgaming.staff.report.ReviewReportsCommand;
import net.angusbeefgaming.staff.staffchat.StaffChatCommand;
import net.angusbeefgaming.staff.teleport.RandomTPCommand;

public class Core extends JavaPlugin {
	
    private File configFile;
    private FileConfiguration config;
    private static Core instance;
	
	/*
	 * Welcome to the Infinity Staff Plugin
	 * This plugin was coded and is maintained by Atticus Zambrana (MrBeefSteak)
	 */
	
	@Override
	public void onEnable() {
		instance = this;
		getCommand("freeze").setExecutor(new FreezeCommand());
		getCommand("randomtp").setExecutor(new RandomTPCommand());
		getCommand("sc").setExecutor(new StaffChatCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("reviewreports").setExecutor(new ReviewReportsCommand());
		getCommand("resolve").setExecutor(new ResoveReportCommand());
		
		getServer().getPluginManager().registerEvents(new FreezeManager(), this);
		
		// Setup the Configuration File
		setupConfig();
		
	}
	
	@Override
	public void onDisable() {
		
		
	}
	
	public static Core getCore() {
		return instance;
	}
	
	public FileConfiguration getConfig() {
		return config;
	}
	
	private void setupConfig() {
        configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
        	configFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
            saveDefaultConfig();
         }

        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
	}

}
