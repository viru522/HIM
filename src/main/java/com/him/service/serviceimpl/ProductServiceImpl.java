package com.him.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.him.exception.ResourceNotFound;
import com.him.model.Product;
import com.him.repo.ProductRepo;
import com.him.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;

	@Override
	public Product createProduct(Product pro) {
		Product save = this.repo.save(pro);
		return save;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> findAll = this.repo.findAll();
		return findAll;
	}

	@Override
	public Product getSingleProduct(Integer id) {
		Product singleproduct = this.repo.findById(id).orElseThrow(() -> new ResourceNotFound("Product Not Found"));
		return singleproduct;
	}

	@Override
	public Product updateProduct(Integer id, Product pro) {
		Product updateproduct = this.repo.findById(id).orElseThrow(() -> new ResourceNotFound("Product Not Found"));
		if (updateproduct.getId() == id) {
			updateproduct.setProductname(pro.getProductname());
			updateproduct.setPrice(pro.getPrice());
			updateproduct.setQuantity(pro.getQuantity());
			updateproduct.setUrl(pro.getUrl());
			
		}
		Product update = this.repo.save(updateproduct);
		return update;
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product = this.repo.findById(id).orElseThrow(() -> new ResourceNotFound("Product Not Found"));
		this.repo.delete(product);

	}

}
