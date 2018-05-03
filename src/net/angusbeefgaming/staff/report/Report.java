package net.angusbeefgaming.staff.report;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Report {
	private String target;
	private String reporter;
	private String reason;
	private boolean resolved;
	private int id;
	
	public Report(String target, String reporter, String reason, int id) {
		this.target = target;
		this.reporter = reporter;
		this.reason = reason;
		this.id = id;
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
	public boolean isResolved() {
		return resolved;
	}
	public void resolve() {
		resolved = true;
	}
	public int getId() {
		return id;
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
