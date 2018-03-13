package ru.javaops.masterjava.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JmhSample3 {
    @State(Scope.Benchmark)
    public static class BenchmarkState {
        volatile double x = Math.PI;
    }
    @State(Scope.Thread)
    public static class ThreadState {
        volatile double x = Math.PI;
    }
    @Benchmark
    public void measureUnshared(ThreadState state) {
        // All benchmark threads will call in this method.
        //
        // However, since ThreadState is the Scope.Thread, each thread
        // will have it's own copy of the state, and this benchmark
        // will measure unshared case.
        state.x++;
    }
    @Benchmark
    public void measureShared(BenchmarkState state) {
        // All benchmark threads will call in this method.
        //
        // Since BenchmarkState is the Scope.Benchmark, all threads
        // will share the state instance, and we will end up measuring
        // shared case.
        state.x++;
    }
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JmhSample3.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .threads(4)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
