package com.bro.bro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Column(name = "name")
	private String name;
	@Column(name = "id", unique = true)
	private String id; // TODO: will this value come from the MarketPlace?
	@Column(name = "email", unique = true)
	private String email;

	//TODO: Do I need to link Account and User?
}
