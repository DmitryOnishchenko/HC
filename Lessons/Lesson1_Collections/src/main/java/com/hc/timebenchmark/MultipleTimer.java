package com.hc.timebenchmark;

import com.google.common.base.Joiner;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MultipleTimer {
    private int current;
    private TimeUnit timeUnit;
    private ArrayList<Timer> timers;

    public MultipleTimer() {
        this(TimeUnit.NANO);
    }

    public MultipleTimer(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        timers = new ArrayList<>();
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void start() {
        Timer timer = new Timer(timeUnit);
        timers.add(timer);
        timer.start();
    }

    public void end() {
        timers.get(current++).end();
    }

    public long getTime() {
        long time = 0;
        for (Timer t : timers) {
            time += t.getTime();
        }

        return time;
    }

    public String printTime() {
        return NumberFormat.getNumberInstance().format(getTime());
    }

    public long getMin() {
        long min = timers.get(0).getTime();
        for (int i = 1; i < timers.size(); i++) {
            long time = timers.get(i).getTime();
            if (time < min) {
                min = time;
            }
        }

        return min;
    }

    public String printMin() {
        return NumberFormat.getNumberInstance().format(getMin());
    }

    public long getMax() {
        long max = timers.get(0).getTime();
        for (int i = 1; i < timers.size(); i++) {
            long time = timers.get(i).getTime();
            if (time > max) {
                max = time;
            }
        }

        return max;
    }

    private String printMax() {
        return NumberFormat.getNumberInstance().format(getMax());
    }

    public long getAverage() {
        return getTime() / timers.size();
    }

    private String printAverage() {
        return NumberFormat.getNumberInstance().format(getAverage());
    }

    public String report() {
        return Joiner.on("").join("[Min] [Average] [Max] : [",
                printMin(), "] [", printAverage(), "] [", printMax(), "]");
    }
}
