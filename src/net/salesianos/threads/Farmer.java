package net.salesianos.threads;

import net.salesianos.store.Store;

public class Farmer extends Thread {
    private Store store;
    private String name;
    private int vegetablesToPlant;

    public Farmer(Store store, String name, int vegetablesToPlant) {
        this.store = store;
        this.name = name;
        this.vegetablesToPlant = vegetablesToPlant;
    }

    private String[] vegetables = { "lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish",
            "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean" };
    
    private final int GROWTH_TIME = 3000;

    public int growthTime() {
        int growthTime = (int) Math.floor(Math.random() * GROWTH_TIME +1000);
        return growthTime > GROWTH_TIME  ? GROWTH_TIME : growthTime; 
    }

    public String getVegetable() {
        return vegetables[(int)(Math.random() * vegetables.length)];
    }

    public void start() {
       try {
        for (int i = 0; i < vegetablesToPlant; i++) {
            String vegetable = getVegetable();
            System.out.println(name + " planted a " + vegetable);
            Thread.sleep(growthTime());
            System.out.println("the " + vegetable + " has growth.");
            store.saveVegetables(vegetable);
        }
       } catch (Exception e) {
        e.printStackTrace();
       }
    }

   

}
