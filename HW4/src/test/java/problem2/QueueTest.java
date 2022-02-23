package problem2;

import static org.junit.jupiter.api.Assertions.*;

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
  }

  @Test
  void contains() {
  }

  @Test
  void remove() {
  }

  @Test
  void removeElement() {
  }

  @Test
  void size() {
  }

  @Test
  void testEquals() {
  }

  @Test
  void testHashCode() {
  }

  @Test
  void testToString() {
  }
}