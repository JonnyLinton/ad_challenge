package com.bro.bro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "bros")
public class User {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2") // maybe just do numeric? 1,2,3,4...
	@Column(name = "id", unique = true)
	private String id; 
	@Column(name = "name")
	private String name;
	@Column(name = "email", unique = true)
	private String email;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "edition")
	private Edition edition;

	public enum Edition {
		BASIC
	}
}
