package problem2;

import java.util.Arrays;
import java.util.Objects;
import problem1.Course;

public class Queue implements IQueue{
  private Integer[] items;
  private Integer totalLength;

  public Queue() {
    this.items = null;
    this.totalLength = 0;
  }


  /**
   * Adds a Course to the end of the CourseCatalog.
   *
   * @return
   */
  @Override
  public Queue emptyQueue() {
    return new Queue();
  }

  /**
   * Checks if the Queue is empty.
   *
   * @return true if the Queue contains no items, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return this.totalLength == 0;
  }

  /**
   * Adds the given Integer to the Queue if and only if that Integer is not already in the Queue.
   *
   * @param n An Integer object.
   * @return A Queue having Integer n object.
   */
  @Override
  public Queue add(Integer n) {
    Queue newQueue = new Queue();
    Integer[] newItems = new Integer[this.totalLength+1];
    for(int i = 0; i < this.totalLength; i++){
      newItems[i] = this.items[i];
    }
    newItems[this.totalLength] = n;
    newQueue.items = newItems;
    newQueue.totalLength = this.totalLength + 1;
    return newQueue;
  }

  /**
   * Check if the Queue contains n object.
   *
   * @param n The Integer object.
   * @return true if the given Integer is in the Queue, false otherwise.
   */
  @Override
  public Boolean contains(Integer n) {
    if (this.totalLength > 0) {
      for (Integer existingInteger : this.items) {
        if (existingInteger.equals(n)) return true;
      }
    }
    return false;
  }

  /**
   * Remove the object.
   *
   * @return a copy of the Queue with the given Integer removed.If the given Integer is not in the
   * Queue, returns the Queue as it.
   */
  @Override
  public Queue remove() {
    return null;
  }

  /**
   * Remove the object.
   *
   * @return a copy of the Queue with the given Integer removed.If the given Integer is not in the
   * element, returns the Queue as it.
   */
  @Override
  public Queue removeElement() {
    return null;
  }

  /**
   * Gets the number of items in the Queue.
   *
   * @return the number of items in the Queue.
   */
  @Override
  public Integer size() {
    return this.totalLength;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Queue queue = (Queue) o;
    return Arrays.equals(items, queue.items) && Objects.equals(totalLength,
        queue.totalLength);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(totalLength);
    result = 31 * result + Arrays.hashCode(items);
    return result;
  }

  @Override
  public String toString() {
    return "Queue{" +
        "items=" + Arrays.toString(items) +
        ", totalLength=" + totalLength +
        '}';
  }
}
