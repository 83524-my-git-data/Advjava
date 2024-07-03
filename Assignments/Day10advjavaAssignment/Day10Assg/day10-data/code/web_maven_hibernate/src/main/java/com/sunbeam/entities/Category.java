package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;
	private String description;
	/*
	 * @OneToMany - mandatory (otherwise MappingException) If mappedBy is NOT
	 * specified in a bi dir asso(one-many) hibernate creates additional table
	 * 
	 * Default value of the cascade property=NONE ! i.e none of the operations will
	 * be cascaded from src -> target entity To specify - on save , update n delete
	 * use CascadeType.ALL
	 * 
	 */
	@OneToMany(mappedBy = "productCategory", 
			cascade = CascadeType.ALL)
	// Category 1--->* Product (multiple products can be added under 1 category)
	private List<Product> products = new ArrayList<>();

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	/*
	 * add helper method to establish bi dir association 
	 * between Category n Product
	 */
	public void addProduct(Product product)
	{
		//parent(Category) --> child(Product)
		this.products.add(product);
		//child --> parent
		product.setProductCategory(this);
	}

	@Override
	public String toString() {
		return "Category ID " + getId() + " [name=" + name + ", description=" + description + "]";
	}

}
