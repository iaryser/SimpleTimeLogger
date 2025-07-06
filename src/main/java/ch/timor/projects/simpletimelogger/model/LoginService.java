package ch.timor.projects.simpletimelogger.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.Objects;

public class LoginService {
    private final UserDataBase dataBase;
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
    private Collection<LoginServiceListener> loginServiceListeners = new ArrayList<>();

    public LoginService(UserDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public boolean login(String userName, String password) {
        try {
            User user = dataBase.getUser(userName);
            if (Objects.equals(user.getPassword(), password)) {
                fireLoginEvent(new LoginSuccessEvent(this, user));
                return Objects.equals(user.getPassword(), password);
            } else {
                fireLoginEvent(new LoginFailureEvent(this, "Username oder Passwort inkorrekt."));
                return Objects.equals(user.getPassword(), password);
            }

        } catch(IllegalArgumentException i) {
            LOG.error("User konnte nicht gefunden werden: Passwort oder Username ist falsch.");
            fireLoginEvent(new LoginFailureEvent(this, "Username oder Passwort inkorrekt."));
            return false;
        }
    }

    public void addLoginServiceListener(LoginServiceListener listener) {
        this.loginServiceListeners.add(listener);
    }

    public void removeLoginServiceListener(LoginServiceListener listener) {
        this.loginServiceListeners.remove(listener);
    }

    private void fireLoginEvent(EventObject event) {
        for(LoginServiceListener listener: loginServiceListeners) {
            listener.handleLoginEvent(event);
        }
    }
}
