package net.angusbeefgaming.staff.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UtilServer {
	public static Player getRandomPlayer() {
		int rando = (int) (Math.random() * Bukkit.getOnlinePlayers().size());
		List playerList = new ArrayList(Bukkit.getOnlinePlayers());
		return (Player) playerList.get(rando);
	}
	
	public static String combine(String[] arr, int startPos) {
        StringBuilder str = new StringBuilder();

        for(int i = startPos; i < arr.length; ++i) {
           str = str.append(arr[i] + " ");
        }
        return str.toString();
	}
}
