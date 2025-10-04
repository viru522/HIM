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

import com.him.model.Customer;
import com.him.response.ApiResponse;
import com.him.service.CustomerService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<ApiResponse> createCustomer(@Valid @RequestBody Customer cus){
		Customer createCustomer = this.service.createCustomer(cus);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer created successfully",true),HttpStatus.CREATED);
	}
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> allCustomer = this.service.getAllCustomer();
		return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.OK);
	}
	@GetMapping("/getSingleCustomer/{id}")
	public ResponseEntity<Customer> getSingleCustomer(@Valid @PathVariable("id")Integer id){
		Customer singleCustomer = this.service.getSingleCustomer(id);
		return new ResponseEntity<Customer>(singleCustomer,HttpStatus.OK);
	}
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<ApiResponse> updateCustomer(@Valid @PathVariable("id")Integer id,Customer cus){
		Customer updateCustomer = this.service.updateCustomer(id, cus);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer updated successfully",true),HttpStatus.CREATED);
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@Valid @PathVariable("id")Integer id){
		this.service.deleteCustomer(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Customer deleted successfully",true),HttpStatus.CREATED);
	}
}
