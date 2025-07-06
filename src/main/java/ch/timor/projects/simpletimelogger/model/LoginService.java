package ch.timor.projects.simpletimelogger.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class LoginService {
    private final UserDataBase dataBase;
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);

    public LoginService(UserDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public boolean login(String userName, String password) {
        try {
            User user = dataBase.getUser(userName);
            return Objects.equals(user.getPassword(), password);
        } catch(IllegalArgumentException i) {
            LOG.error("User konnte nicht gefunden werden: Passwort oder Username ist falsch.");
            return false;
        }
    }
}
