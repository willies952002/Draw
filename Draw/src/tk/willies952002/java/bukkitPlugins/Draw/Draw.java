package tk.willies952002.java.bukkitPlugins.Draw;

import java.util.logging.Logger;

import org.bukkit.configuration.Configuration;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author William Surgeon ( willies952002 )
 * @version 1.0dev
 */
public final class Draw extends JavaPlugin implements Listener {
	
	Logger log = this.getLogger();
	Configuration config = this.getConfig();
	LoginListener loginListener = new LoginListener(this);
	
	@Override
	public void onEnable() {
		//TODO Insert logic to be performed when the plugin is enabled
		DrawScoreboard scoreboard = new DrawScoreboard(this);
		scoreboard.init();
		this.getServer().getPluginManager().registerEvents(new LoginListener(this), this);
		this.getServer().getPluginManager().registerEvents(new TeamPickListener(this, scoreboard), this);
		this.getServer().getPluginManager().registerEvents(loginListener, this);
		//this.getCommand("draw").setExecutor(new DrawExecutor(this));
	}
	
	@Override
	public void onDisable() {
		//TODO Insert logic to be performed when the plugin is disabled
		HandlerList.unregisterAll(loginListener);
		this.saveConfig();
	}
	
}