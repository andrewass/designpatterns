package behavioral.observer.implementation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fruit {

    private FruitType fruitType;

    private int price;

    Fruit(FruitType fruitType, int price) {
        this.fruitType = fruitType;
        this.price = price;
    }
}
