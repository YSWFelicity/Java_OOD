package problem1;

/**
 * A class representing a vehicle. Allow set price, max occupancy
 * license, allow different pick-up and drop-off locations and number
 * of booking days
 */
public class Vehicles {

  public int maxOccupancy = 0;
  private float price;
  private boolean license;
  private boolean allowDiff; //Questions
  private int numBookDays = 0;

  public Vehicles(float price, boolean license, boolean allowDiff, int numBookDays) throws IllegalPriceException {
    this.isValidPrice(price);
    this.price = price;
    this.license = license;
    this.allowDiff = allowDiff;
    this.numBookDays = numBookDays;
  }

  public int getMaxOccupancy() {
    return maxOccupancy;
  }

  public float getPrice() {
    return price;
  }

  public boolean isLicense() {
    return license;
  }

  public boolean isAllowDiff() {
    return allowDiff;
  }

  public int getNumBookDays() {
    return numBookDays;
  }

  public void setMaxOccupancy(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  private void isValidPrice(float price) throws IllegalPriceException {
    if (price <= 0) {
      throw new IllegalPriceException();
    }
  }
  private boolean isAvailable(){
    if(this.numBookDays == 0){
      return true;
    }
    return false;
  }

  public void bookVehicle(int numBookDays, int numPassengers, String pickUp, String dropOff,
      boolean license) throws IllegalBookException { //Questions
    isBookValid(numBookDays);
    this.numBookDays = numBookDays;
    //add return (line 55 should be boolean instead of void)
  }

  private void isBookValid(int numBookDays) throws IllegalBookException {
    if(!this.isAvailable() || numBookDays <= 0 || numBookDays > this.maxOccupancy){
      throw new IllegalBookException();
    }
  }

}


