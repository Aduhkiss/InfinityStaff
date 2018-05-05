package net.angusbeefgaming.staff.staffchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.Core;
import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.angusbeefgaming.staff.util.UtilServer;
import net.md_5.bungee.api.ChatColor;

public class StaffChatCommand implements CommandExecutor {
	Core plugin = Core.getCore();
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		if(plugin.getConfig().getBoolean("toggle.staffchat") != true) {
			return false;
		}
		
		if(!Permissions.hasPerm(player, Action.STAFFCHAT)) {
			player.sendMessage(ChatColor.RED + "I'm Sorry, but I cannot allow you to do that.");
			return false;
		}
		
		if(!(args.length >= 1)) {
			player.sendMessage(ChatColor.RED + "Please Use the command like this: /sc <Message>");
			return false;
		}
		
		String message = UtilServer.combine(args, 0);
		
		StaffChatManager.sendToStaff(player, message);
		return true;
	}
}
