package net.angusbeefgaming.staff.report;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.md_5.bungee.api.ChatColor;

public class ResoveReportCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		if(!Permissions.hasPerm(player, Action.REPORTREVIEW)) {
			player.sendMessage(ChatColor.RED + "I'm Sorry, but I cannot allow you to do that.");
			return false;
		}
		
		if(!(args.length >= 1)) {
			player.sendMessage(ChatColor.RED + "Please Use the command like this: /resolve <Report ID>");
			return false;
		}
		
		int reportToResolve = Integer.parseInt(args[0]);
		Report re = ReportsManager.getReport(reportToResolve);
		
		try {
			ReportsManager.resolveReport(ReportsManager.getReport(reportToResolve));
		}
		catch(NullPointerException e) {
			player.sendMessage(ChatColor.RED + "That Report cannot be found!");
			return false;
		}
		
		re.resolve();
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(Permissions.hasPerm(p, Action.REPORTREVIEW)) {
				p.sendMessage(ChatColor.GREEN + player.getName() + " has resolved Report #" + re.getId());
			}
		}
		
		return true;
	}
}
