package net.angusbeefgaming.staff.freeze;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.md_5.bungee.api.ChatColor;

public class FreezeCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		if(!Permissions.hasPerm(player, Action.FREEZE)) {
			player.sendMessage(ChatColor.RED + "I'm Sorry, but I cannot allow you to do that.");
			return false;
		}
		
		if(args.length < 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target == null) {
				player.sendMessage(ChatColor.RED + "I'm Sorry, but that player was not found!");
				return false;
			}
			
			if(FreezeManager.frozenPlayers.get(target)) {
				FreezeManager.frozenPlayers.put(player, false);
				target.sendMessage(ChatColor.GREEN + "You have been unfrozen!");
				player.sendMessage(ChatColor.GREEN + "You have unfrozen " + target.getName());
				return true;
			}
			else {
				FreezeManager.frozenPlayers.put(player, true);
				target.sendMessage(ChatColor.RED + "You have been frozen by a staff member!");
				player.sendMessage(ChatColor.GREEN + "You have frozen " + target.getName());
				return true;
			}
		}
		else {
			player.sendMessage(ChatColor.RED + "Please Use the command like this: /freeze <Player>");
			return false;
		}
	}

}