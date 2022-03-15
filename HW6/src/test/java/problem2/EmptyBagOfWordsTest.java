package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyBagOfWordsTest {

  private BagOfWords testEmptyBagOfWords;
  private BagOfWords testEmptyBagOfWords2;
  private String expectedString;

  @BeforeEach
  void setUp() throws Exception{
    expectedString = "a";
    testEmptyBagOfWords = BagOfWords.emptyBagOfWords();
  }

  @Test
  void isEmpty() {
    assertTrue(testEmptyBagOfWords.isEmpty());
  }

  @Test
  void size() {
    assertEquals((Integer) 0, testEmptyBagOfWords.size());
  }

  @Test
  void contains() {
    assertFalse(testEmptyBagOfWords.contains(expectedString));
  }

  @Test
  void removeElement() {
    assertEquals(testEmptyBagOfWords, testEmptyBagOfWords.remove(expectedString));
  }

  @Test
  void testEquals() {
    assertTrue(testEmptyBagOfWords.equals(testEmptyBagOfWords));
    assertFalse(testEmptyBagOfWords.equals(null));
    assertFalse(testEmptyBagOfWords.equals(0));
    testEmptyBagOfWords2 = BagOfWords.emptyBagOfWords();
    assertTrue(testEmptyBagOfWords.equals(testEmptyBagOfWords2));
  }

  @Test
  void testHashCode() {
    assertEquals(41, testEmptyBagOfWords.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "{ }";
    assertEquals(expectedString, testEmptyBagOfWords.toString());
  }
}