package ch.timor.projects.simpletimelogger.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.EventObject;

public class SessionPausedEvent extends EventObject {

    private final LocalDateTime pauseStart;
    private final Duration totalWork;


    public SessionPausedEvent(Object source, LocalDateTime pauseStart, Duration totalWork) {
        super(source);
        this.pauseStart = pauseStart;
        this.totalWork = totalWork;
    }

    public LocalDateTime getPauseStart() {
        return this.pauseStart;
    }

    public Duration getTotalWork() {
        return this.totalWork;
    }
}
