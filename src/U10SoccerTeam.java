import java.util.*;
import java.util.stream.Collectors;

/**
 * This class represents a U10 Soccer team. It implements the SoccerTeamInterface and provides the
 * specific implementation of addPlayer, removePlayer, createTeam, getListOfAllPlayers,
 * getStartingLineup, getBenchPlayers, setBench, setJerseyNumbers, assignJerseyNumber, and
 * setStartingLineup methods.
 * <p>
 * It maintains separate lists of all players, the starting lineup, and the bench, as well as maps
 * of jersey numbers for each player.
 */
public class U10SoccerTeam implements SoccerTeamInterface {
  // Player storage maps, categorized by their positions
  private Map<PlayerPosition, List<PlayerInterface>> players = new HashMap<>();
  private Map<PlayerPosition, List<PlayerInterface>> startingLineup = new HashMap<>();
  private Map<PlayerPosition, List<PlayerInterface>> bench = new HashMap<>();
  // Jersey number management
  private Map<String, Integer> jerseyNumbers = new HashMap<>();
  private Set<Integer> availableJerseyNumbers = new HashSet<>();

  // Indicates if the team has been created
  public boolean isTeamCreated = false;

  /**
   * Constructs a U10SoccerTeam object. Initializes the lists and maps, and pre-fills the available
   * jersey numbers.
   */
  public U10SoccerTeam() {
    for (int i = 1; i <= 20; i++) {
      availableJerseyNumbers.add(i); // Populates jersey number set
    }
    for (PlayerPosition position : PlayerPosition.values()) {
      players.put(position, new ArrayList<>());
      startingLineup.put(position, new ArrayList<>());
      bench.put(position, new ArrayList<>());
    }
  }

  @Override public void addPlayer(PlayerInterface player) throws IllegalArgumentException{
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    // Check if the player with the same full name already exists
    boolean playerExists = players.values().stream()
        .flatMap(List::stream)
        .anyMatch(existingPlayer -> existingPlayer.getFullName().equals(player.getFullName()));

    if (playerExists) {
      throw new IllegalArgumentException("A player with the same first and last name already exists in the team.");
    }

    PlayerPosition position = player.getPlayerPreferredPosition();
    this.players.get(position).add(player); // Adds player to the player list
    int totalPlayers = players.values().stream().mapToInt(List::size).sum();
    if (this.isTeamCreated && totalPlayers >= 20) {
      // Sort all players by skill level
      List<PlayerInterface> allPlayersSorted = players.values().stream().flatMap(List::stream)
          .sorted(Comparator.comparingInt(PlayerInterface::getPlayerSkillLevel))
          .collect(Collectors.toList());

      // Remove player with the lowest skill level
      PlayerInterface playerToRemove = allPlayersSorted.get(0);

      // Add back jersey number
      PlayerPosition removedPlayerPosition = playerToRemove.getPlayerPreferredPosition();
      this.players.get(removedPlayerPosition).remove(playerToRemove);
      availableJerseyNumbers.add(jerseyNumbers.remove(playerToRemove.getFullName()));

      // Prevents assigning jersey number to the same removed player
      if (playerToRemove.getFullName().equals(player.getFullName())) {
        return;
      } else {
        assignJerseyNumber(player);
      }
    }
    else if (this.isTeamCreated) {
      assignJerseyNumber(player);
    }
    // Updates lineup and bench after player addition
    this.setStartingLineup();
    this.setBench();
  }

  @Override public void removePlayer(PlayerInterface player) {
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    int totalPlayers = players.values().stream().mapToInt(List::size).sum();
    // Checks for minimum player count
    if (totalPlayers == 10) {
      throw new IllegalStateException(
          "Removing the player would cause the team have less than 10 players!\n");
    }

    PlayerPosition position = player.getPlayerPreferredPosition();
    this.players.get(position).remove(player);
    this.startingLineup.get(position).remove(player);
    this.bench.get(position).remove(player);
    this.availableJerseyNumbers.add(this.jerseyNumbers.remove(player.getFullName()));
    this.setStartingLineup();
    this.setBench();
  }

  @Override public void createTeam() {
    int totalPlayers = players.values().stream().mapToInt(List::size).sum();

    // Ensures minimum and maximum player count
    if (totalPlayers < 10) {
      int numPlayersLeft = 10 - totalPlayers;
      throw new IllegalStateException(
          "The team must have a minimum of 10 players!\n Please add " + numPlayersLeft
              + " more players!");
    }

    if (totalPlayers > 20) {
      // Remove surplus players according to players with least skill level
      List<PlayerInterface> allPlayersSorted = players.values().stream().flatMap(List::stream)
          .sorted(Comparator.comparingInt(PlayerInterface::getPlayerSkillLevel))
          .collect(Collectors.toList());

      List<PlayerInterface> playersToRemove = allPlayersSorted.subList(0, totalPlayers - 20);

      for (PlayerInterface player : playersToRemove) {
        PlayerPosition position = player.getPlayerPreferredPosition();
        this.players.get(position).remove(player);
      }
    }

    // Setup jerseys, lineups, and bench
    this.setJerseyNumbers();
    this.setStartingLineup();
    this.setBench();
    this.isTeamCreated = true;
  }

  public Map<PlayerPosition, List<PlayerInterface>> getAllPlayers() {
    return players;
  }

  @Override public String getListOfAllPlayers() {
    // Collect all players into one list
    List<PlayerInterface> allPlayers = new ArrayList<>();
    for (PlayerPosition position : PlayerPosition.values()) {
      allPlayers.addAll(this.players.get(position));
    }

    // Sort the list of all players by last name
    allPlayers.sort(Comparator.comparing(PlayerInterface::getPlayerLastName));

    // Generate the output
    StringBuilder sb = new StringBuilder();
    for (PlayerInterface player : allPlayers) {
      sb.append(player.toString()).append("   Jersey number: ")
          .append(jerseyNumbers.get(player.getFullName())).append("\n");
    }

    return sb.toString();
  }

  @Override public String getStartingLineup() {
    StringBuilder sb = new StringBuilder();
    for (PlayerPosition position : PlayerPosition.values()) {
      List<PlayerInterface> playersInPosition = new ArrayList<>(this.startingLineup.get(position));
      // Sort by last name for same position player
      playersInPosition.sort(Comparator.comparing(PlayerInterface::getPlayerLastName));
      for (PlayerInterface player : playersInPosition) {
        sb.append(player.toString()).append("   Jersey number: ")
            .append(jerseyNumbers.get(player.getFullName())).append("\n");
      }
    }
    return sb.toString();
  }

  @Override public Map<PlayerPosition, List<PlayerInterface>> getBenchPlayers() {
    return bench;
  }

  @Override public void setBench() {
    for (PlayerPosition position : PlayerPosition.values()) {
      bench.get(position).clear();
      bench.get(position).addAll(players.get(position)); // Add all players to bench
      bench.get(position)
          .removeAll(startingLineup.get(position)); // Remove players in starting lineup from bench
    }
  }

  @Override public void setJerseyNumbers() {
    for (PlayerPosition position : PlayerPosition.values()) {
      for (PlayerInterface player : this.players.get(position)) {
        assignJerseyNumber(player);
      }
    }
  }

  @Override public void assignJerseyNumber(PlayerInterface player) {
    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }
    String fullName = player.getFullName();
    if (this.jerseyNumbers.containsKey(fullName)) {
      throw new IllegalStateException("Player already has a jersey number assigned");
    } else {
      Iterator<Integer> it = this.availableJerseyNumbers.iterator();
      int number = it.next(); // Get first available jersey number
      it.remove(); // Remove it from available jersey numbers
      this.jerseyNumbers.put(fullName, number); // Assign it to player
    }
  }

  @Override public void setStartingLineup() {
    clearStartingLineup();
    populateStartingLineup(); // Populate starting lineup based on players' preferred positions and skill levels
    fillRemainingPositions(); // Fill any remaining positions with highest skill level players
  }

  /**
   * Clears the starting lineup for the team.
   */
  private void clearStartingLineup() {
    for (PlayerPosition position : PlayerPosition.values()) {
      startingLineup.get(position).clear();
    }
  }

  /**
   * Populates the starting lineup with players according to their preferred positions. The players
   * with the highest skill levels are chosen for each position.
   */
  private void populateStartingLineup() {
    Map<PlayerPosition, Integer> startingCount = getStartingCount(); // Get required number of players for each position

    for (PlayerPosition position : PlayerPosition.values()) {
      List<PlayerInterface> playersInPosition = getSortedPlayersByPosition(
          position); // Get sorted list of players for position

      int count = startingCount.get(position);
      for (int i = 0; i < count && i < playersInPosition.size(); i++) {
        U10Player player = (U10Player) playersInPosition.get(i);  // cast to U10Player
        player.setActualPosition(position);  // set the actual position
        startingLineup.get(position).add(player); // Add player to starting lineup
      }
    }
  }

  /**
   * Returns the map with the required number of players for each position in the starting lineup.
   *
   * @return A map with player positions as keys and the required number of players for each
   * position as values.
   */
  private Map<PlayerPosition, Integer> getStartingCount() {
    Map<PlayerPosition, Integer> startingCount = new HashMap<>();
    // The number of players for each position for the starting lineup
    startingCount.put(PlayerPosition.GOALIE, 1);
    startingCount.put(PlayerPosition.DEFENDER, 2);
    startingCount.put(PlayerPosition.MIDFIELDER, 3);
    startingCount.put(PlayerPosition.FORWARD, 1);

    return startingCount;
  }

  /**
   * Returns the list of players for a given position, sorted by skill level in descending order.
   *
   * @param position The position to get the players for
   * @return A list of players for the given position, sorted by skill level in descending order
   */
  private List<PlayerInterface> getSortedPlayersByPosition(PlayerPosition position) {
    List<PlayerInterface> playersInPosition = new ArrayList<>(players.get(position));
    // Sort players by skill level in descending order
    playersInPosition.sort(
        Comparator.comparingInt(PlayerInterface::getPlayerSkillLevel).reversed());

    return playersInPosition;
  }

  /**
   * Fills the remaining positions in the starting lineup with the players of highest skill level.
   */
  private void fillRemainingPositions() {
    // Check if all positions in starting lineup are filled
    boolean isLineupFull = isStartingLineupFull();

    // If not, fill the remaining positions with the highest skill level players
    if (!isLineupFull) {
      List<PlayerInterface> allPlayers = getSortedAllPlayers();
      fillUnoccupiedPositions(allPlayers);
    }
  }

  /**
   * Checks if all positions in the starting lineup are filled.
   *
   * @return true if all positions in the starting lineup are filled, false otherwise
   */
  private boolean isStartingLineupFull() {
    Map<PlayerPosition, Integer> startingCount = getStartingCount();

    // Check if all positions in the lineup are filled to the required count
    return startingLineup.values().stream().allMatch(
        playersList -> !playersList.isEmpty() && playersList.size() == startingCount.get(
            playersList.get(0).getPlayerPreferredPosition()));
  }

  /**
   * Returns the list of all players, sorted by skill level in descending order.
   *
   * @return A list of all players, sorted by skill level in descending order
   */
  private List<PlayerInterface> getSortedAllPlayers() {
    // Flatten the list of players, sort them by skill level in descending order, and collect into a list
    return players.values().stream().flatMap(List::stream)
        .sorted(Comparator.comparingInt(PlayerInterface::getPlayerSkillLevel).reversed())
        .collect(Collectors.toList());
  }

  /**
   * Fills the unoccupied positions in the starting lineup with the players from the given list.
   *
   * @param allPlayers The list of all players
   */
  private void fillUnoccupiedPositions(List<PlayerInterface> allPlayers) {
    Map<PlayerPosition, Integer> startingCount = getStartingCount();// Get the required count for each position in the starting lineup
    // Iterate over all players
    for (PlayerInterface player : allPlayers) {
      // Check if the player is not already in the lineup
      if (startingLineup.values().stream().flatMap(List::stream)
          .noneMatch(p -> p.getFullName().equals(player.getFullName()))) {
        // Iterate over all positions
        for (PlayerPosition position : PlayerPosition.values()) {
          // If the current position in the lineup has less than the required count, add the player to it
          if (startingLineup.get(position).size() < startingCount.get(position)) {
            U10Player u10Player = (U10Player) player;
            u10Player.setActualPosition(position); // Set the player's actual position
            startingLineup.get(position).add(u10Player); // Add the player to the lineup
            break; // Break the loop as the player has been added
          }
        }
      }
    }
  }

}


