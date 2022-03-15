package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsBagOfWordsTest {

  private String expectedHead;
  private String expectedHead2;
  private BagOfWords expectedRest;
  private BagOfWords expectedRest2;
  private BagOfWords testConsBagOfWords;
  private BagOfWords testConsBagOfWords2;

  @BeforeEach
  void setUp() throws Exception{
    expectedHead = "a";
    expectedRest = BagOfWords.emptyBagOfWords();
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
  }

  @Test
  void isEmpty() {
    assertFalse(testConsBagOfWords.isEmpty());
  }

  @Test
  void size() {
    assertEquals((Integer)1, testConsBagOfWords.size());
  }

  @Test
  void contains() {
    assertTrue(testConsBagOfWords.contains(expectedHead));
    assertFalse(testConsBagOfWords.contains("b"));
  }

  @Test
  void removeElement() {
    testConsBagOfWords = testConsBagOfWords.add("a");
    testConsBagOfWords = testConsBagOfWords.add("b");
    testConsBagOfWords = testConsBagOfWords.add("c");
    testConsBagOfWords = testConsBagOfWords.remove("a");
    testConsBagOfWords = testConsBagOfWords.remove("b");
    testConsBagOfWords = testConsBagOfWords.remove("c");
    assertEquals(expectedRest, testConsBagOfWords.remove(expectedHead));
  }

  @Test
  void testEquals() {
    assertTrue(testConsBagOfWords.equals(testConsBagOfWords));
    assertFalse(testConsBagOfWords.equals(null));
    assertFalse(testConsBagOfWords.equals(expectedHead));

    testConsBagOfWords2 = new ConsBagOfWords(expectedHead, expectedRest);
    assertTrue(testConsBagOfWords.equals(testConsBagOfWords2));

    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    expectedHead2 = "b";
    expectedRest2 = BagOfWords.emptyBagOfWords();
    testConsBagOfWords2 = new ConsBagOfWords(expectedHead2, expectedRest2);
    assertFalse(testConsBagOfWords2.equals(testConsBagOfWords));

    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    expectedHead2 = "a";
    expectedRest2 = testConsBagOfWords;
    testConsBagOfWords2 = new ConsBagOfWords(expectedHead2, expectedRest2);
    assertFalse(testConsBagOfWords2.equals(testConsBagOfWords));
  }

  @Test
  void testHashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = null;
    expectedRest = BagOfWords.emptyBagOfWords();
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = "a";
    expectedRest = null;
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = "b";
    expectedRest = BagOfWords.emptyBagOfWords();
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());

    result = 1;
    expectedHead = "a";
    expectedRest = testConsBagOfWords;
    testConsBagOfWords = new ConsBagOfWords(expectedHead, expectedRest);
    result = (prime * result) + ((expectedHead == null) ? 0 : expectedHead.hashCode());
    result = (prime * result) + ((expectedRest == null) ? 0 : expectedRest.hashCode());
    assertEquals(result, testConsBagOfWords.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "ConsBagOfWords{" +
        "head='" + expectedHead + '\'' +
        ", rest=" + expectedRest +
        '}';
    assertEquals(expectedString, testConsBagOfWords.toString());
  }
}