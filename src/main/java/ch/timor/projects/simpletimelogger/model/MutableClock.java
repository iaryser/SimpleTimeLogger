package ch.timor.projects.simpletimelogger.model;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class MutableClock extends Clock {

    private Instant instant;
    private final ZoneId zoneId;

    public MutableClock(Instant instant, ZoneId zoneId) {
        this.instant = instant;
        this.zoneId = zoneId;
    }

    public void forward(Duration duration) {
        this.instant = this.instant.plus(duration);
    }
    @Override
    public ZoneId getZone() {
        return zoneId;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return new MutableClock(this.instant, zone);
    }

    @Override
    public Instant instant() {
        return instant;
    }
}
