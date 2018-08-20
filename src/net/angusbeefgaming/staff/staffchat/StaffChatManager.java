package net.angusbeefgaming.staff.staffchat;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.md_5.bungee.api.ChatColor;

public class StaffChatManager {
	public static void sendToStaff(Player sender, String message) {
		Bukkit.getConsoleSender().sendMessage("[STAFF CHAT] (" + sender.getName() + ") > " + message);
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(Permissions.hasPerm(pl, Action.STAFFCHAT)) {
				pl.sendMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "Staff " + ChatColor.GOLD + "(" + sender.getName() + ") > " + ChatColor.RED + message);
				pl.playSound(pl.getLocation(), Sound.BLOCK_NOTE_PLING, 1f, 1f);
			}
		}
	}
	
	public static void consoleMessage(String message) {
		Bukkit.getConsoleSender().sendMessage("[STAFF CHAT] (SYSTEM) > " + message);
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(Permissions.hasPerm(pl, Action.STAFFCHAT)) {
				pl.sendMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "Staff " + ChatColor.GOLD + "(SYSTEM) > " + ChatColor.RED + message);
				pl.playSound(pl.getLocation(), Sound.BLOCK_NOTE_PLING, 1f, 1f);
			}
		}
	}
}
