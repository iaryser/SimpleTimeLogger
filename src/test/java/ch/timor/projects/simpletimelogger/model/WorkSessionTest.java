package ch.timor.projects.simpletimelogger.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

class WorkSessionTest {

    @Test
    public void getCurrentWorkDurationTest() {
        WorkSession session = new WorkSession();
        assertEquals(Duration.ZERO, session.getCurrentWorkDuration());
    }

    @Test
    public void startWorkingTest() {
        Instant base = Instant.parse("2025-07-05T10:00:00Z");
        MutableClock testClock = new MutableClock(base, ZoneOffset.UTC);
        WorkSession session = new WorkSession(testClock);
        session.startWorking();
        testClock.forward(Duration.ofHours(3));
        assertEquals(Duration.ofHours(3), session.getCurrentWorkDuration());
    }

    @Test
    public void getCurrentPauseDurationTest() {
        WorkSession session = new WorkSession();
        assertEquals(Duration.ZERO, session.getCurrentPauseDuration());
    }

    @Test
    public void pauseWorkingTest() {
        Instant base = Instant.parse("2025-07-05T10:00:00Z");
        MutableClock testClock = new MutableClock(base, ZoneOffset.UTC);
        WorkSession session = new WorkSession(testClock);
        session.startWorking();
        session.pauseWorking();
        testClock.forward(Duration.ofMinutes(30));
        assertEquals(Duration.ofMinutes(30), session.getCurrentPauseDuration());
    }

    @Test
    public void resumeWorkingTest() {
        Instant base = Instant.parse("2025-07-05T10:00:00Z");
        MutableClock testClock = new MutableClock(base, ZoneOffset.UTC);
        WorkSession session = new WorkSession(testClock);
        session.startWorking();
        testClock.forward(Duration.ofHours(2));
        session.pauseWorking();
        testClock.forward(Duration.ofMinutes(30));
        session.resumeWork();
        testClock.forward(Duration.ofHours(2));
        assertEquals(Duration.ofHours(4), session.getCurrentWorkDuration());
        assertEquals(Duration.ofMinutes(30), session.getCurrentPauseDuration());
    }

    @Test
    public void pauseAndResumeWithoutStartWorking() {
        WorkSession session = new WorkSession();
        session.resumeWork();
        session.pauseWorking();
        assertEquals(Duration.ZERO, session.getCurrentPauseDuration());
        assertEquals(Duration.ZERO, session.getCurrentWorkDuration());
    }
}