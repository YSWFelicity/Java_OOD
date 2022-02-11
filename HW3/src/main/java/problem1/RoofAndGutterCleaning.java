package problem1;

public class RoofAndGutterCleaning extends Exterior{

  private Double squareFootage;
  private RoofType roofType;
  private static final Integer EXTRA_FEE = 50;
  private static final Integer BASE_SQUARE_FOOTAGE = 3000;
  private static final Integer EXTRA_FEE_MANSARD = 200;

  /**
   * Constructs a new abstract class Exterior, with basicInformation.
   *  @param basicInformation - basic information of the customer, expressed as a BasicInformation
   * @param squareFootage
   * @param roofType
   */
  public RoofAndGutterCleaning(BasicInformation basicInformation, Double squareFootage,
      RoofType roofType) {
    super(basicInformation);
    this.squareFootage = squareFootage;
    this.roofType = roofType;
  }

//  @Override
//  public double calculatePrice() {
//    addtionalFee = 0;
//    if (this.squareFootage > BASE_SQUARE_FOOTAGE) {
//      addtionalFee =
//    }
//    return (super.calculatePrice());
//  }

}
