package com.microservices.product.service;

import com.microservices.product.entity.Product;
import com.microservices.product.repository.ProductRepository;
import com.microservices.product.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id : " + id));
    }

    @Override
    @Transactional
    public Product createNewProduct(Product payload) {
        return productRepository.save(payload);
    }

    @Override
    @Transactional
    public Product updateProductById(Long id, Product payload) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id : " + id));

        productById.setName(payload.getName());
        productById.setDescription(payload.getDescription());
        productById.setStock(payload.getStock());

        productRepository.save(productById);

        return productById;
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id : " + id));

        productRepository.delete(productById);
    }
}
