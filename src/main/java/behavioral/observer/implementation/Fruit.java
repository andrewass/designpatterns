package behavioral.observer.implementation;

public enum Fruit {

    ORANGE(30),
    APPLE(28),
    BANANA(24),
    GRAPEFRUIT(51),
    PEAR(31);

    private int price;

    Fruit(int price) {
        this.price = price;
    }

    Integer getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

}
