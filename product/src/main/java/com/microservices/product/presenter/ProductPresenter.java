package com.microservices.product.presenter;

import com.microservices.product.entity.Product;
import com.microservices.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProductPresenter {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("products")
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping("/products")
    public Product createNewProduct(@RequestBody Product product) {
        return productService.createNewProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProductById(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
