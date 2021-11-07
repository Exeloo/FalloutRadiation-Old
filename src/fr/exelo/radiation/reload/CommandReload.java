package fr.exelo.radiation.reload;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.exelo.radiation.Main;

public class CommandReload {


	public CommandReload(Main main) {
	}
	
	public void getCommandReload (Command cmd, CommandSender sender, String lbl, String[] args) {
		if (args[0].equalsIgnoreCase("reload"))
				sender.sendMessage("§6[§eF.Rad§6] §1FalloutRadiation is reloding");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "plugman reload FalloutRadiation");
				return;
	}
}
