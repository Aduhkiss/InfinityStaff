package net.angusbeefgaming.staff.freeze;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.md_5.bungee.api.ChatColor;

public class FreezeManager implements Listener {
	
	public static Map<Player, Boolean> frozenPlayers = new HashMap<Player, Boolean>();

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(frozenPlayers.get(e.getPlayer()) == null) {
			return;
		}
		if(frozenPlayers.get(e.getPlayer()) == false) {
			return;
		}
		e.setCancelled(true);
		
		e.getPlayer().sendMessage(ChatColor.RED + "Hey! You cannot move while you are frozen!");
		
		return;
	}
}
