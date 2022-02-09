package problem1;

import java.util.Objects;

/**
 * A class representing a vehicle. Allow set price, max occupancy
 * license, allow different pick-up and drop-off locations and number
 * of booking days
 */
public class Vehicles {

  public int maxOccupancy = 8;
  private float price;
  private boolean license;
  private boolean allowDiff;
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

  public boolean bookVehicle(int numBookDays, int numPassengers, String pickUp, String dropOff,
      boolean license) throws IllegalBookException { //Questions
    isBookValid(numBookDays, numPassengers, pickUp, dropOff);
    this.numBookDays = numBookDays;
    return true;
    //add return (line 55 should be boolean instead of void)
  }

  private void isBookValid(int numBookDays, int numPassengers, String PickUp, String DropOff) throws IllegalBookException {
    if(!this.isAvailable() || numBookDays <= 0){
      throw new IllegalBookException();
    }
    if(numPassengers > this.maxOccupancy) {
      throw new IllegalBookException();
    }
    if(!PickUp.equals(DropOff)) {
      throw new IllegalBookException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicles vehicles = (Vehicles) o;
    return maxOccupancy == vehicles.maxOccupancy
        && Float.compare(vehicles.price, price) == 0 && license == vehicles.license
        && allowDiff == vehicles.allowDiff && numBookDays == vehicles.numBookDays;
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxOccupancy, price, license, allowDiff, numBookDays);
  }

  @Override
  public String toString() {
    return "Vehicles{" +
        "maxOccupancy=" + maxOccupancy +
        ", price=" + price +
        ", license=" + license +
        ", allowDiff=" + allowDiff +
        ", numBookDays=" + numBookDays +
        '}';
  }
}




