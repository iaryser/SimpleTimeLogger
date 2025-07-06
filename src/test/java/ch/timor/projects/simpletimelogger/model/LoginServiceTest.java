package ch.timor.projects.simpletimelogger.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    UserDataBase dataBase = new UserDataBase();
    LoginService service = new LoginService(dataBase);

    @Test
    public void existingUserLoggingInTest() {
        dataBase.addUser(new User("Timo", "Ryser", "iaryser", "Strongpw12."));
        assertEquals(true, service.login("iaryser", "Strongpw12."));
    }

    @Test
    public void nonExistingUserLoggingInTest1() {
        dataBase.addUser(new User("Timo", "Ryser", "iaryser", "Strongpw12."));
        assertEquals(false, service.login("iadoe", "Strongpw12."));
    }

    @Test
    public void nonExistingUserLoggingInTest2() {
        assertEquals(false, service.login("iaryser", "Strongpw12."));
    }

    @Test
    public void loginInWithIncorrectPasswordTest() {
        dataBase.addUser(new User("Timo", "Ryser", "iaryser", "Strongpw12."));
        assertEquals(false, service.login("iaryser", "inc0rrectPassword."));
    }

    @Test
    public void caseSensitivityTest1() {
        dataBase.addUser(new User("Timo", "Ryser", "iaryser", "Strongpw12."));
        assertEquals(false, service.login("IAryser", "Strongpw12."));
    }

    @Test
    public void caseSensitivityTest2() {
        dataBase.addUser(new User("Timo", "Ryser", "iaryser", "Strongpw12."));
        assertEquals(false, service.login("iaryser", "strongpw12."));
    }

    @Test
    public void caseSensitivityTest3() {
        dataBase.addUser(new User("Timo", "Ryser", "iaRyser", "Strongpw12."));
        assertEquals(false, service.login("iaryser", "Strongpw12."));
    }
}