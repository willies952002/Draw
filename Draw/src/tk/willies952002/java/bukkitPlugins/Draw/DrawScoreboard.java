package tk.willies952002.java.bukkitPlugins.Draw;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class DrawScoreboard implements Scoreboard {

	private ScoreboardManager sbm;
	private Scoreboard board;
	public static Team teamRed;
	public static Team teamBlue;
	public static Team teamGreen;
	public static Team teamOrange;
	public static Team spectators;

	public DrawScoreboard(Plugin plugin) {
		sbm = plugin.getServer().getScoreboardManager();
		board = sbm.getNewScoreboard();
	}
	
	public void init() {
		teamRed = this.registerNewTeam(ChatColor.RED + "Red");
		teamBlue = this.registerNewTeam(ChatColor.BLUE + "Blue");
		teamGreen = this.registerNewTeam(ChatColor.GREEN + "Green");
		teamOrange = this.registerNewTeam(ChatColor.GOLD + "Orange");
		spectators = this.registerNewTeam(ChatColor.YELLOW + "Spectators");
		teamRed.setAllowFriendlyFire(false);
		teamBlue.setAllowFriendlyFire(false);
		teamGreen.setAllowFriendlyFire(false);
		teamOrange.setAllowFriendlyFire(false);
		teamRed.setCanSeeFriendlyInvisibles(true);
		teamBlue.setCanSeeFriendlyInvisibles(true);
		teamGreen.setCanSeeFriendlyInvisibles(true);
		teamOrange.setCanSeeFriendlyInvisibles(true);
		teamRed.setDisplayName(ChatColor.RED + "Red");
		teamBlue.setDisplayName(ChatColor.BLUE + "Blue");
		teamGreen.setDisplayName(ChatColor.GREEN + "Green");
		teamOrange.setDisplayName(ChatColor.GOLD + "Orange");
		spectators.setDisplayName(ChatColor.YELLOW + "Spectators");
	}

	@Override
	public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {
		board.clearSlot(slot);
	}

	@Override
	public Objective getObjective(String name) throws IllegalArgumentException {
		return board.getObjective(name);
	}

	@Override
	public Objective getObjective(DisplaySlot slot)
			throws IllegalArgumentException {
		return board.getObjective(slot);
	}

	@Override
	public Set<Objective> getObjectives() {
		return board.getObjectives();
	}

	@Override
	public Set<Objective> getObjectivesByCriteria(String criteria)
			throws IllegalArgumentException {
		return board.getObjectivesByCriteria(criteria);
	}

	@Override
	public Team getPlayerTeam(OfflinePlayer player)
			throws IllegalArgumentException {
		return board.getPlayerTeam(player);
	}

	@Override
	public Set<OfflinePlayer> getPlayers() {
		return board.getPlayers();
	}

	@Override
	public Set<Score> getScores(OfflinePlayer player)
			throws IllegalArgumentException {
		return board.getScores(player);
	}

	@Override
	public Team getTeam(String teamName) throws IllegalArgumentException {
		return board.getTeam(teamName);
	}

	@Override
	public Set<Team> getTeams() {
		return board.getTeams();
	}

	@Override
	public Objective registerNewObjective(String name, String criteria)
			throws IllegalArgumentException {
		return board.registerNewObjective(name, criteria);
	}

	@Override
	public Team registerNewTeam(String name) throws IllegalArgumentException {
		return board.registerNewTeam(name);
	}

	@Override
	public void resetScores(OfflinePlayer player)
			throws IllegalArgumentException {
		board.resetScores(player);
	}
	
}
		