package ru.itpark;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;

public class LruCacheBenchmark extends AbstractBenchmark {

    private LruCache<Integer, Integer> cache;
    private int count = 5_000_000;
    private int quantity = 1_000;

    @BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 10)
    @Test
    public void put() {
        cache = new LruCache<>(quantity);
        runTest();
    }

    @BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 10)
    @Test
    public void get() {
        cache = new LruCache<>(count);
        runTest();
        for (int i = 0; i < count; i++) {
            cache.get(i);
        }
    }

    private void runTest() {
        for (int i = 0; i < count; i++) {
            cache.put(i, i);
        }
    }
}