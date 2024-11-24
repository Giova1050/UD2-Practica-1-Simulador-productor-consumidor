package net.salesianos.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
   
    List<String> store = new ArrayList<>();
    
    public synchronized void saveVegetables(String vegetable) {
        try {
            while (store.size() == 10) {
                System.out.println("The store is full");
                wait();
            }
            store.add(vegetable);
            System.out.println(vegetable + " saved");
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void eatVegetables(String name) {
        try {
            while (store.isEmpty()) {
                System.out.println("store empty...");
                wait();
            }
            String vegetable = store.remove(0);
            System.out.println(name + " ate " + vegetable);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
