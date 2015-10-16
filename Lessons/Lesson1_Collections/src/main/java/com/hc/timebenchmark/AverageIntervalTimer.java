package com.hc.timebenchmark;

public class AverageIntervalTimer extends IntervalTimer {
    private long n;
    private long averageTime;

    public AverageIntervalTimer() {
        super(null);
    }

    public AverageIntervalTimer(TimeUnit timeUnit) {
        super(timeUnit);
    }

    @Override
    public void end() {
        super.end();
        n++;
    }

    public void reset() {
        n = 0;
    }

    public long getAverageTime() {
        long time = getTime();
        return n != 0 ? time / n : time;
    }
}
