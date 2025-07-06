package ch.timor.projects.simpletimelogger.model;

import jdk.jfr.Event;

import java.util.EventObject;

public interface UserDataBaseListener {
    public void handleRegisterEvent(EventObject event);
}
