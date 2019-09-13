package behavioral.strategy;

public class MailNotification implements NotificationStrategy {

    @Override
    public String notifyUser(String username, String message) {
        return "Notifying "+username+" with message : "+message+", through E-mail";
    }
}
