package ch.timor.projects.simpletimelogger.model;

import java.util.EventObject;

public class LoginSuccessEvent extends EventObject {

    private User user;

    public LoginSuccessEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }
}
