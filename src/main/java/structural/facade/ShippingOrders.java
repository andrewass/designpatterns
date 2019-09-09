package structural.facade;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ShippingOrders {

    private Map<LocalDate, List<Order>> ordersToShip;

    ShippingOrders() {
        ordersToShip = new HashMap<>();
    }

    public void placeOrder(Order order, LocalDate date) {
        List<Order> orders = ordersToShip.computeIfAbsent(date, k -> new ArrayList<>());
        orders.add(order);
    }
}
