package com.hc.collections.utils;

public class BenchmarkUtil {

    private BenchmarkUtil() {}

    public static TimeBenchmark createTimeBenchmark() {
        return new TimeBenchmark(null);
    }

    public static TimeBenchmark createTimeBenchmark(TimeEnum timeEnum) {
        return new TimeBenchmark(timeEnum);
    }

    public static class TimeBenchmark {
        private TimeEnum timeEnum;
        private long start;
        private long end;
        private long time;

        public TimeBenchmark(TimeEnum timeEnum) {
            this.timeEnum = timeEnum;
        }

        public void start() {
            start = System.nanoTime();
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

        public void setTimeEnum(TimeEnum timeEnum) {
            this.timeEnum = timeEnum;
        }

        private long getScaledTime(TimeEnum timeEnum) {
            return time / timeEnum.getScale();
        }
    }
}
