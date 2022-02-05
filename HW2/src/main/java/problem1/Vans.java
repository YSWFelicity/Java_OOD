package problem1;

public class Vans extends Vehicles{


  public Vans(float price, int numBookDays) throws IllegalPriceException {
    super(price, false, false, numBookDays);
    super.maxOccupancy = 8;
  }
}
