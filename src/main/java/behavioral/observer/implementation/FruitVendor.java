package behavioral.observer.implementation;

import behavioral.observer.Observer;
import behavioral.observer.Subject;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of a Subject, a fruit vendor distributing updates
 * of changes in fruit prices
 */
public class FruitVendor implements Subject {

    private Map<Fruit, Set<Observer>> fruitMap = new EnumMap<>(Fruit.class);

    @Override
    public void register(Fruit fruit, Observer observer) {
        Set<Observer> observers = fruitMap.computeIfAbsent(fruit, v -> new HashSet<>());
        observers.add(observer);
        notifyObserver(fruit, observer);
    }

    @Override
    public void unregister(Fruit fruit, Observer observer) {
        Set<Observer> observers = fruitMap.get(fruit);
        if (observer != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void updateSubject(Fruit fruit, int updatedPrice){
        fruit.setPrice(updatedPrice);
        notifyObservers(fruit);
    }

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

    @Override
    public Set<Observer> getObservers(Fruit fruit) {
        return fruitMap.get(fruit);
    }
}
