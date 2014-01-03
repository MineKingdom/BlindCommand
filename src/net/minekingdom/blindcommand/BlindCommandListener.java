package net.minekingdom.blindcommand;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BlindCommandListener implements Listener {
	
	@EventHandler
	public void onMilkDrank(PlayerInteractEvent event) {
		ItemStack item = event.getPlayer().getItemInHand();
		Material milk = Material.MILK_BUCKET;
		Player player = event.getPlayer();
		
		if (item.getType().equals(milk)) {
			if (player.hasPermission("minekingdom.milkdrink")) {
				event.getAction().equals(Action.RIGHT_CLICK_AIR);
				event.getAction().equals(Action.RIGHT_CLICK_BLOCK);
				event.setUseItemInHand(Event.Result.DENY);
			}
		}
	}	
}
