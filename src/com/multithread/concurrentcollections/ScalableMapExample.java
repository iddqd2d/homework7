package com.multithread.concurrentcollections;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScalableMapExample {
    private static Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        concurrentHashMap.putIfAbsent(1, "one");
        concurrentHashMap.putIfAbsent(2, "two");
        concurrentHashMap.putIfAbsent(3, "three");

        new Thread(() -> concurrentHashMap.putIfAbsent(4, "four")).start();
        new Thread(() -> concurrentHashMap.forEach((k, v) -> System.out.println(k + " " + v))).start();
    }
}

