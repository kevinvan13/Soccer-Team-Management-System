import java.util.List;
import java.util.Map;

/**
 * Soccer teams are represented by the players it contains, the starting lineup, the players on the
 * bench, their jersey numbers, and their status of team creation.
 */
public interface SoccerTeamInterface {
  /**
   * Adds a player to this SoccerTeam.
   *
   * @param player the player to be added
   */
  void addPlayer(PlayerInterface player);

  /**
   * Removes a player from this SoccerTeam.
   *
   * @param player the player to be removed
   */
  void removePlayer(PlayerInterface player);

  /**
   * Creates the team by assigning jersey numbers and setting the starting lineup and bench.
   */
  void createTeam();

  /**
   * Gets the list of all players in this SoccerTeam.
   *
   * @return the list of all players
   */
  String getListOfAllPlayers();

  /**
   * Gets the starting lineup of this SoccerTeam.
   *
   * @return the starting lineup
   */
  String getStartingLineup();

  /**
   * Gets the players on the bench of this SoccerTeam.
   *
   * @return the players on the bench
   */
  Map<PlayerPosition, List<PlayerInterface>> getBenchPlayers();

  /**
   * Sets the players on the bench of this SoccerTeam.
   */
  void setBench();

  /**
   * Assigns jersey numbers to all players in this SoccerTeam.
   */
  void setJerseyNumbers();

  /**
   * Assigns a jersey number to a specific player in this SoccerTeam.
   *
   * @param player the player to assign a jersey number
   */
  void assignJerseyNumber(PlayerInterface player);

  /**
   * Sets the starting lineup of this SoccerTeam.
   */
  void setStartingLineup();
}
