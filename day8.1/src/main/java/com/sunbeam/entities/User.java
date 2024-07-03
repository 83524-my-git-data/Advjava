package com.sunbeam.entities;

import java.time.LocalDate;
import javax.persistence.*;

/*
 * column - id , first name , last name, email ,password , 
 * dob , registration amount ,role ,image 

 */
@Entity // to tell hibernate , following is a entity class , whose life cycle has to be
		// managed by hibernate
@Table(name="users") //to specify table name
public class User {
	// Till hibernate 5.x , it's MANDATORY
	// to create id property - Serializable (i/f)
	@Id //constraint : PK , not null 
	 //=> for auto. id generation , using auto increment feature 
	//, BEST suited for Mysql
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name",length = 25)//col name , varchar(25)
	private String firstName;
	@Column(name="last_name",length = 25)//col name , varchar(25)
	private String lastName;
	@Column(length = 20,unique=true)//varchar(20), unique constraint
	private String email;
	@Column(length = 25,nullable = false) //NOT NULL
	private String password;
	private LocalDate dob;
	@Column(name="reg_amount")
	private double regAmount;
	@Enumerated(EnumType.STRING) //col type : varchar
	@Column(length = 20)
	private Role role;
	@Lob //=> large object , col type : longblob
	private byte[] image;

	// def ctor is MANDATORY
	public User() {
		// TODO Auto-generated constructor stub
	}

	// user reg
	public User(String firstName, String lastName, 
			String email, String password, LocalDate dob, double regAmount,
			Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.regAmount = regAmount;
		this.role = role;
	}

	// getters n setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dob="
				+ dob + ", regAmount=" + regAmount + ", role=" + role + "]";
	}
}
