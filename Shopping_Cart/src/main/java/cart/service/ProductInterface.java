package cart.service;

import cart.model.Product;

import java.util.List;

public interface ProductInterface {

    public List<Product> allProduct();

    Product add(Product product);

    Product update(Product product);
    
    Product findByID(Long id);
    void deleteByID(Long id);
}
