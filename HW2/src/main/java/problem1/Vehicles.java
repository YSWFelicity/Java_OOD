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

  /**
   * Constructor for the Vehicles class.
   * @param price The price associated with the vehicle.
   * @param license The license associated with the vehicle.
   * @param allowDiff If allows to pick-up and drop off at the same location
   * @param numBookDays The allowed number of booking days
   * @throws IllegalPriceException if the price is not valid.
   */
  public Vehicles(float price, boolean license, boolean allowDiff, int numBookDays) throws IllegalPriceException {
    this.isValidPrice(price);
    this.price = price;
    this.license = license;
    this.allowDiff = allowDiff;
    this.numBookDays = numBookDays;
  }

  /**
   * Gets the max occupancy of the vehicle.
   * @return The max occupancy of the vehicle.
   */
  public int getMaxOccupancy() {
    return maxOccupancy;
  }

  /**
   * Gets the price of the vehicle.
   * @return The price of the vehicle.
   */
  public float getPrice() {
    return price;
  }

  /**
   * If driver license is required.
   * @return True/False of driver license.
   */
  public boolean isLicense() {
    return license;
  }

  /**
   * If allows the same pick-up and drop-off location.
   * @return True/False of same location.
   */
  public boolean isAllowDiff() {
    return allowDiff;
  }
  /**
   * Gets the number of booking days of the vehicle.
   * @return The number of booking days of the vehicle.
   */
  public int getNumBookDays() {
    return numBookDays;
  }

  /**
   * Sets the max occupancy of the Vehicle.
   * @param maxOccupancy The max occupancy of the Vehicle.
   */
  public void setMaxOccupancy(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  /**
   * Helper method that checks if a price is greater than zero.
   * @param price The price to check.
   * @throws IllegalPriceException if the price is invalid.
   */
  private void isValidPrice(float price) throws IllegalPriceException {
    if (price <= 0) {
      throw new IllegalPriceException();
    }
  }

  /**
   * Helper method that checks if a vehicle is available.
   * @return true if there is no guest in the vehicle.Otherwise, false.
   */
  private boolean isAvailable(){
    if(this.numBookDays == 0){
      return true;
    }
    return false;
  }

  /**
   * Book Vehicles for passengers.
   * @param numBookDays, numPassengers, pickUp, dropOff, license
   * @throws IllegalBookException if the book is unsuccessful.
   */
  public boolean bookVehicle(int numBookDays, int numPassengers, String pickUp, String dropOff,
      boolean license) throws IllegalBookException { //Questions
    isBookValid(numBookDays, numPassengers, pickUp, dropOff);
    this.numBookDays = numBookDays;
    return true;
  }

  /**
   * Helper method that checks if a booking is valid.
   * @param numBookDays, numPassengers, pickUp, dropOff, license
   * @throws IllegalBookException if the booking Vehicles meets requirements.
   */
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




