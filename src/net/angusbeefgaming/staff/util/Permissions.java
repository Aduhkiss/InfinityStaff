package net.angusbeefgaming.staff.util;

import org.bukkit.entity.Player;

public class Permissions {
	
	/**
	 * Permission System is able to use Permissions and/or /OP
	 */
	
	public static boolean hasPerm(Player p, Action a) {
		if(p.isOp()) {
			return true;
		}
		if(p.hasPermission("infinitystaff.*")) {
			return true;
		}
		if(a == Action.FREEZE) {
			if(p.hasPermission("infinitystaff.freeze")) {
				return true;
			}
			return false;
		}
		if(a == Action.RANDOMTP) {
			if(p.hasPermission("infinitystaff.randomtp")) {
				return true;
			}
			return false;
		}
		return false;
	}
}
