package com.hc.collections;

import com.hc.timebenchmark.AverageIntervalTimer;
import com.hc.timebenchmark.TimeBenchmarkUtils;
import com.hc.timebenchmark.TimeUnit;

import java.util.ArrayList;
import java.util.Collection;

public class MainApp {
    private static int loops = 10;
    private static int N = 1_000_000;

    public static void main(String[] args) throws Exception {
        testArrayList();
    }

    public static void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        println("\t========== Benchmark for ArrayList ==========");

        AverageIntervalTimer time = TimeBenchmarkUtils.createAverageTimeBenchmark(TimeUnit.MS);
        println("1.\tAdd operation");
        time.start();

        for (int i = 0; i < loops; i++) {
            addNTimes(list, N);
            time.end();
        }

        println("Added " + N + " elements for " + loops + " times : "
                + time.getTime() + " " + time.getTimeUnit());
        println("Average time : " + time.getAverageTime());
    }

    public static void testLinkedList() {

    }

    public static void testHashMap() {

    }

    public static void testHashSet() {

    }

    public static void testTreeSet() {

    }

    private static void addNTimes(Collection<Integer> collection, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(i);
        }
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }
}
