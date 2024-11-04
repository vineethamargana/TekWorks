package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
    private ProductRepository productRepository;
 
    // Get all products
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
 
    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    // Create a new product
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
 
    // Update a product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> product = productRepository.findById(id);
 
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            updatedProduct.setName(productDetails.getName());
            updatedProduct.setDescription(productDetails.getDescription());
            updatedProduct.setPrice(productDetails.getPrice());
            return ResponseEntity.ok(productRepository.save(updatedProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
 
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
