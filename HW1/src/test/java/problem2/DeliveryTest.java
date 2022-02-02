package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryTest {
    private Time expectStartingTime;
    private Time expectStartingTime2;
    private Time expectEndTime;
    private String expectStartingLocation;
    private String expectEndLocation;
    private Delivery testDelivery;
    private Delivery testDelivery2;

    @BeforeEach
    public void setUp() throws Exception {
        this.expectStartingTime = new Time(2,0,0);
        this.expectStartingTime2 = new Time(2,30,30);
        this.expectEndTime = new Time(3,15,15);
        this.expectStartingLocation = "Seattle";
        this.expectEndLocation = "Boston";
        this.testDelivery = new Delivery(expectStartingTime, expectEndTime, expectStartingLocation, expectEndLocation);
        this.testDelivery2 = new Delivery(expectStartingTime2, expectEndTime, expectStartingLocation, expectEndLocation);
    }

    @Test
    public void getStartingTime() {
        assertEquals(expectStartingTime, testDelivery.getStartingTime());
        assertEquals(expectStartingTime2, testDelivery2.getStartingTime());
    }

    @Test
    public void getEndTime() {
        assertEquals(expectEndTime, testDelivery.getEndTime());
        assertEquals(expectEndTime, testDelivery2.getEndTime());
    }

    @Test
    public void getStartingLocation() {
        assertEquals(expectStartingLocation, testDelivery.getStartingLocation());
        assertEquals(expectStartingLocation, testDelivery2.getStartingLocation());
    }

    @Test
    public void getEndLocation() {
        assertEquals(expectEndLocation, testDelivery.getEndLocation());
        assertEquals(expectEndLocation, testDelivery2.getEndLocation());
    }

    @Test
    public void getDuration() {
        Time expectDuration = new Time(1, 44,15);
        assertEquals(expectDuration.getHour(), testDelivery.getDuration().getHour());
        assertEquals(expectDuration.getMinute(), testDelivery2.getDuration().getMinute());
        assertEquals(expectDuration.getSecond(), testDelivery.getDuration().getSecond());
        Time expectDuration2 = new Time(0,44,45);
        assertEquals(expectDuration2.getHour(), testDelivery2.getDuration().getHour());
        assertEquals(expectDuration2.getMinute(), testDelivery2.getDuration().getMinute());
        assertEquals(expectDuration2.getSecond(), testDelivery2.getDuration().getSecond());
    }
}