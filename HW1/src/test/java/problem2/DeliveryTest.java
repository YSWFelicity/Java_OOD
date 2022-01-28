package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {
    Delivery delivery;
    Time startTime;
    Time endTime;

    /**
     * Check if two Time objects are equal in data.
     * @return ture if two Time objects have the same data. Otherwise, false.
     * */
    public static boolean timeEquals(Time orignalTime, Object o) {
        if (orignalTime == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return orignalTime.getHour() == time.getHour() &&
                orignalTime.getMinute() == time.getMinute() &&
                orignalTime.getSecond() == time.getSecond();
    }

    @BeforeEach
    void setUp() throws Exception {
        startTime = new Time(9,30,30);
        endTime = new Time(19,50,20);
        delivery = new Delivery("Seattle", "New York", startTime, endTime);
    }

    @Test
    void getStartingLocation() {
        assertEquals("Seattle", delivery.getStartingLocation());
    }

    @Test
    void getEndLocation() {
        assertEquals("New York", delivery.getEndLocation());
    }

    @Test
    void getStartTime() {
        timeEquals(new Time(9,30,30), startTime);
    }

    @Test
    void getEndTime() {
        timeEquals(new Time(19,50,20), endTime);
    }

    @Test
    void setStartingLocation() {
        delivery.setStartingLocation("Los Angeles");
        assertEquals("Los Angeles", delivery.getStartingLocation());
    }

    @Test
    void setEndLocation() {
        delivery.setEndLocation("San Francisco");
        assertEquals("San Francisco",delivery.getEndLocation());
    }

    @Test
    void setStartTime() {
        delivery.setStartTime(new Time(10,53,11));
        timeEquals(new Time(10,53,11), delivery.getStartTime());
    }

    @Test
    void setEndTime() {
        delivery.setEndTime( new Time(16,22,15));
        timeEquals(new Time(16,22,15), delivery.getEndTime());
    }

    @Test
    void getDuration() {
        timeEquals(new Time(10,19,50),delivery.getDuration());
    }
}