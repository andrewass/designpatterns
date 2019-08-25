package behavioral.observer;


import behavioral.observer.implementation.Fruit;

import java.util.Set;

public interface Subject {

    /**
     * Register an observer to the subject
     *
     * @param fruit Type of fruit of the subscription
     * @param observer Instance of an observer
     */
    public void register(Fruit fruit, Observer observer);

    /**
     * Unregister an observer from the subject
     *
     * @param fruit Type of fruit of the subscription
     * @param observer Instance of an observer
     */
    public void unregister(Fruit fruit, Observer observer);

    /**
     * Notify an observer when state is changed. In this case when there has been a change in
     * price for a given fruit type.
     *
     * @param fruit Fruit type whose price has changed
     * @param observer Observer to be notified
     */
    public void notifyObserver(Fruit fruit, Observer observer);

    /**
     * Get all observers subscribing to a fruit type
     *
     * @param fruit Fruit type subscribed to
     */
    public Set<Observer> getObservers(Fruit fruit);

    /**
     * Performing an update of fruit price
     *
     * @param fruit Fruit type whose price has changed
     * @param updatedPrice Updated price of the given fruit type
     */
    public void updateSubject(Fruit fruit, int updatedPrice);
}

