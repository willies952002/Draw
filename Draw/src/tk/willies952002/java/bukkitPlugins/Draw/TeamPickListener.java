package tk.willies952002.java.bukkitPlugins.Draw;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class TeamPickListener implements Listener {

	@SuppressWarnings("unused")
	private Plugin plugin;
	@SuppressWarnings("unused")
	private DrawScoreboard board;

	public TeamPickListener(Plugin p, DrawScoreboard sb) {
		this.plugin = p;
		this.board = sb;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onTeamPick(PlayerInteractEvent e) {
		Action a = e.getAction();
		ItemStack i = e.getItem();
		Player p = e.getPlayer();
		boolean b = e.isBlockInHand();
		if ( b ) {
			if ( i.getType() == Material.STAINED_CLAY ) {
				if ( a == Action.LEFT_CLICK_AIR ) {
					e.setCancelled(true);
					plugin.getLogger().info("Data: " + i.getData());
					plugin.getLogger().info("ItemMeta: " + i.getItemMeta());
					plugin.getLogger().info("Type: " + i.getType());
				}
			}
		}
	}

}
