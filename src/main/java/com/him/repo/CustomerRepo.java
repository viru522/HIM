package com.him.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.him.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
