package net.minekingdom.blindcommand;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class BlindCommandListener implements Listener {
	
	@EventHandler
	public void onMilkDrank(PlayerInteractEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		final ItemStack item = event.getPlayer().getItemInHand();
		final Player player = event.getPlayer();
		
		if (item.getType().equals(Material.MILK_BUCKET) && !player.hasPermission("minekingdom.milkdrink")) {
			if (player.hasPotionEffect(PotionEffectType.BLINDNESS) && player.hasPotionEffect(PotionEffectType.WEAKNESS)) {
				event.setUseItemInHand(Event.Result.DENY);
			}
		}
	}	
}
