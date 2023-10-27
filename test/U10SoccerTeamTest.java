import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;


/**
 * This class contains all the unit tests for the U10SoccerTeam class.
 */
public class U10SoccerTeamTest {
  private U10SoccerTeam team;
  private U10Player player1;
  private U10Player player2;
  private U10Player player3;
  private U10Player player4;
  private U10Player player5;
  private U10Player player6;
  private U10Player player7;
  private U10Player player8;
  private U10Player player9;
  private U10Player player10;
  private U10Player player11;
  private U10Player player12;
  private U10Player player13;
  private U10Player player14;
  private U10Player player15;
  private U10Player player16;
  private U10Player player17;
  private U10Player player18;
  private U10Player player19;
  private U10Player player20;
  private U10Player player21;
  private U10Player player22;


  /**
   * This method sets up the U10SoccerTeam and U10Player objects needed for testing.
   */
  @Before
  public void setUp() {
    team = new U10SoccerTeam();

    player1 = new U10Player("David", "DeGea", LocalDate.of(2016, 1, 1), PlayerPosition.GOALIE, 4);
    player2 = new U10Player("Vincent", "Kompany", LocalDate.of(2015, 1, 1), PlayerPosition.DEFENDER, 3);
    player3 = new U10Player("John", "Terry", LocalDate.of(2014, 1, 1), PlayerPosition.DEFENDER, 5);
    player4 = new U10Player("Frank", "Lampard", LocalDate.of(2015, 1, 1), PlayerPosition.MIDFIELDER, 4);
    player5 = new U10Player("Paul", "Scholes", LocalDate.of(2014, 1, 1), PlayerPosition.MIDFIELDER, 2);
    player6 = new U10Player("Steven", "Gerrard", LocalDate.of(2016, 1, 1), PlayerPosition.MIDFIELDER, 5);
    player7 = new U10Player("David", "Beckham", LocalDate.of(2015, 1, 1), PlayerPosition.FORWARD, 3);
    player8 = new U10Player("Michael", "Owen", LocalDate.of(2016, 1, 1), PlayerPosition.FORWARD, 4);
    player9 = new U10Player("Gary", "Neville", LocalDate.of(2016, 1, 1), PlayerPosition.DEFENDER, 2);
    player10 = new U10Player("Ryan", "Giggs", LocalDate.of(2016, 1, 1), PlayerPosition.MIDFIELDER, 1);
    player11 = new U10Player("Peter", "Schmeichel", LocalDate.of(2016, 1, 1), PlayerPosition.GOALIE, 3);
    player12 = new U10Player("Rio", "Ferdinand", LocalDate.of(2016, 1, 1), PlayerPosition.DEFENDER, 2);
    player13 = new U10Player("Roy", "Keane", LocalDate.of(2016, 1, 1), PlayerPosition.MIDFIELDER, 2);
    player14 = new U10Player("Wayne", "Rooney", LocalDate.of(2016, 1, 1), PlayerPosition.FORWARD, 4);
    player15 = new U10Player("Luka", "Modric", LocalDate.of(2016, 1, 1), PlayerPosition.MIDFIELDER, 2);
    player16 = new U10Player("Jamie", "Carragher", LocalDate.of(2016, 1, 1), PlayerPosition.DEFENDER, 5);
    player17 = new U10Player("Phil", "Neville", LocalDate.of(2016, 1, 1), PlayerPosition.MIDFIELDER, 2);
    player18 = new U10Player("Harry", "Kane", LocalDate.of(2016, 1, 1), PlayerPosition.FORWARD, 3);
    player19 = new U10Player("Ashley", "Cole", LocalDate.of(2016, 1, 1), PlayerPosition.DEFENDER, 4);
    player20 = new U10Player("David", "Silva", LocalDate.of(2016, 1, 1), PlayerPosition.MIDFIELDER, 5);
    player21 = new U10Player("Robin", "VanPersie", LocalDate.of(2016, 1, 1), PlayerPosition.FORWARD, 5);
    player22 = new U10Player("David", "DeGea", LocalDate.of(2016, 1, 1), PlayerPosition.GOALIE, 4);
  }

  /**
   * This method tests the addPlayer method of U10SoccerTeam class.
   */
  @Test
  public void testAddPlayer() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);

    team.createTeam();
    String playerList = team.getListOfAllPlayers();
    assertTrue(playerList.contains(player1.toString()));
    assertTrue(playerList.contains(player2.toString()));
    assertTrue(playerList.contains(player3.toString()));
    assertTrue(playerList.contains(player4.toString()));
    assertTrue(playerList.contains(player5.toString()));
    assertTrue(playerList.contains(player6.toString()));
    assertTrue(playerList.contains(player7.toString()));
    assertTrue(playerList.contains(player8.toString()));
    assertTrue(playerList.contains(player9.toString()));
    assertTrue(playerList.contains(player10.toString()));
    assertTrue(playerList.contains(player11.toString()));

  }

  /**
   * This method tests the removePlayer method of U10SoccerTeam class.
   */
  @Test
  public void testRemovePlayer() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);

    team.removePlayer(player2);
    String playerList = team.getListOfAllPlayers();
    assertFalse(playerList.contains(player2.getFullName()));
  }

  /**
   * This method tests the removePlayer method of U10SoccerTeam class when the team size is small.
   */
  @Test(expected = IllegalStateException.class)
  public void testRemovePlayerFromSmallTeam() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);

    team.createTeam();
    team.removePlayer(player2);
  }

  /**
   * This method tests the createTeam method of U10SoccerTeam class.
   */
  @Test
  public void testCreateTeam() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);

    team.createTeam();
    assertTrue(team.isTeamCreated);
  }

  /**
   * This method tests the createTeam method of U10SoccerTeam class when the team size is small.
   */
  @Test(expected = IllegalStateException.class)
  public void testCreateSmallTeam() {
    team.addPlayer(player1);
    team.addPlayer(player2);

    team.createTeam();
  }

  /**
   * This method tests the getListOfAllPlayers method of U10SoccerTeam class.
   */
  @Test
  public void testGetListOfAllPlayers() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);

    team.createTeam();
    String playerList = team.getListOfAllPlayers();
    assertTrue(playerList.contains(player1.toString()));
    assertTrue(playerList.contains(player2.toString()));
    assertTrue(playerList.contains(player3.toString()));
    assertTrue(playerList.contains(player4.toString()));
    assertTrue(playerList.contains(player5.toString()));
    assertTrue(playerList.contains(player6.toString()));
    assertTrue(playerList.contains(player7.toString()));
    assertTrue(playerList.contains(player8.toString()));
    assertTrue(playerList.contains(player9.toString()));
    assertTrue(playerList.contains(player10.toString()));
    assertTrue(playerList.contains(player11.toString()));
  }

  /**
   * This method tests the getStartingLineup method of U10SoccerTeam class.
   */
  @Test
  public void testGetStartingLineup() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);

    team.createTeam();

    String lineup = team.getStartingLineup();
    assertTrue(lineup.contains(player1.toString()));
    assertTrue(lineup.contains(player2.toString()));
    assertTrue(lineup.contains(player3.toString()));
    assertTrue(lineup.contains(player4.toString()));
    assertTrue(lineup.contains(player5.toString()));
    assertTrue(lineup.contains(player6.toString()));
    assertTrue(lineup.contains(player8.toString()));

  }

  /**
   * This method tests the getBenchPlayers method of U10SoccerTeam class.
   */
  @Test
  public void testGetBenchPlayers() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);

    team.createTeam();

    Map<PlayerPosition, List<PlayerInterface>> bench = team.getBenchPlayers();
    assertTrue(bench.values().stream().anyMatch(players -> players.stream().anyMatch(player -> player.getFullName().equals(player7.getFullName()))));
    assertTrue(bench.values().stream().anyMatch(players -> players.stream().anyMatch(player -> player.getFullName().equals(player9.getFullName()))));
    assertTrue(bench.values().stream().anyMatch(players -> players.stream().anyMatch(player -> player.getFullName().equals(player10.getFullName()))));
    assertTrue(bench.values().stream().anyMatch(players -> players.stream().anyMatch(player -> player.getFullName().equals(player11.getFullName()))));
  }

  /**
   * This method tests the createTeam method of U10SoccerTeam class when the team size is large.
   */
  @Test
  public void testCreateLargeTeam() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    team.addPlayer(player16);
    team.addPlayer(player17);
    team.addPlayer(player18);
    team.addPlayer(player19);
    team.addPlayer(player20);
    team.addPlayer(player21);

    team.createTeam();

    String playerList = team.getListOfAllPlayers();
    // There are 21 players so player 10, with the least skill level is omitted
    assertFalse(playerList.contains(player10.toString()));
  }

  /**
   * This method tests the addPlayer method of U10SoccerTeam class when we add a player whose full name are the same as a player in the team.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerSameNameFailed() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    team.addPlayer(player16);
    team.addPlayer(player17);
    team.addPlayer(player18);
    team.addPlayer(player19);
    team.addPlayer(player20);
    team.addPlayer(player21);

    team.createTeam();
    team.addPlayer(player22);

  }

  /**
   * This method tests the addPlayer method of U10SoccerTeam class when the team size is large and the addition should fail.
   */
  @Test
  public void testAddPlayerLargeTeamFailed() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    team.addPlayer(player16);
    team.addPlayer(player17);
    team.addPlayer(player18);
    team.addPlayer(player19);
    team.addPlayer(player20);
    team.addPlayer(player21);

    team.createTeam();
    team.addPlayer(player10);

    String playerList = team.getListOfAllPlayers();
    // There are 20 players so even try to add player 10, with the least skill level, he won't be added
    assertFalse(playerList.contains(player10.toString()));
  }

  /**
   * This method tests the addPlayer method of U10SoccerTeam class when the team size is large and the addition should succeed.
   */
  @Test
  public void testAddPlayerLargeTeamSuccess() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    team.addPlayer(player16);
    team.addPlayer(player17);
    team.addPlayer(player18);
    team.addPlayer(player19);
    team.addPlayer(player20);

    team.createTeam();
    team.addPlayer(player21);

    String playerList = team.getListOfAllPlayers();
    // There are 20 players so adding player 21 will omit player 10, with the least skill level
    assertTrue(playerList.contains(player21.toString()));
    assertFalse(playerList.contains(player10.toString()));
  }

  /**
   * This method tests the getListOfAllPlayer method that whether the list of all the players in the team is sorted alphabetically.
   */
  @Test
  public void testGetListOfAllPlayersSorted() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    team.addPlayer(player16);
    team.addPlayer(player17);
    team.addPlayer(player18);
    team.addPlayer(player19);
    team.addPlayer(player20);
    team.addPlayer(player21);

    team.createTeam();

    // Get list of all players in string format
    String allPlayersList = team.getListOfAllPlayers();

    // Convert the string back to a list of player names
    List<String> allPlayerNames = Arrays.stream(allPlayersList.split("\n"))
        .map(line -> line.split(",")[0]) // Get the player name part
        .collect(Collectors.toList());

    // Create a sorted version of the list
    List<String> sortedPlayerNames = allPlayerNames.stream()
        .sorted(Comparator.comparing(name -> name.split("\\s+")[1])) // sort by last name
        .collect(Collectors.toList());

    // Check if the original list is the same as the sorted list
    assertEquals(sortedPlayerNames, allPlayerNames);
  }

  /**
   * This method tests the getStartingLineup method that whether the list of the team's starting lineup is sorted by position (and alphabetically for the same position).
   */
  @Test
  public void testStartingLineupSorted() {
    // Add all players to the team
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);
    team.addPlayer(player11);
    team.addPlayer(player12);
    team.addPlayer(player13);
    team.addPlayer(player14);
    team.addPlayer(player15);
    team.addPlayer(player16);
    team.addPlayer(player17);
    team.addPlayer(player18);
    team.addPlayer(player19);
    team.addPlayer(player20);
    team.addPlayer(player21);

    team.createTeam();

    // Get the starting lineup in string format
    String startingLineup = team.getStartingLineup();

    // Convert the string back to a list of player names
    List<String> startingPlayerNames = Arrays.stream(startingLineup.split("\n"))
        .map(line -> line.split(",")[0]) // Get the player name part
        .collect(Collectors.toList());

    // Create a mapping of positions to a specific order
    Map<String, Integer> positionOrder = new HashMap<>();
    positionOrder.put("GOALIE", 1);
    positionOrder.put("DEFENDER", 2);
    positionOrder.put("MIDFIELDER", 3);
    positionOrder.put("FORWARD", 4);

    // Create a sorted version of the list, first by position, then by last name
    List<String> sortedStartingPlayerNames = startingPlayerNames.stream()
        .sorted((name1, name2) -> {
          String position1 = name1.split("\\s+")[3]; // Extract position from name string
          String position2 = name2.split("\\s+")[3];

          String lastName1 = name1.split("\\s+")[1]; // Extract last name from name string
          String lastName2 = name2.split("\\s+")[1];

          // Compare positions first
          int positionComparison = positionOrder.get(position1).compareTo(positionOrder.get(position2));
          if (positionComparison != 0) {
            return positionComparison;
          } else {
            // If positions are the same, compare last names
            return lastName1.compareTo(lastName2);
          }
        })
        .collect(Collectors.toList());

    // Check if the original list is the same as the sorted list
    assertEquals(sortedStartingPlayerNames, startingPlayerNames);
  }



}

