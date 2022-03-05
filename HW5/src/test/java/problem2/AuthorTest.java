package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorTest {

  private String expectedFirstName;
  private String expectedLastName;
  private Author testAuthor;
  private Author testAuthor2;

  @BeforeEach
  void setUp() throws Exception{
    expectedFirstName = "Felicity";
    expectedLastName = "Wang";
    testAuthor = new Author(expectedFirstName, expectedLastName);
  }

  @Test
  void getMembers() {
    String expectedName = expectedFirstName + " " + expectedLastName;
    assertEquals(expectedName, testAuthor.getName());
  }

  @Test
  void testEquals() {
    assertTrue(testAuthor.equals(testAuthor));
    assertFalse(testAuthor.equals(null));
    assertFalse(testAuthor.equals(expectedFirstName));
  }

  @Test
  void testEquals2() {
    testAuthor2 = new Author(expectedFirstName, expectedLastName);
    assertTrue(testAuthor.equals(testAuthor2));

    expectedFirstName = "NotFelicity";
    expectedLastName = "Wang";
    testAuthor2 = new Author(expectedFirstName, expectedLastName);
    assertFalse(testAuthor.equals(testAuthor2));

    expectedFirstName = "Felicity";
    expectedLastName = "NotWang";
    testAuthor2 = new Author(expectedFirstName, expectedLastName);
    assertFalse(testAuthor.equals(testAuthor2));
  }

  @Test
  void testHashCode() {
    int hash = Objects.hash(expectedFirstName, expectedLastName);
    assertEquals(hash, testAuthor.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Person{" +
        "firstName='" + expectedFirstName + '\'' +
        ", lastName='" + expectedLastName + '\'' +
        '}';
    assertEquals(expectedString, testAuthor.toString());
  }
}