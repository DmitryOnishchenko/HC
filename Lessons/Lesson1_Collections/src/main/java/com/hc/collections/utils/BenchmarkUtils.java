package com.hc.collections.utils;

public class BenchmarkUtils {

    private BenchmarkUtils() {}

    public static TimeBenchmark createTimeBenchmark(TimeEnum timeEnum) {
        return new TimeBenchmark(timeEnum);
    }

    public static AverageTimeBenchmark createAverageTimeBenchmark(TimeEnum timeEnum) {
        return new AverageTimeBenchmark(timeEnum);
    }
}
