package problem1;

/**
 * A class representing Vehicles with max occupancy of 2.
 */
public class Trucks extends Vehicles{

  /**
   * Constructor for Trucks class.
   * @param price The price associated with Trucks.
   * @throws IllegalPriceException if the price input is invalid.
   */
  public Trucks(float price, int numBookDays) throws IllegalPriceException {
    super(price, true, false, numBookDays);
    this.maxOccupancy = 2;
  }
}
