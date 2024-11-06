package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.ProductEntity;
import com.example.product.respone.ResponseMessage;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	 @Autowired
	    private ProductService productService;

	    @PostMapping
	    public ResponseMessage saveProduct(@RequestBody ProductEntity product) {
	        return productService.saveProduct(product);
	    }
	   
	    @PutMapping("/{id}")
	    public ResponseMessage updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
	        return productService.updateProduct(id, product);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseMessage deleteProduct(@PathVariable Long id) {
	        return productService.deleteProduct(id);
	    }

	    @GetMapping("/{id}")
	    public ProductEntity getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }
	    


}
