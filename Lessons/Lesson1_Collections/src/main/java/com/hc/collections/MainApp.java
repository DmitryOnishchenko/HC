package com.hc.collections;

import com.hc.timebenchmark.MultipleTimer;
import com.hc.timebenchmark.TimeBenchmarkUtils;
import com.hc.timebenchmark.TimeUnit;
import com.hc.timebenchmark.Timer;

import java.util.*;

public class MainApp {
    private static int loops = 20;
    private static int N = 1_000_000;

    public static void main(String[] args) throws Exception {
        /* List */
        testList(ArrayList.class);
        testList(FastRemoveArrayList.class);
        testList(LinkedList.class);

        /* Set */
        testSet(HashSet.class);
    }

    public static void testList(Class<?> cl) throws Exception{
        //noinspection unchecked
        List<Integer> list = (List<Integer>) cl.newInstance();
        println("\t========== Benchmark for " + cl.getSimpleName() + " ==========");

        /* Add */
        println("1.\tAdd operation (MS)");
        MultipleTimer timer = TimeBenchmarkUtils.createMultipleTimer(TimeUnit.MS);

        for (int i = 0; i < loops; i++) {
            timer.start();
            addNTimes(list, N);
            timer.end();

            //noinspection unchecked
            list = (List<Integer>) cl.newInstance();
        }

        println("Added " + N + " elements for " + loops + " times : " + timer.printTime() + " " + timer.getTimeUnit());
        println(timer.report());
        println("");

        /* Get index */
        println("1.\tGet index operation (NANO)");
        timer = TimeBenchmarkUtils.createMultipleTimer(TimeUnit.NANO);

        addNTimes(list, N);

        for (int i = 0; i < loops; i++) {
            timer.start();
            list.get(N / 2);
            timer.end();
        }

        println("Get " + N / 2 + " element for " + loops + " times : " + timer.printTime() + " " + timer.getTimeUnit());
        println(timer.report());
        println("");

        /* Remove */
        println("1.\tRemove operation (NANO)");
        timer = TimeBenchmarkUtils.createMultipleTimer(TimeUnit.NANO);

        for (int i = 0; i < loops; i++) {
            addNTimes(list, N);

            timer.start();
            list.remove(N / 2);
            timer.end();

            list = (List<Integer>) cl.newInstance();
        }

        println("Remove " + N / 2 + " element for " + loops + " times : " + timer.printTime() + " " + timer.getTimeUnit());
        println(timer.report());
        println("");

        /* Remove every 2 */
        println("1.\tRemove operation - every 2 (NANO)");
        Timer simpleTimer = TimeBenchmarkUtils.createTimer(TimeUnit.NANO);

        addNTimes(list, N / 2);

        Iterator<Integer> iter = list.iterator();
        int j = 0;
        simpleTimer.start();
        while (iter.hasNext()) {
            iter.next();
            if (j % 2 == 0) {
                iter.remove();
            }
            j++;
        }
        simpleTimer.end();

        println("Remove every 2 element : " + simpleTimer.printTime() + " " + simpleTimer.getTimeUnit());
        println("");

        /* Iterate */
        println("1.\tIterate operation (NANO)");
        timer = TimeBenchmarkUtils.createMultipleTimer(TimeUnit.NANO);

        addNTimes(list, N);

        for (int i = 0; i < loops; i++) {
            timer.start();
            for (Integer integer : list) {

            }
            timer.end();
        }

        println("Iterate over list for " + loops + " times : " + timer.printTime() + " " + timer.getTimeUnit());
        println(timer.report());
        println("\n");
    }

    public static void testSet(Class cl) throws Exception {
        //noinspection unchecked
        Set<Integer> list = (Set<Integer>) cl.newInstance();
        println("\t========== Benchmark for " + cl.getSimpleName() + " ==========");

        /* Add */
        println("1.\tAdd operation (MS)");
        MultipleTimer timer = TimeBenchmarkUtils.createMultipleTimer(TimeUnit.MS);

        for (int i = 0; i < loops; i++) {
            timer.start();
            addNTimes(list, N);
            timer.end();

            //noinspection unchecked
            list = (Set<Integer>) cl.newInstance();
        }

        println("Added " + N + " elements for " + loops + " times : " + timer.printTime() + " " + timer.getTimeUnit());
        println(timer.report());
        println("");

                /* Remove */
        println("1.\tRemove operation (NANO)");
        timer = TimeBenchmarkUtils.createMultipleTimer(TimeUnit.NANO);

        for (int i = 0; i < loops; i++) {
            addNTimes(list, N);

            timer.start();
            list.remove(N / 2);
            timer.end();

            list = (Set<Integer>) cl.newInstance();
        }

        println("Remove " + N / 2 + " element for " + loops + " times : " + timer.printTime() + " " + timer.getTimeUnit());
        println(timer.report());
        println("");

        /* Remove every 2 */
        println("1.\tRemove operation - every 2 (NANO)");
        Timer simpleTimer = TimeBenchmarkUtils.createTimer(TimeUnit.NANO);

        addNTimes(list, N / 2);

        Iterator<Integer> iter = list.iterator();
        int j = 0;
        simpleTimer.start();
        while (iter.hasNext()) {
            iter.next();
            if (j % 2 == 0) {
                iter.remove();
            }
            j++;
        }
        simpleTimer.end();

        println("Remove every 2 element : " + simpleTimer.printTime() + " " + simpleTimer.getTimeUnit());
        println("");

        /* Iterate */
        println("1.\tIterate operation (NANO)");
        timer = TimeBenchmarkUtils.createMultipleTimer(TimeUnit.NANO);

        addNTimes(list, N);

        for (int i = 0; i < loops; i++) {
            timer.start();
            for (Integer integer : list) {

            }
            timer.end();
        }

        println("Iterate over list for " + loops + " times : " + timer.printTime() + " " + timer.getTimeUnit());
        println(timer.report());
        println("\n");
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
