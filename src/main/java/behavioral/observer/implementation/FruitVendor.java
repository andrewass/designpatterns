package behavioral.observer.implementation;

import behavioral.observer.Observer;
import behavioral.observer.Subject;

import java.util.*;

public class FruitVendor implements Subject {

    private Map<FruitType, Set<Observer>> fruitMap = new HashMap<>();

    public void register(FruitType fruitType, Observer observer) {
        Set<Observer> observers = fruitMap.computeIfAbsent(fruitType, v -> new HashSet<Observer>());
        observers.add(observer);
    }

    public void unregister(FruitType fruitType, Observer observer) {
        //Set<Observer> observers = fruitMap
    }

    public void notifyObserver(FruitType fruitType, int updatedPrice) {

    }


    public void addFruit(FruitType fruitType, int price) {

    }
}
