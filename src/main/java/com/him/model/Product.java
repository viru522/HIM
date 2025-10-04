package com.him.model;

import java.sql.Date;

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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Product Name required")
	private String productname;
	@NotNull(message = "Product Price required")
	@Range(min = (long) 0.0, max = (long) 10000000.0 )
	private double price;
	@ManyToOne
	@JoinColumn(name = "quantity")
	@NotNull(message = "Product Quantity required")
	@Range(min = (long) 1.0, max = (long) 100.0 )
	private double quantity;
	
	private String url;
	public Product() {
		super();
	}
	public Product(int id, String productname, double price, double quantity, String url) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
