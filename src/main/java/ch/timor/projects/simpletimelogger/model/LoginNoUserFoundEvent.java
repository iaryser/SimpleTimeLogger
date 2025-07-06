package ch.timor.projects.simpletimelogger.model;

import java.util.EventObject;

public class LoginNoUserFoundEvent extends EventObject {

    public LoginNoUserFoundEvent(Object source) {
        super(source);
    }
}
