package com.hc.collections.utils;

public class TimeBenchmark {
    private TimeEnum timeEnum;
    private long start;
    private long end;
    private long time;

    public TimeBenchmark(TimeEnum timeEnum) {
        if (timeEnum == null) {
            timeEnum = TimeEnum.NANO;
        }
        this.timeEnum = timeEnum;
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
        return getTime(timeEnum);
    }

    public long getTime(TimeEnum timeEnum) {
        long temp = time;
        if (timeEnum != null) {
            temp = getScaledTime(timeEnum);
        }

        return temp;
    }

    public TimeEnum getTimeEnum() {
        return timeEnum;
    }

    public void setTimeEnum(TimeEnum timeEnum) {
        this.timeEnum = timeEnum;
    }

    public void reset() {
        start = getTime();
        end = start;
        time = 0;
    }

    private long getScaledTime(TimeEnum timeEnum) {
        return time / timeEnum.getScale();
    }
}