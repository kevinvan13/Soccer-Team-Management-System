import java.time.LocalDate;

/**
 * Soccer players are represented by their first name, last name, date of birth, preferred position,
 * skill level and actual position in the game.
 */
public interface PlayerInterface {
  /**
   * Gets the first name of this Player.
   *
   * @return the first name
   */
  String getPlayerFirstName();

  /**
   * Gets the last name of this Player.
   *
   * @return the last name
   */
  String getPlayerLastName();

  /**
   * Gets the full name of this Player.
   *
   * @return the full name
   */
  String getFullName();

  /**
   * Gets the date of birth of this Player.
   *
   * @return the date of birth
   */
  LocalDate getPlayerDateOfBirth();

  /**
   * Gets the preferred position of this Player.
   *
   * @return the preferred position
   */
  PlayerPosition getPlayerPreferredPosition();

  /**
   * Gets the skill level of this Player.
   *
   * @return the skill level
   */
  int getPlayerSkillLevel();

  /**
   * Sets the actual position of this Player in the game.
   *
   * @param position the position to be set
   */
  void setActualPosition(PlayerPosition position);

  /**
   * Gets the actual position of this Player in the game.
   *
   * @return the actual position
   */
  PlayerPosition getActualPosition();

}
