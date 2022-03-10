package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LanciaLambdaTest {

  private String expectedUniqueID;
  private Integer expectedAge;
  private Integer expectedMileage;
  private Condition expectedCondition;
  private Double expectedLatestAskingPrice;
  private LanciaLambda testLanciaLambda;

  @BeforeEach
  void setUp() throws Exception{
    expectedUniqueID = "goodCar123";
    expectedAge = 100;
    expectedMileage = 10000000;
    expectedCondition = Condition.DRIVER;
    expectedLatestAskingPrice = 20000.0;
    testLanciaLambda = new LanciaLambda(expectedUniqueID, expectedAge,
        expectedMileage, expectedCondition, expectedLatestAskingPrice);
  }

  @Test
  void testEstimatePrice() {
    Double EXPECTED_EXTRA_BONUS = 0.0;
    Double expectedPrice = expectedLatestAskingPrice * 3.2 + EXPECTED_EXTRA_BONUS;
    assertEquals(expectedPrice, testLanciaLambda.estimatePrice());

    expectedMileage = 10000;
    testLanciaLambda = new LanciaLambda(expectedUniqueID, expectedAge,
        expectedMileage, expectedCondition, expectedLatestAskingPrice);
    EXPECTED_EXTRA_BONUS = 50000.0;
    expectedPrice = expectedLatestAskingPrice * 3.2 + EXPECTED_EXTRA_BONUS;
    assertEquals(expectedPrice, testLanciaLambda.estimatePrice());

    expectedCondition = Condition.PERFECT;
    expectedMileage = 10000000;
    testLanciaLambda = new LanciaLambda(expectedUniqueID, expectedAge,
        expectedMileage, expectedCondition, expectedLatestAskingPrice);
    EXPECTED_EXTRA_BONUS = 0.0;
    expectedPrice = expectedLatestAskingPrice * 3.2 * 2.15 + EXPECTED_EXTRA_BONUS;
    assertEquals(expectedPrice, testLanciaLambda.estimatePrice());
  }
}