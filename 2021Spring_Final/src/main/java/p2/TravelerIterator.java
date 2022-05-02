package p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class TravelerIterator implements Iterator<Traveler> {

  private static final float TOTAL_DISTANCE_TRAVELED_THRESHOLD = 5000;
  private final List<Traveler> travelers;

  public TravelerIterator(List<Traveler> travelers) {
    this.travelers = filterByTotalDistanceTraveled(travelers);
  }

  private List<Traveler> filterByTotalDistanceTraveled(List<Traveler> travelers) {
    List<Traveler> filteredList = new ArrayList<>();
    TotalDistanceComparator comparator = new TotalDistanceComparator();

    for (Traveler traveler : travelers) {
      if (comparator.getTotalDistance(traveler) > TOTAL_DISTANCE_TRAVELED_THRESHOLD) {
        filteredList.add(traveler);
      }
    }
    return filteredList;
  }

  /**
   * Returns {@code true} if the iteration has more elements.
   * @return
   */
  @Override
  public boolean hasNext() {
    return (this.travelers.size() > 0);
  }

  /**
   * Returns the next element in the iteration.
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Traveler next() {
    return this.travelers.remove(0);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TravelerIterator that = (TravelerIterator) o;
    return Objects.equals(travelers, that.travelers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(travelers);
  }

  @Override
  public String toString() {
    return "TravelerIterator{" +
        "travelers=" + travelers +
        '}';
  }
}
