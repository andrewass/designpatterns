package structural.facade;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {

    private Long customerId;
    private List<Order> orders = new ArrayList<>();

    public Customer(Long customerId){
        this.customerId = customerId;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
