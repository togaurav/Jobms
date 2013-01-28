package com.ganshar.user.model;

import java.util.Date;

public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String email;
	private String password;
	private Date addTime;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String email, String password, Date addTime) {
		this.email = email;
		this.password = password;
		this.addTime = addTime;
	}

	/** full constructor */
	public User(String name, String email, String password, Date addTime) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.addTime = addTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}