package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person testPerson;

    @BeforeEach
    void setUp() {
        testPerson = new Person("James Bond", "007@mi6.uk",  "London, UK");
    }

    @Test
    void getName() {
        assertEquals("James Bond", testPerson.getName());
    }

    @Test
    void getEmail() {
        assertEquals("007@mi6.uk", testPerson.getEmail());
    }

    @Test
    void getAddress() {
        assertEquals("London, UK", testPerson.getAddress());
    }
}