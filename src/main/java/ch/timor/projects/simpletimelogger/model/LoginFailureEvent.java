package ch.timor.projects.simpletimelogger.model;

import java.util.EventObject;

public class LoginFailureEvent extends EventObject {
    private String reason;

    public LoginFailureEvent(Object source, String reason) {
        super(source);
        this.source = source;
    }

    public String getReason() {
        return this.reason;
    }
}
