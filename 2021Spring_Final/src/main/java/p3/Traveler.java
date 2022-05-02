package p3;

import java.util.List;

/**
 * Class represents a traveler. The traveler has a first name, last name and a
 * list of destinations they visited in the last three years, as well as the list of * destinations they considred in the last six months.
 */
public class Traveler {
  private String firstName;
  private String lastName;
  private List<Destination> traveledDestinations;
  private List<Destination> consideredDestinations;

/**
 * Constructs a Traveler object and initializes it
 * to the given first name, last name and the lists of traveled and considered destinations
 * @param firstName the first name of this person
 * @param lastName the last name of this person
 * @param traveledDestinations list of destinations they visited in the last three years.
 * @param consideredDestinations list of destinations they considered visiting in the last six months.
 */
  public Traveler(String firstName, String lastName, List<Destination> traveledDestinations,
      List<Destination> consideredDestinations) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.traveledDestinations = traveledDestinations;
    this.consideredDestinations = consideredDestinations;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Destination> getTraveledDestinations() {
    return traveledDestinations;
  }

  public List<Destination> getConsideredDestinations() {
    return consideredDestinations;
  }
}
