package problem2;

public interface IQueue {

  /**
   * Creates and returns an empty Queue.
   */
  Queue emptyQueue();

  /**
   * Checks if the Queue is empty.
   * @return true if the Queue contains no items, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds the given Integer to the Queue if and only if that Integer is not already in the Queue.
   * @param n An Integer object.
   * @return A Queue having Integer n object.
   */
  Queue add(Integer n);

  /**
   * Check if the Queue contains n object.
   * @param n The Integer object.
   * @return true if the given Integer is in the Queue, false otherwise.
   */
  Boolean contains(Integer n);

  /**
   * Remove the object.
   * @return a copy of the Queue with the given Integer removed.If the given Integer is not in the
   * Queue, returns the Queue as it.
   */
  Queue remove();

  /**
   * Remove the object.
   * @return a copy of the Queue with the given Integer removed.If the given Integer is not in the
   * element, returns the Queue as it.
   */
  Queue removeElement();

  /**
   * Gets the number of items in the Queue.
   * @return the number of items in the Queue.
   */
  Integer size();
}
