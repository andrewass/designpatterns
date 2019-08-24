package behavioral.observer.implementation;

import behavioral.observer.Observer;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Customer implements Observer {

    int id;
    private Map<FruitType, Fruit> fruits = new HashMap<FruitType, Fruit>();

    Customer(int id) {
        this.id = id;
    }

    public void update(FruitType fruitType, int updatedPrice) {
        Fruit fruit = fruits.get(fruitType);
        if (fruit != null) {
            fruit.setPrice(updatedPrice);
            fruits.put(fruitType, fruit);
        }
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
