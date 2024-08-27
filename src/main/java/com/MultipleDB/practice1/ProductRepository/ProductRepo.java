package com.MultipleDB.practice1.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MultipleDB.practice1.ProductEntity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
