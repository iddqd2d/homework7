package com.multithread.atomics;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicsExample {
    private static final int defaultValueArray = 10;

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        AtomicLong atomicLong = new AtomicLong(Long.MAX_VALUE);
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(defaultValueArray);

        for (int i = 0; i < defaultValueArray; i++) {
            atomicIntegerArray.addAndGet(i, i);
        }
        atomicIntegerArray.addAndGet(1, 2);
        System.out.println(atomicIntegerArray);
    }
}
