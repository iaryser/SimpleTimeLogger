package ch.timor.projects.simpletimelogger.model;

import java.time.LocalDateTime;
import java.util.EventObject;

public class SessionStartedEvent extends EventObject {

    private final LocalDateTime timeStamp;

    public SessionStartedEvent(Object source, LocalDateTime timeStamp) {
        super(source);
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

}
