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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
