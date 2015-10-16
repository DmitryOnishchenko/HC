package com.hc.collections.utils;

public class AverageTimeBenchmark extends TimeBenchmark {
    private long n;
    private long averageTime;

    public AverageTimeBenchmark() {
        super(null);
    }

    public AverageTimeBenchmark(TimeEnum timeEnum) {
        super(timeEnum);
    }

    @Override
    public void end() {
        super.end();
        n++;
    }

    @Override
    public void reset() {
        super.reset();
        n = 0;
    }

    public long getAverageTime() {
        long time = getTime();
        return n != 0 ? time / n : time;
    }
}
