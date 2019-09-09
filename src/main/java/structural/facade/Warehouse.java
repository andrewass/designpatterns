package structural.facade;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Warehouse {

    private Map<Long, Integer> products = new HashMap<>();

    public void addProduct(Long productId){
        int previousCount = products.computeIfAbsent(productId,  k -> 0);
        products.put(productId, previousCount+1);
    }

    public void reduceProductCount(Long productId) throws ProductCountIsZeroException {
        Integer count = products.get(productId);
        if(count == null || count == 0){
            throw new ProductCountIsZeroException("Zero count of product id :"+productId);
        }
        products.put(productId, count-1);
    }
}
