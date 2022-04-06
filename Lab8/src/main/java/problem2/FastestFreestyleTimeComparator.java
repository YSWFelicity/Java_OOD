package problem2;

import java.util.Comparator;

public abstract class FastestFreestyleTimeComparator implements
    Comparable<Swimmer>, Comparator<Swimmer> {


  public int compare(Swimmer o1, Swimmer o2) {
    return (int) (o1.getFastestSwimTime(o1.getFreestyle50Times())
                    .compareTo(o2.getFastestSwimTime(o2.getFreestyle50Times()));
  }
}
