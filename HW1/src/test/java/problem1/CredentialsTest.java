package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredentialsTest {
    Credentials credentials;
    User Eason = new User("Eason", "Lee","3012654560", "eason@gmail.com", new Credentials("abc", "######"));
    // User Rachel = new User("Rachel","Lee","2053032640", "rachel@gmail.com", new Credentials("efg", "!!!!!"));

    @BeforeEach
    void setUp() throws Exception {
        credentials = new Credentials("hij", "@@@@@");
        // credentials = new Credentials("klm", "$$$$$");
    }

    @Test
    void getUsername() {
        assertEquals("hij", credentials.getUsername());
    }

    @Test
    void setUsername() {
        credentials.setUsername("Jane Doe");
        assertEquals("Jane Doe", credentials.getUsername());
    }

    @Test
    void getPasswordHash() {
        assertEquals("@@@@@", credentials.getPasswordHash());
    }

    @Test
    void setPasswordHash() {
        credentials.setPasswordHash("$$$$$");
        assertEquals("$$$$$", credentials.getPasswordHash());
    }
}