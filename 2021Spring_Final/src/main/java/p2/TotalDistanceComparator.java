package p2;

import java.util.Comparator;

public class TotalDistanceComparator implements Comparator<Traveler>{

  /**
   * Method compares travelers based on the total distance they traveled over the last 3 years.
   * Please note that the total distance traveled is calculated as the overall sum of
   * all distance from Seattle, an all of the trips that the traveler took over the last three years.
   * @param t1 - traveler 1
   * @param t2 - traveler 2
   * @return negative number if t1 is less than t2, positive number if t1 is greater than t2, and
   * 0 if equal based on the total distance traveled
   */
  @Override
  public int compare(Traveler t1, Traveler t2) {
    return Float.compare(getTotalDistance(t1), getTotalDistance(t2));
  }

  /**
   * Helper method for summing up the total distance traveled from Seattle
   * @param traveler - given traveler
   * @return total distance traveled
   */
  public Float getTotalDistance(Traveler traveler) {
    float totalDistance = 0;
    for (Destination destination : traveler.getTraveledDestinations()) {
      totalDistance += destination.getDistanceFromSeattle();
    }
    return totalDistance;
  }
}
