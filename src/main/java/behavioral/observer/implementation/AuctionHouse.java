package behavioral.observer.implementation;

import behavioral.observer.Observer;
import behavioral.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class AuctionHouse implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    public void register(Observer observer) {

    }

    public void unregister(Observer observer) {

    }

    public void notifyObserver() {

    }
}
