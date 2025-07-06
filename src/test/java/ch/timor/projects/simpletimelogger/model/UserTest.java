package ch.timor.projects.simpletimelogger.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testConstructor1() {
        User user = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        assertEquals("Timo", user.getFirstName());
    }

    @Test
    public void testConstructor2() {
        User user = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        assertEquals("Ryser", user.getLastName());
    }

    @Test
    public void testConstructor3() {
        User user = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        assertEquals("iaryser", user.getUserName());
    }

    @Test
    public void testConstructor4() {
        User user = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        assertEquals("V4lidPassWord.", user.getPassword());
    }

    @Test
    public void passWordLengthTest1() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new User("Timo", "Ryser", "iaryser", "abc");
        });
        assertEquals("Passwort muss zwischen 8 und 20 Zeichen lang sein und eine Zahl sowie auch einen gross und Kleinbuchstaben enthalten.", e.getMessage());
    }

    @Test
    public void passWordLengthTest2() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new User("Timo", "Ryser", "iaryser", "abcdefghijklmnopqrstuvwxyz");
        });
        assertEquals("Passwort muss zwischen 8 und 20 Zeichen lang sein und eine Zahl sowie auch einen gross und Kleinbuchstaben enthalten.", e.getMessage());
    }

    @Test
    public void NoLowerCasePasswordTest() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new User("Timo", "Ryser", "iaryser", "INVALIDPASSWORD2.");
        });
        assertEquals("Passwort muss zwischen 8 und 20 Zeichen lang sein und eine Zahl sowie auch einen gross und Kleinbuchstaben enthalten.", e.getMessage());
    }

    @Test
    public void NoSpecialCharacterPasswordTest() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new User("Timo", "Ryser", "iaryser", "invalidPassword3");
        });
        assertEquals("Passwort muss zwischen 8 und 20 Zeichen lang sein und eine Zahl sowie auch einen gross und Kleinbuchstaben enthalten.", e.getMessage());
    }

    @Test
    public void NoDigitPasswordTest() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new User("Timo", "Ryser", "iaryser", "invalidPassword.");
        });
        assertEquals("Passwort muss zwischen 8 und 20 Zeichen lang sein und eine Zahl sowie auch einen gross und Kleinbuchstaben enthalten.", e.getMessage());
    }

    @Test
    public void equalsSameObjectTest() {
        User user = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        assertTrue(user.equals(user));
    }

    @Test
    public void equalsDifferentObjectTest() {
        assertFalse(new User("Timo", "Ryser", "iaryser", "V4lidPassWord.").equals("Not a user"));
    }

    @Test
    public void equalsNullTest() {
        assertFalse(new User("Timo", "Ryser", "iaryser", "V4lidPassWord.").equals(null));
    }

    @Test
    public void equalUserTest() {
        User user1 = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        User user2 = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        assertTrue(user1.equals(user2));
    }

    @Test
    public void equalsDifferentUserTest() {
        User user1 = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        User user2 = new User("John", "Doe", "iadoe", "AnotherV4lidPw.");
        assertFalse(user1.equals(user2));
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(User.class).withIgnoredFields("firstName", "lastName").verify();
    }

    @Test
    public void equalsHashCodeTest() {
        User user1 = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        User user2 = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void unequalHashCodeTest() {
        User user1 = new User("Timo", "Ryser", "iaryser", "V4lidPassWord.");
        User user2 = new User("John", "Doe", "iadoe", "AnotherV4lidPw.");
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }



}