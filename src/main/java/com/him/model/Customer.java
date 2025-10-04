package com.him.model;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@NotEmpty(message = "Name required.")
	private String name;
	@NotEmpty(message = "Contact number required.")
	private String contactnumber;
	@NotEmpty(message = "Product name required.")
	private String productname;
	@ManyToOne
	@JoinColumn(name = "quantity")
	@NotNull(message = "Product Quantity required")
	@Range(min = (long) 1.0, max = (long) 100.0 )
	private double quantity;
	@NotNull(message = "Product Price required")
	@Range(min = (long) 0.0, max = (long) 100000.0 )
	private Double price;
	public Customer() {
		super();
	}
	
	
	
	public Customer(int cid, @NotEmpty(message = "Name required.") String name,
			@NotEmpty(message = "Contact number required.") String contactnumber,
			@NotEmpty(message = "Product name required.") String productname,
			@NotNull(message = "Product Quantity required") @Range(min = 1, max = 100) double quantity,
			@NotNull(message = "Product Price required") @Range(min = 0, max = 100000) Double price) {
		super();
		this.cid = cid;
		this.name = name;
		this.contactnumber = contactnumber;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
	}



	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
}
