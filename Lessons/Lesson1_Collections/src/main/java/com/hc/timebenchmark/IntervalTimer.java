package com.hc.timebenchmark;

public class IntervalTimer {
    private TimeUnit timeUnit;
    private long start;
    private long end;
    private long time;

    public IntervalTimer(TimeUnit timeUnit) {
        if (timeUnit == null) {
            timeUnit = TimeUnit.NANO;
        }
        this.timeUnit = timeUnit;
    }

    public void start() {
        start = System.nanoTime();
        if (start > end) {
            end = start;
        }
    }

    public void end() {
        end = System.nanoTime();
        time = end - start;
    }

    public long getTime() {
        return getTime(timeUnit);
    }

    public long getTime(TimeUnit timeUnit) {
        long temp = time;
        if (timeUnit != null) {
            temp = getScaledTime(timeUnit);
        }

        return temp;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    private long getScaledTime(TimeUnit timeUnit) {
        return time / timeUnit.getScale();
    }
}