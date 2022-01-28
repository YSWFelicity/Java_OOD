package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    Time time;

    @BeforeEach
    void setUp() throws Exception{
        time = new Time(10,39,50);
    }

    @Test
    void getHour() {
        assertEquals(10,time.getHour());
    }

    @Test
    void setHour() {
        time.setHour(12);
        assertEquals(12,time.getHour());
    }

    @Test
    void getMinute() {
        assertEquals(39,time.getMinute());
    }

    @Test
    void setMinute() {
        time.setMinute(00);
        assertEquals(00,time.getMinute());
    }

    @Test
    void getSecond() {
        assertEquals(50,time.getSecond());
    }

    @Test
    void setSecond() {
        time.setSecond(01);
        assertEquals(01,time.getSecond());
    }
}