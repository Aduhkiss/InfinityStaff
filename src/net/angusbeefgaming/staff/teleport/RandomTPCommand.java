package net.angusbeefgaming.staff.teleport;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.Core;
import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.angusbeefgaming.staff.util.UtilServer;
import net.md_5.bungee.api.ChatColor;

public class RandomTPCommand implements CommandExecutor {
	Core plugin = Core.getCore();
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		if(plugin.getConfig().getBoolean("toggle.randomtp") != true) {
			return false;
		}
		
		if(!Permissions.hasPerm(player, Action.RANDOMTP)) {
			player.sendMessage(ChatColor.RED + "I'm Sorry, but I cannot allow you to do that.");
			return false;
		}
		/*
		if(Bukkit.getOnlinePlayers().size() >= 1) {
			player.sendMessage(ChatColor.RED + "There are not enough players to RandomTP!");
			return false;
		}
		*/
		
		Player target = UtilServer.getRandomPlayer();
		
		player.teleport(target.getLocation());
		player.sendMessage(ChatColor.GREEN + "You have been teleported to " + target.getName());
		return true;
	}
}
