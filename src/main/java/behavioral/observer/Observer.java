package behavioral.observer;


import behavioral.observer.implementation.Fruit;

import java.util.List;

public interface Observer {

    /**
     * Update status for an Observer instance
     *
     * @param fruit Type of fruit which have updates
     */
    public void update(Fruit fruit);

    /**
     * Get the history of updates to subject subscribed to.
     *
     * @param fruit Type of the fruit which history is retrieved
     */
    public List<Integer> getSubscriptionHistory(Fruit fruit);
}
