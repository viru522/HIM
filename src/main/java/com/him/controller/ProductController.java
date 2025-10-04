package com.him.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.him.model.Product;
import com.him.response.ApiResponse;
import com.him.service.ProductService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/createProduct")
	public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody Product pro){
		Product createProduct = this.service.createProduct(pro);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Product created.",true),HttpStatus.CREATED);
	}
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> allProduct = this.service.getAllProduct();
		return new ResponseEntity<List<Product>>(allProduct,HttpStatus.OK);
	}
	@GetMapping("/getSingleProduct/{id}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("id")Integer id){
		Product singleProduct = this.service.getSingleProduct(id);
		return new ResponseEntity<Product>(singleProduct, HttpStatus.OK);
	}
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<ApiResponse> updateProduct(@Valid @RequestBody Product pro,@PathVariable("id")Integer id){
		Product updateProduct = this.service.updateProduct(id, pro);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Product updated.",true),HttpStatus.OK);
	}
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("id")Integer id){
		this.service.deleteProduct(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Product deleted.",true),HttpStatus.OK);
	}
}
