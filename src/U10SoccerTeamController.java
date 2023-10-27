import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

/**
 * This class represents the controller for a U10 Soccer Team. It manages the interactions between
 * the U10SoccerTeam model and the U10SoccerTeamView. The controller facilitates functionalities like
 * adding players to the team, displaying players, and other related operations.
 *
 * It contains members for the U10SoccerTeam model and the U10SoccerTeamView.
 */
public class U10SoccerTeamController {

  private U10SoccerTeam soccerTeam;
  private U10SoccerTeamView view;

  /**
   * Constructs a U10SoccerTeamController object, initializes the soccer team and its view.
   * Attaches listeners to various UI elements to provide interactivity.
   */
  public U10SoccerTeamController() {
    this.soccerTeam = new U10SoccerTeam();
    this.view = new U10SoccerTeamView();

    // Listener for Add Player button
    view.addAddPlayerListener(e -> {
      String firstName = view.getFirstName();
      String lastName = view.getLastName();
      String dobString = view.getDateOfBirth();
      PlayerPosition preferredPosition = view.getPosition();
      int skillLevel = view.getSkillLevel();

      try {
        LocalDate dateOfBirth = LocalDate.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE);
        String message = addPlayer(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
        if (!message.equals("Player added successfully!")) {
          view.showMessage(message); // This will display the error in a popup window
        } else {
          updateView();
          view.showMessage(message);
        }
        view.clearFields();
      } catch (DateTimeParseException ex) {
        view.showMessage("Invalid date format!");
      }
    });

    // Listener for Remove Player button
    view.addRemovePlayerListener(e -> {
      String firstName = view.getFirstName();
      String lastName = view.getLastName();
      String message = removePlayer(firstName, lastName);
      view.showMessage(message);
      updateView();
      view.clearFields();
    });

    // Listener for Create Team button
    view.addCreateTeamListener(e -> {
      String message = createTeam();
      view.showMessage(message);
      updateView();
    });

    updateView();
  }
  /**
   * Adds a player to the U10 soccer team based on the provided parameters.
   *
   * @param firstName The first name of the player.
   * @param lastName The last name of the player.
   * @param dateOfBirth The date of birth of the player.
   * @param preferredPosition The preferred position of the player on the field.
   * @param skillLevel The skill level of the player, usually between 1 to 5.
   * @return A string message indicating the result of the operation.
   */
  public String addPlayer(String firstName, String lastName, LocalDate dateOfBirth, PlayerPosition preferredPosition, int skillLevel) {
    try {
      U10Player player = new U10Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      soccerTeam.addPlayer(player);
      return "Player added successfully!";
    } catch (IllegalArgumentException e) {
      return e.getMessage();
    }
  }

  /**
   * Removes a player from the U10 soccer team based on the provided names.
   *
   * @param firstName The first name of the player.
   * @param lastName The last name of the player.
   * @return A string message indicating the result of the operation.
   */
  public String removePlayer(String firstName, String lastName) {
    PlayerInterface playerToRemove = findPlayer(firstName, lastName);
    if (playerToRemove != null) {
      try {
        soccerTeam.removePlayer(playerToRemove);
        return "Player removed successfully!";
      } catch (IllegalStateException e) {
        return e.getMessage();
      }
    } else {
      return "Player not found!";
    }
  }

  /**
   *
   * Creates the team lineup based on the players added.
   *
   * @return A string message indicating the result of the creation.
   */
  public String createTeam() {
    try {
      soccerTeam.createTeam();
      view.showStartingLineup();
      return "Team created successfully!";
    } catch (IllegalStateException e) {
      return e.getMessage();
    }
  }

  /**
   * Retrieves a list of all the players in the U10 soccer team.
   *
   * @return A string representation of all the players.
   */
  public String getListOfAllPlayers() {
    return soccerTeam.getListOfAllPlayers();
  }

  /**
   * Retrieves the starting lineup of the U10 soccer team.
   *
   * @return A string representation of the starting lineup.
   */
  public String getStartingLineup() {
    return soccerTeam.getStartingLineup();
  }

  /**
   * Finds a player in the U10 soccer team based on their first and last name.
   *
   * @param firstName The first name of the player.
   * @param lastName The last name of the player.
   * @return The player object that matches the provided names or null if not found.
   */
  private PlayerInterface findPlayer(String firstName, String lastName) {
    String fullName = firstName + " " + lastName;
    Map<PlayerPosition, List<PlayerInterface>> allPlayers = soccerTeam.getAllPlayers();
    for (Map.Entry<PlayerPosition, List<PlayerInterface>> entry : allPlayers.entrySet()) {
      for (PlayerInterface player : entry.getValue()) {
        if (player.getFullName().equals(fullName)) {
          return player;
        }
      }
    }
    return null;
  }

  /**
   * Updates the view with the latest team and lineup information.
   */
  private void updateView() {
    view.setRosterText(getListOfAllPlayers());
    view.setLineupText(getStartingLineup());
  }


}


