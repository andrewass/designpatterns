package behavioral.strategy;

public class InstantMessageNotification implements NotificationStrategy {

    @Override
    public String notifyUser(String username, String message) {
        return "Notifying "+username+" with message : "+message+", through Instant Message";
    }
}
