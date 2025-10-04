package com.him.service;

import java.util.List;

import com.him.model.Customer;

public interface CustomerService {

	Customer createCustomer(Customer cus);
	List<Customer> getAllCustomer();
	Customer getSingleCustomer(Integer id);
	Customer updateCustomer(Integer id,Customer cus);
	void deleteCustomer(Integer id);
}
