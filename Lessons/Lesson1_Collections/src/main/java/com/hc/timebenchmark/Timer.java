package com.hc.timebenchmark;

import com.google.common.base.Joiner;

import java.text.NumberFormat;

public class Timer {
    private TimeUnit timeUnit;
    private long start;
    private long end;
    private long time;

    public Timer(TimeUnit timeUnit) {
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

    public String printTime() {
        return NumberFormat.getNumberInstance().format(time);
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

    public String report() {
        return Joiner.on("").join("Time[", printTime(), "]");
    }
}