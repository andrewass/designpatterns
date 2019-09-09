package structural.facade;

import lombok.Data;

@Data
public class Order {

    private Long customerId;
    private Long productId;

    public Order(Long customerId, Long productId){
        this.customerId = customerId;
        this.productId = productId;
    }
}
