package net.salesianos.threads;

import net.salesianos.store.Store;

public class Customer extends Thread {
    private Store store;
    private String name;
    private int vegetablesToConsume;

    public Customer(Store store, String name, int vegetablesToConsume) {
        this.store = store;
        this.name = name;
        this.vegetablesToConsume = vegetablesToConsume;
    }

    private final int CONSUME_TIME = 2000;

    private int consumeTime() {
        return (int) Math.floor(Math.random() * CONSUME_TIME + 1000);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < vegetablesToConsume; i++) {
                Thread.sleep(consumeTime());
                store.eatVegetables(name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
