import java.time.LocalDate;
import java.time.Period;

/**
 * This class represents a U10 Soccer player. It implements the PlayerInterface and provides the
 * specific implementation of getPlayerFirstName, getPlayerLastName, getFullName,
 * getPlayerDateOfBirth, getPlayerPreferredPosition, setActualPosition, getActualPosition,
 * getPlayerSkillLevel methods, and a toString method.
 */
public class U10Player implements PlayerInterface {
  private final String firstName;
  private final String lastName;
  private final LocalDate dateOfBirth;
  private final PlayerPosition preferredPosition;
  private PlayerPosition actualPosition;
  private final int skillLevel;

  /**
   * Constructs a U10Player object using the given parameters.
   *
   * @param firstName         The first name of the player
   * @param lastName          The last name of the player
   * @param dateOfBirth       The date of birth of the player
   * @param preferredPosition The preferred position of the player
   * @param skillLevel        The skill level of the player, from 1 to 5
   * @throws IllegalArgumentException if first name or last name doesn't contain only English
   *                                  alphabet letters, if player age is 10 or above, or if the
   *                                  skill level is not between 1 and 5
   */
  public U10Player(String firstName, String lastName, LocalDate dateOfBirth,
      PlayerPosition preferredPosition, int skillLevel) throws IllegalArgumentException {
    if (firstName == null || lastName == null || dateOfBirth == null || preferredPosition == null) {
      throw new IllegalArgumentException("No parameter can be null");
    }
    // Validate first name, it should contain only English alphabet letters
    if (!firstName.matches("[A-Za-z]+")) {
      throw new IllegalArgumentException("First name must contain and only contain English alphabet letters");
    }
    // Validate last name, it should contain only English alphabet letters
    else if (!lastName.matches("[A-Za-z]+")) {
      throw new IllegalArgumentException("Last name must contain and only contain English alphabet letters");
    }
    // Validate age, it should be less than 10
    else if (Period.between(dateOfBirth, LocalDate.now()).getYears() >= 10) {
      throw new IllegalArgumentException("Invalid player age, the player should be under 10 years old");
    }
    // Validate skill level, it should be between 1 and 5
    else if (skillLevel >= 1 && skillLevel <= 5) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.dateOfBirth = dateOfBirth;
      this.preferredPosition = preferredPosition;
      this.skillLevel = skillLevel;
    } else {
      throw new IllegalArgumentException(
          "You enter an invalid skill level! Please enter a valid number between 1 and 5.");
    }
  }

  @Override public String getPlayerFirstName() {
    return this.firstName;
  }

  @Override public String getPlayerLastName() {
    return this.lastName;
  }

  @Override public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  @Override public LocalDate getPlayerDateOfBirth() {
    return this.dateOfBirth;
  }

  @Override public PlayerPosition getPlayerPreferredPosition() {
    return this.preferredPosition;
  }

  @Override public void setActualPosition(PlayerPosition position) {
    this.actualPosition = position;
  }

  @Override public PlayerPosition getActualPosition() {
    return this.actualPosition;
  }

  @Override public int getPlayerSkillLevel() {
    return this.skillLevel;
  }

  /**
   * Returns a string representation of the player, including first name, last name, date of birth,
   * actual position (or preferred if actual is not set), and skill level.
   *
   * @return A string representation of the player.
   */
  @Override
  public String toString() {
    // If actual position is not null, use it, else use preferred position
    String position =
        actualPosition != null ? actualPosition.toString() : preferredPosition.toString();

    return String.format(
        "Name: %-18s Date of Birth: %-13s Position: %-10s Skill Level: %s",
        getFullName(), this.dateOfBirth, position, this.skillLevel
    );
  }


}
