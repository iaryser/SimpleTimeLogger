package ch.timor.projects.simpletimelogger.model;

import java.util.EventObject;

public interface SessionListener {

    public void handleSessionEvent(EventObject event);
}
