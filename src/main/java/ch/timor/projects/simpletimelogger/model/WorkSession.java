package ch.timor.projects.simpletimelogger.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;

public class WorkSession {

    private LocalDateTime startWork;
    private LocalDateTime startPause;
    private Duration totalWork;
    private Duration totalPause;
    private boolean isWorking;
    private boolean isOnPause;
    private static final Logger LOG = LoggerFactory.getLogger(WorkSession.class);
    private final Clock clock;
    private Collection<SessionListener> sessionListeners = new ArrayList<>();

    public WorkSession() {
        this(Clock.systemDefaultZone());
    }

    WorkSession(Clock clock) {
        this.totalWork = Duration.ZERO;
        this.totalPause = Duration.ZERO;
        this.isWorking = false;
        isOnPause = false;
        this.clock = clock;
    }

    public void startWorking() {
        if(!isWorking) {
            this.startWork = LocalDateTime.now(clock);
            isWorking = true;
            this.fireSessionEvent(new SessionStartedEvent(this, this.startWork));
            LOG.info("Session started at: {}", this.startWork.toString());
        }
    }

    public void pauseWorking() {
        if(isWorking && !isOnPause) {
            this.startPause = LocalDateTime.now(clock);
            this.totalWork = totalWork.plus(Duration.between(this.startWork, LocalDateTime.now(clock)));
            isWorking = false;
            isOnPause = true;
            this.fireSessionEvent(new SessionPausedEvent(this, this.startPause, this.totalWork));
            LOG.info("Session paused at: {}", this.startPause.toString());
        }
    }
    public void resumeWork() {
        if(isOnPause && !isWorking) {
            this.startWork = LocalDateTime.now(clock);
            this.totalPause = totalPause.plus(Duration.between(this.startPause, LocalDateTime.now(clock)));
            isWorking = true;
            isOnPause = false;
            this.fireSessionEvent(new SessionResumedEvent(this, this.startWork, this.totalPause));
            LOG.info("Work resumed at: {}", this.startWork.toString());
        }
    }

    public Duration getCurrentWorkDuration() {
        if(isWorking) {
            return this.totalWork.plus(Duration.between(this.startWork, LocalDateTime.now(clock)));
        }
        return totalWork;
    }

    public Duration getCurrentPauseDuration() {
        if(isOnPause) {
            return this.totalPause.plus(Duration.between(this.startPause, LocalDateTime.now(clock)));
        }
        return totalPause;
    }

    public void resetSession() {
        this.startWork = null;
        this.startPause = null;
        this.totalWork = Duration.ZERO;
        this.totalPause = Duration.ZERO;
        this.isWorking = false;
        this.isOnPause = false;
        this.fireSessionEvent(new SessionResetEvent(this));
    }

    public void addSessionListener(SessionListener listener) {
        this.sessionListeners.add(listener);
    }

    public void removeSessionListener(SessionListener listener) {
        this.sessionListeners.remove(listener);
    }

    private void fireSessionEvent(EventObject event) {
        for(SessionListener listener : sessionListeners) {
            listener.handleSessionEvent(event);
        }
    }
}