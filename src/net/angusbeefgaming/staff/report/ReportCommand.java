package net.angusbeefgaming.staff.report;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.util.UtilServer;
import net.md_5.bungee.api.ChatColor;

public class ReportCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		if(!(args.length >= 2)) {
			player.sendMessage(ChatColor.RED + "Please Use the command like this: /report <Player> <Reason>");
		}
		
		String target = args[0];
		String reason = UtilServer.combine(args, 1);
		
		
	}
}
