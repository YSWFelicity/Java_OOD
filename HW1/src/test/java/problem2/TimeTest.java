package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    Time time1;
    Time time2;

    @BeforeEach
    void setUp() throws Exception{
        time1 = new Time(10,39,50);
        time2 = new Time(2,30,40);
    }

    @Test
    void getHour() {
        assertEquals(10,time1.getHour());
        assertEquals(2, time2.getHour());
    }

    @Test
    void setHour() {
        time1.setHour(12);
        assertEquals(12,time1.getHour());
        time2.setHour(22);
        assertEquals(22,time2.getHour());
    }

    @Test
    void getMinute() {
        assertEquals(39,time1.getMinute());
        assertEquals(30,time2.getMinute());
    }

    @Test
    void setMinute() {
        time1.setMinute(00);
        assertEquals(00,time1.getMinute());
        time2.setMinute(59);
        assertEquals(59,time2.getMinute());
    }

    @Test
    void getSecond() {
        assertEquals(50,time1.getSecond());
        assertEquals(40,time2.getSecond());
    }

    @Test
    void setSecond() {
        time1.setSecond(01);
        assertEquals(01,time1.getSecond());
        time2.setSecond(59);
        assertEquals(59,time2.getSecond());
    }
}