package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehiclesTest {
  Vehicles vehicles;

  @BeforeEach
  void setUp() throws Exception {
    vehicles = new Vehicles(200,true,true,12);
  }

  @Test
  void invalidPrice() throws IllegalPriceException {
    Vehicles vehiclesInvalid = new Vehicles(1, false, false, 11);
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(0, vehicles.getMaxOccupancy());
  }

  @Test
  void getPrice() {
    assertEquals(200.0, vehicles.getPrice());
  }

  @Test
  void isLicense() {
    assertTrue(vehicles.equals(vehicles));
  }

  @Test
  void isAllowDiff() {
    assertTrue(vehicles.equals(vehicles));
  }

  @Test
  void getNumBookDays() {
    assertEquals(12, vehicles.getNumBookDays());
  }

  @Test
  void setMaxOccupancy() {
    vehicles.setMaxOccupancy(8);
    assertEquals(8, vehicles.getMaxOccupancy());
  }

  @Test
  void invalidBookVehicle() throws IllegalBookException {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      vehicles.bookVehicle(12, -1, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }
}