package problem1;

import java.util.Objects;

/**
 * Represents a concrete class RoofAndGutterCleaning, extending Exterior,
 * including the square footage of the house and the roof type.
 */
public class RoofAndGutterCleaning extends Exterior{

  private Double squareFootage;
  private RoofType roofType;
  private static final Integer EXTRA_FEE_PER_HOUR = 50;
  private static final Integer BASE_SQUARE_FOOTAGE = 3000;
  private static final Integer EXTRA_FEE_MANSARD = 200;

  /**
   * Constructs a new abstract class Exterior, with basicInformation.
   *  @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param squareFootage - the square footage of the house
   * @param roofType - the roof type of the house
   */
  public RoofAndGutterCleaning(BasicInformation basicInformation, Double squareFootage,
      RoofType roofType) {
    super(basicInformation);
    this.squareFootage = squareFootage;
    this.roofType = roofType;
  }

  /**
   * {@inheritDoc}
   * Calculate the price after adding extra fee under two special conditions.
   * @return price
   */
  @Override
  public double calculatePrice() {
    double price = calculateExterior();
    if (this.squareFootage > BASE_SQUARE_FOOTAGE) {
      price = price + EXTRA_FEE_PER_HOUR * calculateHour();
    }
    if (this.roofType == RoofType.MANSARD) {
      price += EXTRA_FEE_MANSARD;
    }
    return price;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return Boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoofAndGutterCleaning that = (RoofAndGutterCleaning) o;
    return Objects.equals(squareFootage, that.squareFootage) && roofType == that.roofType;
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return double, enum
   */
  @Override
  public int hashCode() {
    return Objects.hash(squareFootage, roofType);
  }

  /**
   * {@inheritDoc} returns the value given to it in string format
   *
   * @return String
   */
  @Override
  public String toString() {
    return "RoofAndGutterCleaning{" +
        "squareFootage=" + squareFootage +
        ", roofType=" + roofType +
        '}';
  }
}
