package behavioral.strategy;

@FunctionalInterface
public interface NotificationStrategy {

    public String notifyUser(String username, String message);
    
}
