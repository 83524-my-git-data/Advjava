package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Product extends BaseEntity {
	@Column(length = 20, unique = true)
	private String product_name;
	private double price;
	@Column(name = "available_qty")
	private int availableQty;
	// Product *-->1 Category (many - to - one)
	//@ManyToOne // Mandatory , otherwise MappingException
	// optional BUT recommended , to specify name 
	//of FK column n adding NOT NULL  constraint
	//@JoinColumn(name = "category_id", nullable = false)
	//private Category productCategory;
	public Product(String product_name, double price, int availableQty) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.availableQty = availableQty;
	}
	
	

}
