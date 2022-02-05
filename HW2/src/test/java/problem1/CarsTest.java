package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
  Cars Cars;

  @BeforeEach
  void setUp() throws Exception {
      Cars = new Cars(50,7);
  }

//    @Test(expected = IllegalPriceException.class)
//    public void invalidPrice() throws IllegalPriceException {
//      Cars invalidPriceCars = new Cars(-5,7);
//    }
  @Test
  void invalidPrice() throws IllegalPriceException {
    Cars invalidPriceCars = new Cars(-5,7);
    IllegalPriceException thrown = Assertions.assertThrows(IllegalPriceException.class, () -> {
      Cars.addVehicles(Cars);
    }, "Invalid price");

    Assertions.assertEquals("Invalid price exception", thrown.getMessage());

  }

}