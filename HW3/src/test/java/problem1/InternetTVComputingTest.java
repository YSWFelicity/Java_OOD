package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InternetTVComputingTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation expectedBasicInformation;
  private Boolean expectedIfComplex;
  private Integer expectedNumberOfLicensedEmployees;
  private Integer expectedNumberOfLicensedEmployees2;
  private InternetTVComputing testInternetTVComputing;
  private InternetTVComputing testInternetTVComputing2;

  @BeforeEach
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 0;
    expectedBasicInformation = new BasicInformation(expectedAddress, expectedPropertySize,
        false, expectedNumberOfPreviousService);
    expectedIfComplex = true;
    expectedNumberOfLicensedEmployees = 2;
    testInternetTVComputing = new InternetTVComputing(expectedBasicInformation, true,
        expectedNumberOfLicensedEmployees);
  }

  @Test
  public void calculatePrice() {
    assertEquals(415.0,testInternetTVComputing.calculatePrice(),0);
  }

//  @Test(expected = OutNumberedLicensedEmployeeException.class)
//  public void testOverEmployee() throws OutNumberedLicensedEmployeeException{
//    expectedNumberOfLicensedEmployees2 = 5;
//    testElectrical2 = new Electrical(expectedBasicInformation, expectedIfComplex,
//        expectedNumberOfLicensedEmployees2);
//  }

  @Test
  void testOverEmployee() {
    expectedNumberOfLicensedEmployees2 = 5;
    OutNumberedLicensedEmployeeException thrown = Assertions.assertThrows(OutNumberedLicensedEmployeeException.class, () -> {
      testInternetTVComputing2 = new InternetTVComputing(expectedBasicInformation, expectedIfComplex,
          expectedNumberOfLicensedEmployees2);
    }, "Not valid");

    Assertions.assertEquals("Too many licensed employees are required for this service", thrown.getMessage());
  }

  @Test
  public void testHashCode() {
    assertEquals(testInternetTVComputing.toString(),testInternetTVComputing.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(testInternetTVComputing.equals(testInternetTVComputing));
  }

  @Test
  public void testToString() {
    assertEquals(testInternetTVComputing.toString(), testInternetTVComputing.toString());
  }

}