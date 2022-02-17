package com.microservices.product.service;

import com.microservices.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product createNewProduct(Product payload);
    Product updateProductById(Long id, Product payload);
    void deleteProductById(Long id);
}
