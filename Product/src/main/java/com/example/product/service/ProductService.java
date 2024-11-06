package com.example.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.custom.ProductNotFoundException;
import com.example.product.entity.ProductEntity;
import com.example.product.repo.ProductRepo;
import com.example.product.respone.ResponseMessage;

@Service
public class ProductService {
	

    @Autowired
    private ProductRepo productRepo;
    
    public ResponseMessage saveProduct(ProductEntity product) {
        productRepo.save(product);
        return ResponseMessage.success(); // Calls the success message
    }
    
    public ResponseMessage updateProduct(Long id, ProductEntity product) {
        Optional<ProductEntity> existingProduct = productRepo.findById(id);
        if (existingProduct.isPresent()) 
        {
            existingProduct.get().setName(product.getName());
            existingProduct.get().setPrice(product.getPrice());
            productRepo.save(existingProduct.get());
            return ResponseMessage.success(); 
        } 
        else {
            return ResponseMessage.failure();
        }
    }
    
    public ResponseMessage deleteProduct(Long id) {
        Optional<ProductEntity> product = productRepo.findById(id);
        if (product.isPresent()) 
        {
            productRepo.deleteById(id);
            return ResponseMessage.success(); 
        }
        else 
        {
            return ResponseMessage.failure(); 
        }
    }
   
    public ProductEntity getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }

}
