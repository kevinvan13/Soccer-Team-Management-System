import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * This class contains all the unit tests for the U10Player class.
 */
public class U10PlayerTest {

  private U10Player firstPlayer;
  private U10Player secondPlayer;

  /**
   * Setting up some objects of U10Player for testing.
   */
  @Before public void setUp() {
    firstPlayer = new U10Player("Robin", "Van", LocalDate.now().minus(Period.ofYears(9)),
        PlayerPosition.FORWARD, 3);
    secondPlayer = new U10Player("Wayne", "Rooney", LocalDate.now().minus(Period.ofYears(9)),
        PlayerPosition.GOALIE, 5);
  }

  /**
   * Test the constructor of U10Player.
   */
  @Test public void testConstructor() {
    U10Player thirdPlayer = new U10Player("Jimmy", "Butler",
        LocalDate.now().minus(Period.ofYears(9)), PlayerPosition.MIDFIELDER, 4);
    assertEquals("Jimmy", thirdPlayer.getPlayerFirstName());
    assertEquals("Butler", thirdPlayer.getPlayerLastName());
    assertEquals("Jimmy Butler", thirdPlayer.getFullName());
    assertEquals(LocalDate.now().minus(Period.ofYears(9)), thirdPlayer.getPlayerDateOfBirth());
    assertEquals(PlayerPosition.MIDFIELDER, thirdPlayer.getPlayerPreferredPosition());
    assertNull(thirdPlayer.getActualPosition());
    assertEquals(4, thirdPlayer.getPlayerSkillLevel());
  }

  /**
   * Test the exception to invalid first name for creating U10Player objects.
   */
  @Test(expected = IllegalArgumentException.class) public void testInvalidFirstName() {
    new U10Player("Robin123", "Van", LocalDate.now().minus(Period.ofYears(9)),
        PlayerPosition.FORWARD, 3);
  }

  /**
   * Test the exception to invalid last name for creating U10Player objects.
   */
  @Test(expected = IllegalArgumentException.class) public void testInvalidLastName() {
    new U10Player("Wayne", "Rooney456", LocalDate.now().minus(Period.ofYears(9)),
        PlayerPosition.GOALIE, 5);
  }

  /**
   * Test the exception to invalid date of birth for creating U10Player objects.
   */
  @Test(expected = IllegalArgumentException.class) public void testInvalidDateOfBirth() {
    new U10Player("Robin", "Van", LocalDate.now().minus(Period.ofYears(10)), PlayerPosition.FORWARD,
        3);
  }

  /**
   * Test the exception to invalid skill level for creating U10Player objects.
   */
  @Test(expected = IllegalArgumentException.class) public void testInvalidSkillLevel() {
    new U10Player("Robin", "Van", LocalDate.now().minus(Period.ofYears(9)), PlayerPosition.FORWARD,
        6);
    new U10Player("Wayne", "Rooney", LocalDate.now().minus(Period.ofYears(9)),
        PlayerPosition.GOALIE, 0);
  }

  /**
   * Test the setActualPosition and getActualPosition methods of U10Player.
   */
  @Test public void testSetAndGetActualPosition() {
    assertNull(firstPlayer.getActualPosition());
    firstPlayer.setActualPosition(PlayerPosition.DEFENDER);
    assertEquals(PlayerPosition.DEFENDER, firstPlayer.getActualPosition());
  }

  /**
   * Test the getPlayerFirstName method of U10Player.
   */
  @Test public void testGetPlayerFirstName() {
    assertEquals("Robin", firstPlayer.getPlayerFirstName());
    assertEquals("Wayne", secondPlayer.getPlayerFirstName());
  }

  /**
   * Test the getPlayerLastName method of U10Player.
   */
  @Test public void testGetPlayerLastName() {
    assertEquals("Van", firstPlayer.getPlayerLastName());
    assertEquals("Rooney", secondPlayer.getPlayerLastName());
  }

  /**
   * Test the getFullName method of U10Player.
   */
  @Test public void testGetFullName() {
    assertEquals("Robin Van", firstPlayer.getFullName());
    assertEquals("Wayne Rooney", secondPlayer.getFullName());
  }

  /**
   * Test the getPlayerDateOfBirth method of U10Player.
   */
  @Test public void testGetPlayerDateOfBirth() {
    assertEquals(LocalDate.now().minus(Period.ofYears(9)), firstPlayer.getPlayerDateOfBirth());
    assertEquals(LocalDate.now().minus(Period.ofYears(9)), secondPlayer.getPlayerDateOfBirth());
  }

  /**
   * Test the getPlayerPreferredPosition method of U10Player.
   */
  @Test public void testGetPlayerPreferredPosition() {
    assertEquals(PlayerPosition.FORWARD, firstPlayer.getPlayerPreferredPosition());
    assertEquals(PlayerPosition.GOALIE, secondPlayer.getPlayerPreferredPosition());
  }

  /**
   * Test the getPlayerSkillLevel method of U10Player.
   */
  @Test public void testGetPlayerSkillLevel() {
    assertEquals(3, firstPlayer.getPlayerSkillLevel());
    assertEquals(5, secondPlayer.getPlayerSkillLevel());
  }

  /**
   * Test the toString method of U10Player.
   */
  @Test public void testToString() {
    assertEquals("Robin       Van         " + LocalDate.now().minus(Period.ofYears(9))
        + "     FORWARD     3", firstPlayer.toString());
    assertEquals("Wayne       Rooney      " + LocalDate.now().minus(Period.ofYears(9))
        + "     GOALIE      5", secondPlayer.toString());
  }
}

