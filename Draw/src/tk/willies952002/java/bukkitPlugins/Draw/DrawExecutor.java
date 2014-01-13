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
			if ( args[0].equalsIgnoreCase("reload") ) {
				if ( properArgs(args.length, sender, 0, 2) ) {
					/**
					TODO Send Players Back To Lobby {
						TODO List Players Playing On The Server
						TODO Enumerate Through The Players And 'Kick' Them To The Lobby
					}					
					TODO Call External Reload Program Packaged In Jar {
						TODO Reload World {
							TODO List Files Contained in The 3 World Folders
							TODO Enumerate Through Each File And Delete Them
							TODO Open DrawWorld.zip and Prepare For Restart
						}
						TODO Restart Server {
							TODO Call A Command To Start A New Server Instance
						}
					}
					*/
				}
				else if ( (isPlayer(sender) || isConsole(sender)) && !properArgs(args.length, sender, 0, 2) ){
					sender.sendMessage("The Given Arguments Do Not Match The Number Of Required Arguments");
				}
				else {
					sender.sendMessage("You Cannot Execute This Command Without Being A Player Or Accessing The Console");
				}
			}
		}
		return false;
	}

	private boolean properArgs(int lengthArgs, CommandSender sender, int min, int max) {
		int minArgs = min;
		int maxArgs = max;
		if ( isPlayer(sender) ) {
			minArgs = 1;
		}
		else if ( isConsole(sender) ){
			minArgs = 2;
		}
		else {
			return false;
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
