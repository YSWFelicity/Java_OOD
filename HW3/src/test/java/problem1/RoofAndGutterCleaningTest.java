package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoofAndGutterCleaningTest {

  private String expectedAddress;
  private PropertySize expectedPropertySize;
  private Boolean expectedMonthlySubscription;
  private Integer expectedNumberOfPreviousService;
  private BasicInformation expectedBasicInformation;
  private BasicInformation expectedBasicInformation2;
  private Integer expectedNumberOfFloors;
  private Integer expectedNumberOfFloors2;
  private Double expectedSquareFootage;
  private Double expectedSquareFootage2;
  private RoofType expectedRoofType;
  private RoofType expectedRoofType2;
  private RoofAndGutterCleaning testRoofAndGutterCleaning;
  private RoofAndGutterCleaning testRoofAndGutterCleaning2;


  @BeforeEach
  public void setUp() throws Exception {
    expectedAddress = "abc road";
    expectedPropertySize = PropertySize.SMALL;
    expectedMonthlySubscription = false;
    expectedNumberOfPreviousService = 0;
    expectedBasicInformation = new BasicInformation(expectedAddress,expectedPropertySize,
        false,expectedNumberOfPreviousService);
    expectedSquareFootage = 3200.0;
    expectedRoofType = RoofType.MANSARD;
    testRoofAndGutterCleaning = new RoofAndGutterCleaning(expectedBasicInformation, expectedSquareFootage, expectedRoofType);
  }

  @Test
  public void calculatePrice() {
    assertEquals(330.0, testRoofAndGutterCleaning.calculatePrice(),0);
  }


  @Test
  public void equalsReflexivity(){
    assertTrue(testRoofAndGutterCleaning.equals(testRoofAndGutterCleaning));
  }

  @Test
  public void equalsReflexivity3() throws OutNumberedFloorException{
    assertNotEquals(testRoofAndGutterCleaning,null);
  }

  @Test
  public void equalsDifferentDataTypes() {
    assertFalse(testRoofAndGutterCleaning.equals(expectedBasicInformation));
  }

  @Test
  public void hashcode(){
    int hash = Objects.hash(expectedSquareFootage, expectedRoofType);
    assertEquals(testRoofAndGutterCleaning.hashCode(),hash);
  }

  @Test
  public void testToString(){
    String expectedString = "RoofAndGutterCleaning{" +
        "squareFootage=" + expectedSquareFootage +
        ", roofType=" + expectedRoofType +
        '}';
    assertEquals(expectedString, testRoofAndGutterCleaning.toString());
  }

}