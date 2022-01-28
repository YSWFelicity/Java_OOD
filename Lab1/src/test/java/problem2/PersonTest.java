package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person testPerson;
    private Name testName;

    @BeforeEach
    void setUp() {
        testName = new Name("Natasha", "Romanoff");
        testPerson = new Person(testName, "natasha@avengers.org", "LA, US");
    }

    @Test
    void getName() {
        Name expectedName = new Name("Natasha", "Romanoff");
        assertEquals(expectedName, testPerson.getName()); //this fails
        //assertEquals(expectedName.getFirstName(), testPerson.getName().getFirstName());
        //assertEquals(expectedName.getLastName(), testPerson.getName().getLastName());
    }

    @Test
    void getEmail() {
    }

    @Test
    void getAddress() {
    }
}