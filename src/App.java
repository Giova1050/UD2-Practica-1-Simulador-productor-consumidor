import net.salesianos.store.Store;
import net.salesianos.threads.Farmer;
import net.salesianos.threads.Customer;

public class App {
    public static void main(String[] args) {
        Store store = new Store();
        
        Farmer farmer1 = new Farmer(store, "Paco", 10);
        Farmer farmer2 = new Farmer(store, "Ramón", 10);

        Customer customer1 = new Customer(store, "Faustino", 5);
        Customer customer2 = new Customer(store, "Mr. Gentleman", 10);
        Customer customer3 = new Customer(store, "Loquendo", 5);

        farmer1.start();
        farmer2.start();
        customer1.start();
        customer2.start();
        customer3.start();
    }
}
