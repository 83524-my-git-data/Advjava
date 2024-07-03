package com.sunbeam.entities;
import javax.persistence.*;


@Entity

@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Category category;
	
	@Column(name="product_name",length = 25,unique=true)
	private String productname;
	
	@Column(name="price")
	private double price;
	
	@Column(name="available_quantity")
	private int availablequantity;

	public Product() {
		
	}

	public Product(Category category, String productname, double price, int availablequantity) {
		
		this.category = category;
		this.productname = productname;
		this.price = price;
		this.availablequantity = availablequantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public int getAvailablequantity() {
		return availablequantity;
	}

	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productname=" + productname + ", price=" + price
				+ ", availablequantity=" + availablequantity + "]";
	}
	
	
	
	
	
}
