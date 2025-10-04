package com.him.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.him.exception.ResourceNotFound;
import com.him.model.Customer;
import com.him.repo.CustomerRepo;
import com.him.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo repo;
	
	@Override
	public Customer createCustomer(Customer cus) {
		Customer save = this.repo.save(cus);
		return save;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> findAll = this.repo.findAll();
		return findAll;
	}

	@Override
	public Customer getSingleCustomer(Integer id) {
		Customer singlecustomer = this.repo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer Not Found"));
		return singlecustomer;
	}

	@Override
	public Customer updateCustomer(Integer id, Customer cus) {
		Customer updatecustomer = this.repo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer Not Found"));
		if(updatecustomer.getCid()==id) {
			updatecustomer.setName(cus.getName());
			updatecustomer.setContactnumber(cus.getContactnumber());
		}
		Customer update = this.repo.save(updatecustomer);
		return update;
	}

	@Override
	public void deleteCustomer(Integer id) {
		Customer deletecustomer = this.repo.findById(id).orElseThrow(() -> new ResourceNotFound("Customer Not Found"));
		this.repo.delete(deletecustomer);
	}

}
