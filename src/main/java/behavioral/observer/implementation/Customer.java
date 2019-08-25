package behavioral.observer.implementation;

import behavioral.observer.Observer;
import lombok.Getter;

import java.util.*;

/**
 * Implementation of an Observer, a customer subscribing to updates in fruit prices
 */
@Getter
public class Customer implements Observer {

    private int id;
    private Map<Fruit, List<Integer>> priceHistory = new EnumMap<>(Fruit.class);

    public Customer(int id) {
        this.id = id;
    }

    @Override
    public void update(Fruit fruit) {
        List<Integer> history = priceHistory.computeIfAbsent(fruit,  v ->  new ArrayList<Integer>());
        history.add(fruit.getPrice());
    }

    @Override
    public List<Integer> getSubscriptionHistory(Fruit fruit) {
        return priceHistory.get(fruit);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Customer) {
            Customer other = (Customer) object;
            return id == other.id;
        }
        return false;
    }
}
