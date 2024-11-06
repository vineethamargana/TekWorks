package com.example.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.entity.ProductEntity;

public interface ProductRepo  extends JpaRepository<ProductEntity,Long>{

}
