package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
  private Integer expectedItem;
  private Queue testQueue;
  private Queue testQueue2;

  @BeforeEach
  void setUp() {
    expectedItem = 1;
    testQueue = new Queue();
    testQueue2 = new Queue();
  }

  @Test
  void emptyQueue() {
    testQueue2 = testQueue.emptyQueue();
    assertTrue(testQueue2.isEmpty());
  }

  @Test
  void isEmpty() {
    assertTrue(testQueue.isEmpty());
    testQueue = testQueue.add(2);
    assertFalse(testQueue.isEmpty());
  }

  @Test
  void add() {
    testQueue = testQueue.add(2);
    testQueue = testQueue.add(2);
    testQueue = testQueue.add(3);
    assertFalse(testQueue.isEmpty());
    assertTrue(testQueue.contains(2));
    assertTrue(testQueue.contains(3));
  }

  @Test
  void contains() {
    assertTrue(testQueue.equals(testQueue));
    testQueue = testQueue.add(1);
    assertTrue(testQueue.contains(1));
  }

  @Test
  void remove() {
//    testQueue = testQueue.remove();
    assertFalse(testQueue.contains(1));
    assertFalse(testQueue.contains(0));
  }

  @Test
  void removeElement() {
    testQueue = testQueue.add(2);
    testQueue = testQueue.add(3);
    testQueue = testQueue.removeElement(4);
    testQueue = testQueue.removeElement(2);
    testQueue = testQueue.removeElement(3);
    assertTrue(testQueue.isEmpty());
  }

  @Test
  void size() {
    Integer i = 0;
    assertEquals(i, testQueue.size());
    i++;
    testQueue = testQueue.add(3);
    assertEquals(i, testQueue.size());
  }

  @Test
  void testEquals1() {
    assertTrue(testQueue.equals(testQueue));

    assertFalse(testQueue.equals(null));

    testQueue = testQueue.add(1);
    testQueue2 = testQueue2.add(1);
    assertTrue(testQueue.equals(testQueue2));

    testQueue2 = testQueue2.add(2);
    assertFalse(testQueue.equals(testQueue2));
  }

  @Test
  void testEquals2() {
    testQueue = testQueue.add(1);
    assertFalse(testQueue.equals(1));

    testQueue2 = testQueue2.add(2);
    assertFalse(testQueue.equals(testQueue2));

    testQueue2 = testQueue2.add(3);
    assertFalse(testQueue.equals(testQueue2));
  }

  @Test
  void testHashCode() {
    testQueue = testQueue.add(1);
    Integer[] a = new Integer[1];
    a[0] = 1;
    int result = Objects.hash(1);
    result = 31 * result + Arrays.hashCode(a);
    assertEquals(result, testQueue.hashCode());
  }

  @Test
  void testToString() {
    testQueue = testQueue.add(1);
    Integer[] a = new Integer[1];
    a[0] = 1;
    String expectedString = "Queue{" +
        "items=" + Arrays.toString(a) +
        ", totalLength=" + 1 +
        '}';
  }
}