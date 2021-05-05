package cart.controller;

import cart.model.Product;
import cart.service.Impl.ProductServiceImpl;
import jdk.nashorn.internal.runtime.URIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProduct(){
        List<Product> products = productServiceImpl.allProduct();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping("/add")
    public ResponseEntity<?> newProduct(@RequestBody Product product){
        Product products = productServiceImpl.add(product);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updataProduct(@RequestBody Product product){
        Product products = productServiceImpl.update(product);
        return  ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        Product products = productServiceImpl.findByID(id);
        if(products==null)
            return ResponseEntity.badRequest().body("The data is no product an id equal " + id);
             productServiceImpl.deleteByID(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product is deleted successfully");
    }




}
