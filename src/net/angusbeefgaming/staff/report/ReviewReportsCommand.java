package net.angusbeefgaming.staff.report;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.md_5.bungee.api.ChatColor;

public class ReviewReportsCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		if(!Permissions.hasPerm(player, Action.REPORTREVIEW)) {
			player.sendMessage(ChatColor.RED + "I'm Sorry, but I cannot allow you to do that.");
			return false;
		}
		
		player.sendMessage(ChatColor.GREEN + " === All Unresolved Reports ===");
		
		
		for(Report r : ReportsManager.getReports()) {
			if(!r.isResolved()) {
				player.sendMessage(ChatColor.GOLD + "#" + r.getId() + ChatColor.RED + " " + r.getTarget() + ChatColor.GREEN + " by " + ChatColor.RED + r.getReporter() + ChatColor.GREEN + " for " + ChatColor.RED + r.getReason());
			}
		}
		
		player.sendMessage(ChatColor.GREEN + " ==============================");
		
		return true;
		
	}

}
