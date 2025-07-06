package ch.timor.projects.simpletimelogger.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDataBaseTest {
    UserDataBase dataBase = new UserDataBase();

    @BeforeEach
    public void setup() {
        dataBase.addUser(new User("John", "Doe", "jadoe", "StrongPassw0rd!"));
        dataBase.addUser(new User("Alice", "Miller", "amiller", "Passw0rdWith$"));
        dataBase.addUser(new User("Bob", "Smith", "bsmith", "B0b@Secure!"));
        dataBase.addUser(new User("Clara", "Jenkins", "cjenkins", "Clar@12345!"));
        dataBase.addUser(new User("Daniel", "Nguyen", "dnguyen", "D@niNguyen9"));
    }

    @Test
    public void getAmountOfUsersTest1() {
        assertEquals(5, dataBase.getAmountOfUsers());
    }

    @Test
    public void getAmountOfUsersTest2() {
        assertNotEquals(23, dataBase.getAmountOfUsers());
    }

    @Test
    public void getExistingUserTest() {
        User user = new User("John", "Doe", "jadoe", "StrongPassw0rd!");
        assertEquals(user, dataBase.getUser("jadoe"));
    }

    @Test
    public void getNonExistingUserTest() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            dataBase.getUser("abcdefg");
        });
        assertEquals("Kein User mit Usernamen: abcdefg gefunden.", e.getMessage());
    }

    @Test
    public void addUserTest() {
        dataBase.addUser(new User("Timo", "Ryser", "iaryser", "Anoth3rpassword."));
        assertEquals(6, dataBase.getAmountOfUsers());
    }

    @Test
    public void removeExistingUserTest() {
        dataBase.removeUser("jadoe");
        assertEquals(4, dataBase.getAmountOfUsers());
    }

    @Test
    public void removeNonExistingUser() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            dataBase.removeUser("abcdefg");
        });
        assertEquals("Kein User mit Usernamen: abcdefg gefunden.", e.getMessage());
    }

    @Test
    public void getAllUsersTest() {
        Collection<User> expected = List.of(
                new User("John", "Doe", "jadoe", "StrongPassw0rd!"),
                new User("Alice", "Miller", "amiller", "Passw0rdWith$"),
                new User("Bob", "Smith", "bsmith", "B0b@Secure!"),
                new User("Clara", "Jenkins", "cjenkins", "Clar@12345!"),
                new User("Daniel", "Nguyen", "dnguyen", "D@niNguyen9")
        );
        assertTrue(dataBase.getAllUsers().containsAll(expected));
    }






}