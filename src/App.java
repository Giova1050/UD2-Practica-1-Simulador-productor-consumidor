import net.salesianos.store.Store;
import net.salesianos.threads.Farmer;
import net.salesianos.threads.Customer;

public class App {
    public static void main(String[] args) {
        Store store = new Store();

        Farmer paco = new Farmer(store, "Paco", 5);
        Farmer ramon = new Farmer(store, "Ramón", 5);

        Customer faustino = new Customer(store, "Faustino", 2);
        Customer gentleman = new Customer(store, "Mr. Gentleman", 3);
        Customer loquendo = new Customer(store, "Loquendo", 5);

        paco.start();
        ramon.start();
        faustino.start();
        gentleman.start();
        loquendo.start();
        
        try {
            paco.join();
            ramon.join();
            faustino.join(1000);
            gentleman.join(2000);
            loquendo.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
