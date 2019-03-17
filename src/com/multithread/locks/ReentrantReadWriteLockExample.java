package com.multithread.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        new Horse().start();
        new Horse().start();
        new Horse().start();
    }


    static class Horse extends Thread {
        @Override
        public void run() {
            try {
                lock.readLock().lock();
                System.out.println("Read content");
                sleep(5000);
                lock.readLock().unlock();

                lock.writeLock().lock();
                System.out.println("Write content");
                sleep(5000);
                lock.writeLock().unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
