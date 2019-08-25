package behavorial;


import behavioral.observer.Observer;
import behavioral.observer.Subject;
import behavioral.observer.implementation.Customer;
import behavioral.observer.implementation.FruitVendor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static behavioral.observer.implementation.Fruit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ObserverTest {

    private List<Observer> observers;
    private Subject fruitVendor;

    @BeforeEach
    void init() {
        APPLE.setPrice(28);
        fruitVendor = new FruitVendor();
        addObservers();
    }

    @Test
    void shouldRegisterObserversToSubject() {
        assertEquals(4, fruitVendor.getObservers(APPLE).size());
        assertEquals(2, fruitVendor.getObservers(BANANA).size());
        assertEquals(1, fruitVendor.getObservers(PEAR).size());
        assertEquals(1, fruitVendor.getObservers(GRAPEFRUIT).size());
        assertNull(fruitVendor.getObservers(ORANGE));
    }

    @Test
    void shouldUnregisterObserversFromSubject() {
        fruitVendor.unregister(APPLE, observers.get(0));
        fruitVendor.unregister(APPLE, observers.get(2));

        fruitVendor.unregister(GRAPEFRUIT, observers.get(2));

        assertEquals(2, fruitVendor.getObservers(APPLE).size());
        assertEquals(0, fruitVendor.getObservers(GRAPEFRUIT).size());
    }

    @Test
    void shouldUpdatePriceHistoryWhenUpdateOfFruitPrice() {
        Observer observer = observers.get(3);

        fruitVendor.updateSubject(APPLE, 49);
        fruitVendor.updateSubject(APPLE, 48);

        List<Integer> appleHistory = observer.getSubscriptionHistory(APPLE);
        List<Integer> bananaHistory = observer.getSubscriptionHistory(BANANA);

        assertEquals(3, appleHistory.size());
        assertEquals(28, appleHistory.get(0));
        assertEquals(49, appleHistory.get(1));
        assertEquals(48, appleHistory.get(2));

        assertEquals(1, bananaHistory.size());
        assertEquals(24, bananaHistory.get(0));
    }

    @Test
    void shouldNotUpdatePriceHistoryAfterUnSubscribingToFruitType() {
        Observer observer = observers.get(3);

        fruitVendor.updateSubject(APPLE, 49);
        fruitVendor.updateSubject(APPLE, 48);

        fruitVendor.unregister(APPLE, observer);

        fruitVendor.updateSubject(APPLE, 53);

        List<Integer> history = observer.getSubscriptionHistory(APPLE);
        assertEquals(3, history.size());
        assertEquals(28, history.get(0));
        assertEquals(49, history.get(1));
        assertEquals(48, history.get(2));
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
