package ch.timor.projects.simpletimelogger.model;

import java.util.EventObject;

public class RegisterEvent extends EventObject {
    String userName;
    String password;

    public RegisterEvent(Object source, String userName, String password) {
        super(source);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
}
