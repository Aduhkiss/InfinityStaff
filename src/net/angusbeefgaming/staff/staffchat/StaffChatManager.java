package net.angusbeefgaming.staff.staffchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.angusbeefgaming.staff.util.Action;
import net.angusbeefgaming.staff.util.Permissions;
import net.md_5.bungee.api.ChatColor;

public class StaffChatManager {
	public static void sendToStaff(Player sender, String message) {
		for(Player pl : Bukkit.getOnlinePlayers()) {
			if(Permissions.hasPerm(pl, Action.STAFFCHAT)) {
				pl.sendMessage(ChatColor.GREEN + "[Staff Chat] " + ChatColor.GOLD + "(" + sender.getName() + ") > " + ChatColor.GREEN + message);
			}
		}
	}
}
