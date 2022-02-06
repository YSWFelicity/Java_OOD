package problem1;

/**
 * A class representing Vehicles with max occupancy of 8.
 */
public class Vans extends Vehicles{

  /**
   * Constructor for Vans class.
   * @param price The price associated with Vans.
   * @throws IllegalPriceException if the price input is invalid.
   */
  public Vans(float price, int numBookDays) throws IllegalPriceException {
    super(price, false, false, numBookDays);
    this.maxOccupancy = 8;
  }
}
