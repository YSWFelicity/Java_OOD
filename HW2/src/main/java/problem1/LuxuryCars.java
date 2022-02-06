package problem1;

/**
 * A class representing Vehicles with max occupancy of 4.
 */
public class LuxuryCars extends Vehicles{

  /**
   * Constructor for Luxury Car class.
   * @param price The price associated with Luxury Car.
   * @throws IllegalPriceException if the price input is invalid.
   */
  public LuxuryCars(float price, int numBookDays) throws IllegalPriceException {
    super(price, false, false, numBookDays);
    this.maxOccupancy = 4;
  }
}
