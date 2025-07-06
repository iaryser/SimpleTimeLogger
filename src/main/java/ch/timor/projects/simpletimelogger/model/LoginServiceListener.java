package ch.timor.projects.simpletimelogger.model;

import java.util.EventObject;

public interface LoginServiceListener {

    public void handleLoginEvent(EventObject event);
}
