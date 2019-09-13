package behavioral;

import behavioral.strategy.InstantMessageNotification;
import behavioral.strategy.MailNotification;
import behavioral.strategy.User;
import behavioral.strategy.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyTest {

    private static Warehouse warehouse;
    private static final String USERNAME = "JohnDoe";
    private static final String MESSAGE = "Membership extended";

    @BeforeEach
    void init(){
        warehouse = new Warehouse();
    }

    @Test
    void shouldAttachInstantMessageNotificationToUser(){
        warehouse.addUser(new User(USERNAME), new InstantMessageNotification());
        String expected = "Notifying "+USERNAME+" with message : "+ MESSAGE +", through Instant Message";
        assertEquals(expected, warehouse.generateUserNotification(USERNAME, MESSAGE));
    }

    @Test
    void shouldAttachMailNotificationToUser(){
        warehouse.addUser(new User(USERNAME), new MailNotification());
        String expected = "Notifying "+USERNAME+" with message : "+ MESSAGE +", through E-mail";
        assertEquals(expected, warehouse.generateUserNotification(USERNAME, MESSAGE));
    }
}
