package structural.facade;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
public class OrderFacade {

    private final Map<Long, Customer> customers = new HashMap<>();
    private final ShippingOrders shippingOrders;
    private final Logger logger = LoggerFactory.getLogger(OrderFacade.class);
    private Warehouse warehouse;

    public OrderFacade() {
        warehouse = new Warehouse();
        shippingOrders = new ShippingOrders();
    }

    public void placeOrder(Long customerId, Long productId, LocalDate orderDate) {
        try {
            warehouse.reduceProductCount(productId);
            Order order = new Order(customerId, productId);
            Customer customer = customers.computeIfAbsent(customerId, k -> new Customer(customerId));
            customer.addOrder(order);
            shippingOrders.placeOrder(order, orderDate.plusDays(3));
        } catch (ProductCountIsZeroException e) {
            logger.error(e.getMessage());
        }
    }
}
