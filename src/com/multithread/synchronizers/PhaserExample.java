package com.multithread.synchronizers;

import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class PhaserExample {
    private static int parties = 1;
    private static final Phaser PHASER = new Phaser(parties);

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            if ((int) (Math.random() * 2) > 0)
                passengers.add(new Passenger(i, i + 1));

            if ((int) (Math.random() * 2) > 0)
                passengers.add(new Passenger(i, 5));
        }

        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    System.out.println("Bus lest the park");
                    PHASER.arrive();//В фазе 0 всего 1 участник - автобус
                    break;
                case 6:
                    System.out.println("Bus goes to the park");
                    PHASER.arriveAndDeregister();//Снимаем главный поток, ломаем барьер
                    break;
                default:
                    int currentBusStop = PHASER.getPhase();
                    System.out.println("Bus stop # " + currentBusStop);

                    for (Passenger p : passengers)
                        if (p.departure == currentBusStop) {
                            PHASER.register();
                            p.start();
                        }

                    PHASER.arriveAndAwaitAdvance();
            }
        }
    }

    public static class Passenger extends Thread {
        private int departure;
        private int destination;

        public Passenger(int departure, int destination) {
            this.departure = departure;
            this.destination = destination;
            System.out.println(this + " wait at the bus stop # " + this.departure);
        }

        @Override
        public void run() {
            try {
                System.out.println(this + " in the bus");

                while (PHASER.getPhase() < destination)
                    PHASER.arriveAndAwaitAdvance();

                Thread.sleep(1);
                System.out.println(this + " left the bus");
                PHASER.arriveAndDeregister();
            } catch (InterruptedException e) {
            }
        }

        @Override
        public String toString() {
            return "Passenger " + departure + " -> " + destination;
        }
    }
}
