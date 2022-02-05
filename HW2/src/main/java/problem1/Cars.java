package problem1;

public class Cars extends Vehicles{

  /**
   * Constructor for Cars class.
   * @param price The price associated with cars.
   * @throws IllegalPriceException if the price is not valid.
   */
  public Cars(float price, int numBookDays) throws IllegalPriceException {
    super(price, false, true, numBookDays);
    this.maxOccupancy = 5;
  }
}
