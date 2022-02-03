package p1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    Runner testRunner;
    Name exepctedName;
    Double expectedHeight;
    Double expectedWeight;
    Double expected5kTime;
    Double expectedHalfMarathonTime;
    String expectedLeague;
    String expectedFavoriteEvent;

    @BeforeEach
    void setUp() {
        Name name = new Name("Allyson", "Michelle", "Felix");
        testRunner = new Runner(name, 168.0, 95.0 ,"US Track and Field",
                35.0, 178.0, "Olympics");
        exepctedName = new Name("Allyson", "Michelle", "Felix");
        expectedHeight = 168.0;
        expectedWeight = 95.0;
        expected5kTime = 35.0;
        expectedHalfMarathonTime = 178.0;
        expectedLeague = "US Track and Field";
        expectedFavoriteEvent = "Olympics";
    }

    @Test
    void getAthletesName() {
        assertEquals(exepctedName, testRunner.getAthletesName());
    }

    @Test
    void getHeight() {
        assertEquals(expectedHeight, testRunner.getHeight());
    }

    @Test
    void getWeight() {
        assertEquals(expectedWeight, testRunner.getWeight());
    }

    @Test
    void getLeague() {
        assertEquals(expectedLeague, testRunner.getLeague());
    }

    @Test
    void getBest5KTime() {
        assertEquals(expected5kTime, testRunner.getBest5KTime());
    }

    @Test
    void setBest5KTime() {
        testRunner.setBest5KTime(39.0);
        assertEquals(39.0, testRunner.getBest5KTime());
    }

    @Test
    void getBestHalfMarathonTime() {
        assertEquals(expectedHalfMarathonTime, testRunner.getBestHalfMarathonTime());
    }

    @Test
    void setBestHalfMarathonTime() {
        testRunner.setBestHalfMarathonTime(175.0);
        assertEquals(175.0, testRunner.getBestHalfMarathonTime());
    }

    @Test
    void getFavoriateRunningEvent() {
        assertEquals(expectedFavoriteEvent, testRunner.getFavoriateRunningEvent());
    }

    @Test
    void setFavoriateRunningEvent() {
        testRunner.setFavoriateRunningEvent("Boston Marathon");
        assertEquals("Boston Marathon", testRunner.getFavoriateRunningEvent());
    }

    @Test
    void testEquals_SameMemoryLocation() {
        assertTrue(testRunner.equals(testRunner));
    }

    @Test
    void testEquals_NullObject() {
        Runner newTestRunner;
        assertFalse(testRunner.equals(null));
    }

    @Test
    void testEquals_DifferentDataTypes() {
        BaseballPlayer testBaseballPlayer = new BaseballPlayer(exepctedName, 195.0,
                165.0, "NFC", "Mariners", 23.5, 5);
        assertFalse(testRunner.equals(testBaseballPlayer));
    }

    @Test
    void testEquals_DifferentInheritedFields() {
        Name newName = new Name ("Hussain", "NA", "Bolt");
        Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field",
                35.0, 178.0, "Olympics");
        assertFalse(testRunner.equals(newTestRunner));
    }

    @Test
    void testEquals_SameFieldsOverall() {
        Name newName = new Name ("Allyson", "Michelle", "Felix");
        Runner newTestRunner = new Runner(newName, 168.0, 95.0 ,"US Track and Field",
                35.0, 178.0, "Olympics");
        assertTrue(testRunner.equals(newTestRunner));
    }

    @Test
    void testEquals_Different5KTime() {
        Name newName = new Name ("Allyson", "Michelle", "Felix");
        Runner newTestRunner = new Runner(newName, 168.0, 95.0 ,"US Track and Field",
                35.0, 178.0, "Olympics");
        assertTrue(testRunner.equals(newTestRunner));
    }

    @Test
    void testEquals_DifferentHalfMarathonTime() {
        Name newName = new Name ("Allyson", "Michelle", "Felix");
        Runner newTestRunner = new Runner(newName, 168.0, 95.0 ,"US Track and Field",
                35.0, 165.0, "Olympics");
        assertFalse(testRunner.equals(newTestRunner));
    }

    @Test
    void testEquals_DifferentVenue() {
        Name newName = new Name ("Allyson", "Michelle", "Felix");
        Runner newTestRunner = new Runner(newName, 168.0, 95.0 ,"US Track and Field",
                35.0, 178.0, "Rock 'n' Roll Marathon");
        assertFalse(testRunner.equals(newTestRunner));
    }

    @Test
    void testHashCode() {
        Name newName = new Name("Allyson", "Michelle", "Felix");
        Runner newRunner = new Runner(newName, 168.0, 95.0 ,"US Track and Field",
            35.0, 178.0, "Olympics");
        assertTrue(testRunner.hashCode() == newRunner.hashCode());
    }

    @Test
    void testToString() {
        Name newName = new Name("Allyson", "Michelle", "Felix");
        Runner newRunner = new Runner(newName, 168.0, 95.0 ,"US Track and Field",
            35.0, 178.0, "Olympics");
        assertEquals(testRunner.toString(), newRunner.toString());
    }
}