package com.multithread.synchronizers;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static int permits = 2;
    private static Semaphore semaphore = new Semaphore(permits);

    public static void main(String[] args) {
        createThread("One");
        createThread("Two");
        createThread("Three");
    }


    private static void createThread(String name) {
        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println(name);
                Thread.sleep(500);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();
    }
}
