package fr.pumpmykitbukkit;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import fr.pumpmykitcore.command.CommandHandler;
import fr.pumpmykitcore.obj.Kit;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class KitListCommand implements ISubCommand {

	@Override
	public boolean onSubCommand(Player sender, Command cmd, List<String> args) {
		
		sender.sendMessage("§6§l[§r§2PumpMyKit§6§l] §r§2§oListe des kits §r§6§l[§r§2PumpMyKit§6§l]");
		sender.sendMessage("");
		sender.sendMessage("§6§l[§r§2PumpMyKit§6§l] §r§4Entre parenthèse se trouve le nombre d'utilisation disponibles.");
		sender.sendMessage("");
		
		for(Kit k : CommandHandler.kitList()) {
			
			TextComponent msg = new TextComponent("§a /kit " + k.getKitname());
			msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kit "+k.getKitname()));
			msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("\"§4 Prendre le kit "+ k.getKitname()).create()));
			
			sender.spigot().sendMessage(msg);
		}
		
		return false;
	}

}
