package problem1;

public class LuxuryCars extends Vehicles{

  public LuxuryCars(float price, int numBookDays) throws IllegalPriceException {
    super(price, false, false, numBookDays);
    super.maxOccupancy = 4;
  }
}
