package behavioral.observer;


import behavioral.observer.implementation.Fruit;

public interface Observer {

    /**
     * Update status for an Observer instance
     *
     * @param fruit Type of fruit which have updates
     */
    public void update(Fruit fruit);

}
