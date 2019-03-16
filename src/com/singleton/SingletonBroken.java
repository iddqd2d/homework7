package com.singleton;

import java.lang.reflect.Constructor;

public class SingletonBroken {
    public static void main(String[] args) {
        SingletonExample singletonExample = SingletonExample.getInstance();
        SingletonExample hacked = singletonExample;


        try {
            Constructor[] constructors =
                    SingletonExample.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                hacked = (SingletonExample) constructor.newInstance(9999);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(singletonExample.getMoney());
        System.out.println(hacked.getMoney());
    }
}
