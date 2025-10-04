package com.him.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.him.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
