package com.hc.timebenchmark;

public class TimeBenchmarkUtils {
    public static String pattern = "### ### ### ### ###";

    private TimeBenchmarkUtils() {}

    public static Timer createTimer(TimeUnit timeUnit) {
        return new Timer(timeUnit);
    }

    public static MultipleTimer createMultipleTimer(TimeUnit timeUnit) {
        return new MultipleTimer(timeUnit);
    }
}
