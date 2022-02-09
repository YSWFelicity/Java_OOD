package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuxuryCarsTest {
  LuxuryCars luxuryCars;

  @BeforeEach
  void setUp() throws Exception {
    luxuryCars = new LuxuryCars(80, 10);
  }

  @Test
  void invalidPrice() throws IllegalPriceException {
    IllegalPriceException thrown = Assertions.assertThrows(IllegalPriceException.class, () -> {
      LuxuryCars invalidPriceTrucks = new LuxuryCars(-7,10);
    }, "Invalid price");

    Assertions.assertEquals("Invalid price exception", thrown.getMessage());

  }

  @Test
  void getMaxOccupancy() {
    assertEquals(4,luxuryCars.getMaxOccupancy());
  }

  @Test
  void getPrice() {
    assertEquals(80.0, luxuryCars.getPrice());
  }

  @Test
  void isLicense() {
    assertTrue(luxuryCars.equals(luxuryCars));
  }

  @Test
  void isAllowDiff() {
    assertTrue(luxuryCars.equals(luxuryCars));
  }

  @Test
  void getNumBookDays() {
    assertEquals(10, luxuryCars.getNumBookDays());
  }

  @Test
  void setMaxOccupancy() {
    luxuryCars.setMaxOccupancy(4);
    assertEquals(4,luxuryCars.getMaxOccupancy());
  }

  @Test
  void InvalidNumPassengers1() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      luxuryCars.bookVehicle(10, -1, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers2() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      luxuryCars.bookVehicle(10, 9, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers3() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      luxuryCars.bookVehicle(10, 0, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

}