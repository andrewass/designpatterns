package structural;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structural.facade.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeTest {

    private static final long CUSTOMER_ID = 222;
    private static final long PRODUCT_ID = 555;
    private static final LocalDate ORDER_DATE = LocalDate.now();
    private static OrderFacade orderFacade;

    @BeforeEach
    void init() {
        orderFacade = new OrderFacade();
    }

    @Test
    void shouldPlaceAndStoreOrder() {
        Warehouse warehouse = orderFacade.getWarehouse();
        warehouse.addProduct(PRODUCT_ID);

        orderFacade.placeOrder(CUSTOMER_ID, PRODUCT_ID, ORDER_DATE);
        Customer customer = orderFacade.getCustomers().get(CUSTOMER_ID);
        Order order = customer.getOrders().get(0);
        ShippingOrders shippingOrders = orderFacade.getShippingOrders();
        Order shippingOrder = shippingOrders.getOrdersToShip().get(ORDER_DATE.plusDays(3)).get(0);

        assertEquals(CUSTOMER_ID, customer.getCustomerId());
        assertEquals(CUSTOMER_ID, order.getCustomerId());
        assertEquals(PRODUCT_ID, order.getProductId());

        assertEquals(0, warehouse.getProducts().get(PRODUCT_ID));
        assertEquals(shippingOrder, order);
    }

    @Test
    void shouldThrowExceptionWhenProductNotFoundInWarehouse() {
        Warehouse warehouse = new Warehouse();
        Assertions.assertThrows(ProductCountIsZeroException.class, () ->
                warehouse.reduceProductCount(PRODUCT_ID));
    }
}

