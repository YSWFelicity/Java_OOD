package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyPriorityQueueTest {

  private PriorityQueue testEmptyPriorityQueue;
  private PriorityQueue testEmptyPriorityQueue2;

  @BeforeEach
  void setUp() throws Exception{
    testEmptyPriorityQueue = new EmptyPriorityQueue();
  }

  @Test
  void isEmpty() {
    assertTrue(testEmptyPriorityQueue.isEmpty());
  }

  @Test
  void peek() {
    InvalidCallException thrown = Assertions.assertThrows(InvalidCallException.class, () -> {
      testEmptyPriorityQueue.peek();
    }, "Invalid Call Exception");

    Assertions.assertEquals("Call peek() on an empty PriorityQueue", thrown.getMessage());
  }

  @Test
  void pop() {
    InvalidCallException thrown = Assertions.assertThrows(InvalidCallException.class, () -> {
      testEmptyPriorityQueue.pop();
    }, "Invalid Call Exception");

    Assertions.assertEquals("Call pop() on an empty PriorityQueue", thrown.getMessage());
  }


  @Test
  void testEquals() {
    assertTrue(testEmptyPriorityQueue.equals(testEmptyPriorityQueue));
    assertFalse(testEmptyPriorityQueue.equals(null));
    assertFalse(testEmptyPriorityQueue.equals(0));
    testEmptyPriorityQueue2 = PriorityQueue.createEmpty();
    assertTrue(testEmptyPriorityQueue.equals(testEmptyPriorityQueue2));
  }

  @Test
  void testHashCode() {
    assertEquals(41, testEmptyPriorityQueue.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "{ }";
    assertEquals(expectedString, testEmptyPriorityQueue.toString());
  }
}