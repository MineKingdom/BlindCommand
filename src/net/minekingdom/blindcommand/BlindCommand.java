package net.minekingdom.blindcommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindCommand extends JavaPlugin {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("minekingdom.blind.use")) {
			
			if (cmd.getName().equalsIgnoreCase("blind")) {
				if (args.length == 1) {
					
					Player target = Bukkit.getPlayer(args[0]);
					
					if (target != null) {
						PotionEffect potion = new PotionEffect(PotionEffectType.BLINDNESS, 2000000000, 100);
						target.addPotionEffect(potion);
						PotionEffect potion2 = new PotionEffect(PotionEffectType.WEAKNESS, 2000000000, 100);
						target.addPotionEffect(potion2);
						sender.sendMessage(ChatColor.GREEN + "Commande réussie !");
					} else {
						sender.sendMessage(ChatColor.RED + "Le joueur " + args[0] + " n'existe pas.");
					}
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "La commande écrite est de taille incorrecte.");
				}	
			} else if (cmd.getName().equalsIgnoreCase("unblind")) {
				if (args.length == 1) {
					
					Player target = Bukkit.getPlayer(args[0]);
					
					if (target != null) {
						target.removePotionEffect(PotionEffectType.WEAKNESS);
						target.removePotionEffect(PotionEffectType.BLINDNESS);
						sender.sendMessage(ChatColor.GREEN + "Commande réussie !");
					} else {
						sender.sendMessage(ChatColor.RED + "Le joueur " + args[0] + " n'existe pas.");
					}
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "La commande écrite est de taille incorrecte.");
				}	
			}
			
		}
		return false;
	}
}
