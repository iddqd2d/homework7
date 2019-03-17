package com.multithread.synchronizers;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static int permits = 2;
    private static CyclicBarrier barrier =
            new CyclicBarrier(permits, new Thread(() -> System.out.println("GO")));

    public static void main(String[] args) {
        new Horse().start();
        new Horse().start();
    }


    static class Horse extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Wait for you");
                CyclicBarrierExample.barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
