package problem1;

public class InternetTVComputing extends Specialist {

  private static final double PERMITTING_FEE = 15;

  private static final Integer LICENSED_EMPLOYEE_LIMIT = 2;

  /**
   * Constructs a new specialist, with basicInformation, ifComplex and numberOfLicensedEmployees,
   * numberOfLicensedEmployees will change based on ifComplex and specific limits
   *
   * @param basicInformation          - basic information of the customer, expressed as a
   *                                  BasicInformation
   * @param ifComplex                 - whether service is complex, expressed as a boolean
   * @param numberOfLicensedEmployees - number of licensed employees needed, expressed as an
   *                                  Integer
   */
  public InternetTVComputing(BasicInformation basicInformation, Boolean ifComplex,
      Integer numberOfLicensedEmployees)
      throws OutNumberedLicensedEmployeeException {
    super(basicInformation, ifComplex, numberOfLicensedEmployees);
    if (numberOfLicensedEmployees > LICENSED_EMPLOYEE_LIMIT) {
      throw new OutNumberedLicensedEmployeeException();
    }
  }

  /**
   * {@inheritDoc}
   * Calculates the price after adding permitting fee.
   * @return double
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + PERMITTING_FEE;
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param obj - an object to compare
   * @return Boolean
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * {@inheritDoc} returns the value given to it in string format
   *
   * @return String
   */
  @Override
  public String toString() {
    return super.toString();
  }

}
