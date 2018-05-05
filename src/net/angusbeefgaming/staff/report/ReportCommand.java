package net.angusbeefgaming.staff.report;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.Core;
import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.angusbeefgaming.staff.util.UtilServer;
import net.md_5.bungee.api.ChatColor;

public class ReportCommand implements CommandExecutor {
	Core plugin = Core.getCore();
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		if(plugin.getConfig().getBoolean("toggle.report") != true) {
			return false;
		}
		
		if(!(args.length >= 2)) {
			player.sendMessage(ChatColor.RED + "Please Use the command like this: /report <Player> <Reason>");
			return false;
		}
		
		String target = args[0];
		String reason = UtilServer.combine(args, 1);
		
		if(ReportsManager.hasReportForPlayer(player.getName(), args[0])) {
			player.sendMessage(ChatColor.RED + "You already have an open report for " + args[0] + "!");
			return false;
		}
		
		ReportsManager.addReport(target, player.getName(), reason);
		player.sendMessage(ChatColor.GREEN + "You have reported " + ChatColor.GOLD + target + ChatColor.GREEN + " for " + ChatColor.GOLD + reason + ChatColor.GREEN + ". Thanks for the Report!");
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(Permissions.hasPerm(pl, Action.REPORTREVIEW)) {
				pl.sendMessage(ChatColor.GOLD + player.getName() +  ChatColor.GREEN + " has reported " + ChatColor.GOLD + target + ChatColor.GREEN + " for " + ChatColor.GOLD + reason);
			}
		}
		return true;
	}
}
