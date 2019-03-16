package com.multithread.concurrentcollections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {

    public static void main(String args[]) {

        List<Integer> list = new CopyOnWriteArrayList(Arrays.asList(1, 2, 3));

        new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            int i = 4;
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                list.add(i++);
                list.remove(element);
            }
        }
        ).start();

        new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        ).start();
    }
}
