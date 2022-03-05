package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

  private String expectedTitle;
  private Author expectedAuthor;
  private Integer expectedYear;
  private Book testBook;
  private Book testBook2;

  @BeforeEach
  void setUp() throws Exception {
    expectedTitle = "goodBook";
    expectedAuthor = new Author("good", "author");
    expectedYear = 2021;
    testBook = new Book(expectedTitle, expectedAuthor, expectedYear);
  }

  @Test
  void testGetTitle() {
    assertEquals(expectedTitle, testBook.getTitle());
  }

  @Test
  void testGetCreator() {
    assertEquals(expectedAuthor, testBook.getCreator());
  }

  @Test
  void testGetYear() {
    assertEquals(expectedYear, testBook.getYear());
  }

  @Test
  void testEquals() {
    assertTrue(testBook.equals(testBook));
    assertFalse(testBook.equals(null));
    assertFalse(testBook.equals(expectedTitle));
  }

  @Test
  void testEquals2() {
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertTrue(testBook.equals(testBook2));

    expectedTitle = "goodBook2";
    expectedAuthor = new Author("good", "author");
    expectedYear = 2021;
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertFalse(testBook.equals(testBook2));

    expectedTitle = "goodBook";
    expectedAuthor = new Author("good2", "author");
    expectedYear = 2021;
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertFalse(testBook.equals(testBook2));

    expectedTitle = "goodBook";
    expectedAuthor = new Author("good", "author");
    expectedYear = 20212;
    testBook2 = new Book(expectedTitle, expectedAuthor, expectedYear);
    assertFalse(testBook.equals(testBook2));
  }

  @Test
  void testHashCode() {
    int hash = Objects.hash(expectedTitle, expectedAuthor, expectedYear);
    assertEquals(hash, testBook.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Item{" +
        "title='" + expectedTitle + '\'' +
        ", creator=" + expectedAuthor +
        ", year=" + expectedYear +
        '}';
    assertEquals(expectedString, testBook.toString());
  }
}