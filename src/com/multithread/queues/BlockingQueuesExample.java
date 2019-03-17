package com.multithread.queues;


import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueuesExample {

    private static BlockingQueue<String> queue = new PriorityBlockingQueue<>();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> queue.add(new Scanner(System.in).next())).start();
    }
}
