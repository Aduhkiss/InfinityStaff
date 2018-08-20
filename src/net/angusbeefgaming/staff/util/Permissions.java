package net.angusbeefgaming.staff.util;

import org.bukkit.entity.Player;

public class Permissions {
	
	/**
	 * Permission System is able to use Permissions and/or /OP
	 */
	
	public static boolean hasPerm(Player p, Action a) {
		if(p.isOp() || p.hasPermission("infinitystaff.*")) {
			return true;
		}
		if(p.hasPermission("infinitystaff." + a.toString())) {
			return true;
		}
		return false;
	}
}
