package com.hc.timebenchmark;

public class TimeBenchmarkUtils {

    private TimeBenchmarkUtils() {}

    public static IntervalTimer createTimeBenchmark(TimeUnit timeUnit) {
        return new IntervalTimer(timeUnit);
    }

    public static AverageIntervalTimer createAverageTimeBenchmark(TimeUnit timeUnit) {
        return new AverageIntervalTimer(timeUnit);
    }
}
