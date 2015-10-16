package com.hc.collections;

import com.hc.collections.utils.BenchmarkUtil;
import com.hc.collections.utils.TimeEnum;

public class MainApp {
    public static void main(String[] args) throws Exception {
        BenchmarkUtil.TimeBenchmark timeBenchmark =
                BenchmarkUtil.createTimeBenchmark(TimeEnum.NANO);

        timeBenchmark.start();
        timeBenchmark.end();

        System.out.println(timeBenchmark.getTime());
    }
}
