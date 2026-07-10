package com.megamart.megamart.service;

import com.megamart.megamart.entity.Product;
import com.megamart.megamart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
    return productRepository.findById(id).orElse(null);
}

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {

    Product existingProduct = productRepository.findById(id).orElse(null);

    if (existingProduct != null) {
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setImage(product.getImage());

        return productRepository.save(existingProduct);
    }

    return null;
}

    public void deleteProduct(Long id) {
    productRepository.deleteById(id);
}
}
