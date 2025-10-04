package com.him.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.him.model.Product;
import com.him.repo.ProductRepo;

public interface ProductService {

	Product createProduct(Product pro);
	List<Product> getAllProduct();
	Product getSingleProduct(Integer id);
	Product updateProduct(Integer id,Product pro);
	void deleteProduct(Integer id);
}
