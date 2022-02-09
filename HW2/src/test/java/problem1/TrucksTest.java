package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrucksTest {
  Trucks trucks;

  @BeforeEach
  void setUp() throws Exception {
    trucks = new Trucks(60, 8);
  }

  @Test
  void invalidPrice() throws IllegalPriceException {
    IllegalPriceException thrown = Assertions.assertThrows(IllegalPriceException.class, () -> {
      Trucks invalidPriceTrucks = new Trucks(-4,7);
    }, "Invalid price");

    Assertions.assertEquals("Invalid price exception", thrown.getMessage());

  }

  @Test
  void getMaxOccupancy() {
    assertEquals(2,trucks.getMaxOccupancy());
  }

  @Test
  void getPrice() {
    assertEquals(60.0, trucks.getPrice());
  }

  @Test
  void isLicense() {
    assertTrue(trucks.equals(trucks));
  }

  @Test
  void isAllowDiff() {
    assertTrue(trucks.equals(trucks));
  }

  @Test
  void getNumBookDays() {
    assertEquals(8, trucks.getNumBookDays());
  }

  @Test
  void setMaxOccupancy() {
    trucks.setMaxOccupancy(2);
    assertEquals(2,trucks.getMaxOccupancy());
  }

  @Test
  void InvalidNumPassengers1() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      trucks.bookVehicle(7, -1, "Seattle", "Seattle",true);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers2() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      trucks.bookVehicle(7, 6, "Seattle", "Seattle",true);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers3() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      trucks.bookVehicle(7, 0, "Seattle", "Seattle",true);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

}