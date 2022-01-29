package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User eason;
    User rachel;
    Credentials credentials1;
    Credentials credentials2;

    @BeforeEach
    void setUp() throws Exception {
        credentials1 = new Credentials("abc", "#####");
        eason = new User("Eason", "Lee","3012654560", "eason@gmail.com", credentials1);
        credentials2 = new Credentials("efg", "!!!!!");
        rachel = new User("Rachel","Lee","2053032640", "rachel@gmail.com", credentials2);
    }

    @Test
    void getFirstName() {
        assertEquals("Eason", eason.getFirstName());
        assertEquals("Rachel",rachel.getFirstName());
    }

    @Test
    void setFirstName() {
        eason.setFirstName("Amy");
        assertEquals("Amy", eason.getFirstName());
        rachel.setFirstName("Felicity");
        assertEquals("Felicity", rachel.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Lee", eason.getLastName());
        assertEquals("Lee", rachel.getLastName());
    }

    @Test
    void setLastName() {
        eason.setLastName("Wang");
        assertEquals("Wang",eason.getLastName());
        rachel.setLastName("Fang");
        assertEquals("Fang",rachel.getLastName());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("3012654560",eason.getPhoneNumber());
        assertEquals("2053032640",rachel.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        eason.setPhoneNumber("0000000000");
        assertEquals("0000000000",eason.getPhoneNumber());
        rachel.setPhoneNumber("123456789");
        assertEquals("123456789",rachel.getPhoneNumber());
    }

    @Test
    void getEmailAddress() {
        assertEquals("eason@gmail.com",eason.getEmailAddress());
        assertEquals("rachel@gmail.com",rachel.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        eason.setEmailAddress("amy@yahoo.com");
        assertEquals("amy@yahoo.com",eason.getEmailAddress());
        rachel.setEmailAddress("felicity@yahoo.com");
        assertEquals("felicity@yahoo.com",rachel.getEmailAddress());
    }

    @Test
    void getCredentialPair() {
        assertEquals(credentials1, eason.getCredentialPair());
        assertEquals(credentials2, rachel.getCredentialPair());
    }

    @Test
    void setCredentialPair() {
        Credentials newCredential1 = new Credentials("hij", "@@@@@");
        eason.setCredentialPair(newCredential1);
        assertEquals(newCredential1, eason.getCredentialPair());
        //add Rachel as newCredential 2
        Credentials newCredential2 = new Credentials("klm", "$$$$$");
        rachel.setCredentialPair(newCredential2);
        assertEquals(newCredential2, rachel.getCredentialPair());
    }
}