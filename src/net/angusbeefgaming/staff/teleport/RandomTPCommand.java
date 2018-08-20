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
		return false;
	}
}
