package com.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class SingletonExample {
    private static volatile SingletonExample instance;
    private static final int DEFAULT_MONEY = 9;
    private int money;

    private SingletonExample(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static SingletonExample getInstance() {
        SingletonExample localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonExample.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonExample(DEFAULT_MONEY);
                }
            }
        }
        return localInstance;
    }
}
