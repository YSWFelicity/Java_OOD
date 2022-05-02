package p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TripRecommender {

  private static final Integer INCREASE = 1;
  private Map<Destination, List<Integer>> destinationStatistics;

  public TripRecommender() {
    this.destinationStatistics = new HashMap<>();
  }

  public Map<Destination, List<Integer>> getDestinationStatistics() {
    return destinationStatistics;
  }

  /**
   * Method to change a list of travelers into a Map where the key is a destination object and the
   * value if a list of 2 integers,the first one being the number of times the destination has been
   * traveled to, and the second being the number of times it has been considered.
   * @param travelers - list of travelers
   */
  public void getAggregatedStatistics(List<Traveler> travelers) {
    List<Integer> value;
    for (Traveler traveler : travelers) {
      for (Destination destination : traveler.getTraveledDestinations()) {
        List<Integer> updatedValue = new ArrayList<>();
        if (this.destinationStatistics.containsKey(destination)) {
          value = this.destinationStatistics.get(destination);
          updatedValue.add(value.get(0) + 1);
          updatedValue.add(value.get(1));
        } else {
          updatedValue.add(1);
          updatedValue.add(0);
        }
        this.destinationStatistics.put(destination, updatedValue);
      }

    }
  }

  public Destination recommendMostVisitedDestination(){
    return getRecommended(0);
  }

  public Destination recommendMostDesiredDestination(){
    return getRecommended(1);
  }

  private Destination getRecommended(Integer index) {
    Destination mostRecommended = null;
    Integer highestValue = 0;
    for (Map.Entry<Destination, List<Integer>> entry : this.destinationStatistics.entrySet()) {
      // compare previous highestValue with new entry's value
      if (entry.getValue().get(index) > highestValue) {
        highestValue = entry.getValue().get(index);
        mostRecommended = entry.getKey();
      }
    }
    return mostRecommended;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripRecommender that = (TripRecommender) o;
    return Objects.equals(destinationStatistics, that.destinationStatistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationStatistics);
  }

  @Override
  public String toString() {
    return "TripRecommender{" +
        "destinationStatistics=" + destinationStatistics +
        '}';
  }
}
