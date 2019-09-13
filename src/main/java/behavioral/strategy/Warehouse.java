package behavioral.strategy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private Map<String, Pair<User, NotificationStrategy>> userNotificationStrategies = new HashMap<>();

    public void addUser(User user, NotificationStrategy notificationStrategy) {
        userNotificationStrategies.put(user.getUsername(), new Pair<>(user, notificationStrategy));
    }

    public String generateUserNotification(String username, String message){
        NotificationStrategy notificationStrategy = userNotificationStrategies.get(username).getValue();
        return notificationStrategy.notifyUser(username, message);
    }
}
