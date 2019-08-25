package behavioral.observer.implementation;

import behavioral.observer.Observer;
import behavioral.observer.Subject;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitVendor implements Subject {

    private Map<Fruit, Set<Observer>> fruitMap = new EnumMap<>(Fruit.class);

    public void register(Fruit fruit, Observer observer) {
        Set<Observer> observers = fruitMap.computeIfAbsent(fruit, v -> new HashSet<Observer>());
        observers.add(observer);
        notifyObserver(fruit, observer);
    }

    public void unregister(Fruit fruit, Observer observer) {
        Set<Observer> observers = fruitMap.get(fruit);
        if (observer != null) {
            observers.remove(observer);
        }
    }

    /**
     * Update the price for a given type of fruit
     *
     * @param fruit
     * @param price
     */
    public void updateFruitPrice(Fruit fruit, int price) {
        fruit.setPrice(price);
        notifyObservers(fruit);
    }

    /**
     * Notfiy all observers whenever a fruit type has a price update
     *
     * @param fruit Type of fruit which has had a price update
     */
    private void notifyObservers(Fruit fruit) {
        Set<Observer> observers = fruitMap.get(fruit);
        if (observers != null) {
            for (Observer observer : observers) {
                notifyObserver(fruit, observer);
            }
        }
    }

    @Override
    public void notifyObserver(Fruit fruit, Observer observer) {
        observer.update(fruit);
    }

    /**
     * Return a set of observers for a given fruit type
     */
    public Set<Observer> getObservers(Fruit fruit) {
        return fruitMap.get(fruit);
    }
}
