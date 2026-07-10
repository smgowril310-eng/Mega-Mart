package com.megamart.megamart.controller;

import com.megamart.megamart.entity.Product;
import com.megamart.megamart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
public List<Product> getAllProducts() {
    return productService.getAllProducts();
}
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id,
                             @RequestBody Product product) {

    return productService.updateProduct(id, product);
}

    @DeleteMapping("/{id}")
public String deleteProduct(@PathVariable Long id) {

    productService.deleteProduct(id);

    return "Product Deleted Successfully";
}
}