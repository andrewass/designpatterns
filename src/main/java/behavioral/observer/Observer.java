package behavioral.observer;


import behavioral.observer.implementation.FruitType;

public interface Observer {

    public void update(FruitType fruitType, int updatedPrice);

}
