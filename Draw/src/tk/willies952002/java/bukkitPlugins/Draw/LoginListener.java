package tk.willies952002.java.bukkitPlugins.Draw;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

/**
 * @author William Surgeon ( willies952002 )
 * @version 1.0dev
 */
public class LoginListener implements Listener {

	Configuration config;
	Logger log;

	public LoginListener(Plugin plugin) {
		config = plugin.getConfig();
		log = plugin.getLogger();
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent login) {
		if ( login.getPlayer() instanceof Player ) {
			login.allow();
			Player player = login.getPlayer();
			PlayerInventory inv = player.getInventory();
			inv.clear();
			int numTeams = config.getInt("teams.number");
			ItemStack[] items = new ItemStack[numTeams];
			String[][] teamSettings = new String[numTeams][2];
			int teamID = 0;
			if ( numTeams < 2 ) {
				log.warning("This Game Requires AT LEAST Two (2) Teams To Play It");
			}
			else if ( numTeams > 5 ) {
				log.warning("This Game Can Only Handle A Maximum of Four (4) Competing Teams And A Spectating Team");
			}
			else {
				for ( String team : config.getStringList("teams.nameList") ) {
					teamSettings[teamID++][0] = team;
				}
				for ( int color : config.getIntegerList("teams.colorList") ) {
					teamSettings[teamID++][1] = String.valueOf(color);
				}
				for ( teamID = 0; teamID < numTeams; teamID++ ) {
					items[teamID] = new ItemStack(Material.STAINED_CLAY, 1, ColorValues.getByID(Integer.parseInt(teamSettings[1][1])).getDmgValue());
				}
				for ( int slot = 0; slot < items.length; slot++ ) {
					inv.setItem(slot, items[slot]);
				}
			}
		}
		else {
			login.disallow(Result.KICK_OTHER, login.getPlayer() + " tried to connect but was not a Player");
		}
	}
	
}
