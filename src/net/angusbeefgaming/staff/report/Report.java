package net.angusbeefgaming.staff.report;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Report {
	private String target;
	private String reporter;
	private String reason;
	
	public Report(String target, String reporter, String reason) {
		this.target = target;
		this.reporter = reporter;
		this.reason = reason;
	}
	
	public String getTarget() {
		return target;
	}
	public String getReporter() {
		return reporter;
	}
	public String getReason() {
		return reason;
	}
	
	public boolean isTargetOnline() {
		if(Bukkit.getPlayer(target) != null) {
			return true;
		}
		return false;
	}
	
	public Player getTargetPlayer() {
		if(isTargetOnline() != false) {
			return Bukkit.getPlayer(target);
		}
		return null;
	}
}
