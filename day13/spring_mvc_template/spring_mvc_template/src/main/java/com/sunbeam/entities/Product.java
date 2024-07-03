package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;
	private double price;
	@Column(name = "available_qty")
	private int availableQty;
	// Product *-->1 Category (many - to - one)
	@ManyToOne // Mandatory , otherwise MappingException
	// optional BUT recommended , to specify name 
	//of FK column n adding NOT NULL  constraint
	@JoinColumn(name = "category_id", nullable = false)
	private Category productCategory;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double price, int availableQty) {
		super();
		this.name = name;
		this.price = price;
		this.availableQty = availableQty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product ID " + getId() + " [name=" + name + ", price=" + price + ", availableQty=" + availableQty + "]";
	}

}
