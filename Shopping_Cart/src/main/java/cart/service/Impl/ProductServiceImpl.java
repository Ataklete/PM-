package cart.service.Impl;

import cart.model.Product;
import cart.repository.ProductRepository;
import cart.service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductInterface {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> allProduct() {
       return productRepository.findAll() ;
    }

    @Override
    public Product add(Product product) {
        Product products = productRepository.save(product);
        return products;
    }

    @Override
    public Product update(Product product) {
        Product products = productRepository.save(product);
        return products;
    }

    @Override
    public Product findByID(Long id) {
        if(productRepository.findById(id).isPresent())
             return productRepository.findById(id).get();
        else return null;
    }

    @Override
    public void deleteByID(Long id) {
         productRepository.deleteById(id);
    }


}
