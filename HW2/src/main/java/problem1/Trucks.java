package problem1;

public class Trucks extends Vehicles{

  /**
   * Constructor for Trucks class.
   * @param price The price associated with Trucks.
   * @throws IllegalPriceException if the price input is invalid.
   */
  public Trucks(float price, int numBookDays) throws IllegalPriceException {
    super(price, true, false, numBookDays);
    super.maxOccupancy = 2;
  }
}
