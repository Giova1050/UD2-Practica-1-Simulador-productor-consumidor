import net.salesianos.store.Store;
import net.salesianos.threads.Farmer;
import net.salesianos.threads.Customer;

public class App {
    public static void main(String[] args) {
        Store store = new Store();

        Farmer paco = new Farmer(store, "Paco", 5);

        Customer faustino = new Customer(store, "Faustino", 5);

        paco.start();
        faustino.start();
        
        try {
            paco.join();
            faustino.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
