package com.multithread.atomics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicsExample {
    private static final int defaultValue = 0;
    private static int counter;
    private static AtomicInteger counterAtomic = new AtomicInteger(defaultValue);


    public static void main(String[] args) throws InterruptedException {
        IntStream.range(defaultValue, Byte.MAX_VALUE).forEach(i -> new Thread(() -> {
            increment();
            counterAtomic.incrementAndGet();
        }).start());

        Thread.sleep(1000);
        System.out.println(counter);
        System.out.println(counterAtomic);
    }

    public static void increment() {
        counter++;
    }
}
