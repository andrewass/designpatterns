package behavioral.observer;


import behavioral.observer.implementation.FruitType;

public interface Subject {

    /**
     * Register an observer to the subject
     *
     * @param observer
     */
    public void register(FruitType fruitType, Observer observer);

    /**
     * Unregister an observer from the subject
     *
     * @param observer
     */
    public void unregister(FruitType fruitType, Observer observer);

    /**
     * Notify all observers when state is changed. In this case when there has been a change in
     * price for a given fruit type.
     *
     * @param fruitType FruitType whose price has changed
     * @param updatedPrice Updated price of the fruit type
     */
    public void notifyObserver(FruitType fruitType, int updatedPrice);
}

