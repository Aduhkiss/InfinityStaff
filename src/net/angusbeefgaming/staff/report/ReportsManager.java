package net.angusbeefgaming.staff.report;

import java.util.ArrayList;
import java.util.List;

public class ReportsManager {
	public static List<Report> reportedPlayers = new ArrayList<Report>();
	
	public static void addReport(String target, String reporter, String reason) {
		reportedPlayers.add(new Report(target, reporter, reason, reportedPlayers.size() + 1));
	}
	
	public static void resolveReport(Report r) {
		r.resolve();
	}
	
	public static Report getReport(int id) {
		for(Report re : reportedPlayers) {
			if(re.getId() == id) {
				return re;
			}
		}
		return null;
	}
	
	public static List<Report> getReports() {
		return reportedPlayers;
	}
	
	public static boolean hasReportForPlayer(String reporter, String target) {
		for(Report r : reportedPlayers) {
			if(r.getTarget().equals(target)) {
				if(r.getReporter().equals(reporter)) {
					if(r.isResolved()) {
						return false;
					}
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
