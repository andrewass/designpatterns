package behavorial;


import behavioral.observer.Observer;
import behavioral.observer.Subject;
import behavioral.observer.implementation.Customer;
import behavioral.observer.implementation.FruitVendor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static behavioral.observer.implementation.Fruit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ObserverTest {

    private List<Observer> observers;
    private Subject fruitVendor;

    @Test
    void shouldRegisterObserversToSubject() {
        fruitVendor = new FruitVendor();
        addObservers();

        assertEquals(4, fruitVendor.getObservers(APPLE).size());
        assertEquals(2, fruitVendor.getObservers(BANANA).size());
        assertEquals(1, fruitVendor.getObservers(PEAR).size());
        assertEquals(1, fruitVendor.getObservers(GRAPEFRUIT).size());
        assertNull(fruitVendor.getObservers(ORANGE));
    }

    @Test
    void shouldUnregisterObserversFromSubject() {
        fruitVendor = new FruitVendor();
        addObservers();

        fruitVendor.unregister(APPLE, observers.get(0));
        fruitVendor.unregister(APPLE, observers.get(2));

        fruitVendor.unregister(GRAPEFRUIT, observers.get(2));

        assertEquals(2, fruitVendor.getObservers(APPLE).size());
        assertEquals(0, fruitVendor.getObservers(GRAPEFRUIT).size());
    }

    private void addObservers() {
        observers = new ArrayList<>();
        observers.add(new Customer(1));
        observers.add(new Customer(2));
        observers.add(new Customer(3));
        observers.add(new Customer(4));

        fruitVendor.register(APPLE, observers.get(0));
        fruitVendor.register(BANANA, observers.get(0));

        fruitVendor.register(APPLE, observers.get(1));

        fruitVendor.register(GRAPEFRUIT, observers.get(2));
        fruitVendor.register(APPLE, observers.get(2));
        fruitVendor.register(PEAR, observers.get(2));

        fruitVendor.register(APPLE, observers.get(3));
        fruitVendor.register(BANANA, observers.get(3));
    }
}
