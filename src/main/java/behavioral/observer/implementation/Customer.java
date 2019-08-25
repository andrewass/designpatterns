package behavioral.observer.implementation;

import behavioral.observer.Observer;
import lombok.Getter;

import java.util.*;

@Getter
public class Customer implements Observer {

    int id;
    private Map<Fruit, List<Integer>> priceHistory = new EnumMap<>(Fruit.class);

    public Customer(int id) {
        this.id = id;
    }

    public void update(Fruit fruitType) {
        List<Integer> history = priceHistory.computeIfAbsent(fruitType,  v ->  new ArrayList<Integer>());
        history.add(fruitType.getPrice());
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
