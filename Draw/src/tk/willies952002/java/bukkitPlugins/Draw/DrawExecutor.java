package tk.willies952002.java.bukkitPlugins.Draw;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DrawExecutor implements CommandExecutor {

	Plugin plugin;

	public DrawExecutor(Plugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ( isCommand(cmd) ) {
			if ( properArgs(args.length, sender) ) {
				//TODO Send Players Back To Hub
				//TODO Reload World
				//TODO Restart Server
			}
			else {
				sender.sendMessage("The Given Arguments Do Not Match The Number Of Required Arguments");
			}
		}
		return false;
	}

	private boolean properArgs(int lengthArgs, CommandSender sender) {
		int minArgs = 0;
		int maxArgs = 2;
		if ( isPlayer(sender) ) {
			minArgs = 1;
		}
		else if ( isConsole(sender) ){
			minArgs = 2;
		}
		return (minArgs < lengthArgs) && (lengthArgs < maxArgs);
	}

	private boolean isConsole(CommandSender sender) {
		return sender instanceof ConsoleCommandSender;
	}

	private boolean isPlayer(CommandSender sender) {
		return sender instanceof Player;
	}

	private boolean isCommand(Command cmd) {
		return cmd.getName().equalsIgnoreCase("draw");
	}

}
