package problem2;

import java.util.Arrays;
import java.util.Objects;
import problem1.Course;

/**
 * A class representing Queue implements ADT methods.
 */
public class Queue implements IQueue{
  private Integer[] items;
  private Integer totalLength;

  /**
   * Constructs a queue, with items queue to null and totalLength queue to 0
   */
  public Queue() {
    this.items = null;
    this.totalLength = 0;
  }


  /**
   * Creates and returns an empty Queue.
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
   * @return a copy of the Queue with the first element removed.
   */
  @Override
  public Queue remove() {
    Queue newQueue = new Queue();
    Integer[] newItems = new Integer[this.totalLength-1];
    for(int i = 1; i < this.totalLength; i++){
      newItems[i] = this.items[i];
    }
    newQueue.items = newItems;
    return newQueue;
  }


  /**
   * Remove the object.
   *
   * @return a copy of the Queue with the given Integer removed.If the given Integer is not in the
   * element, returns the Queue as it.
   */
  @Override
  public Queue removeElement(Integer n) {
    if (!contains(n)) return this;
    Queue newQueue = new Queue();
    Integer[] newItems = new Integer[this.totalLength-1];
    int i = 0;
    for(Integer item: this.items) {
      if (item != n) {
        newItems[i] = item;
        i++;
      }
    }
    newQueue.items = newItems;
    newQueue.totalLength = this.totalLength -1;
    return newQueue;
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


  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean
   */
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

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(totalLength);
    result = 31 * result + Arrays.hashCode(items);
    return result;
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Queue{" +
        "items=" + Arrays.toString(items) +
        ", totalLength=" + totalLength +
        '}';
  }
}
