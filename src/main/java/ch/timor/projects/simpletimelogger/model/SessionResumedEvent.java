package ch.timor.projects.simpletimelogger.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.EventObject;

public class SessionResumedEvent extends EventObject {

    private LocalDateTime workStartTimestamp;
    private Duration totalPause;

    public SessionResumedEvent(Object source, LocalDateTime workStartTimestamp, Duration totalPause) {
        super(source);
        this.workStartTimestamp = workStartTimestamp;
        this.totalPause = totalPause;
    }

    public LocalDateTime getWorkStartTimestamp() {
        return this.workStartTimestamp;
    }

    public Duration getTotalPause() {
        return this.totalPause;
    }
}
