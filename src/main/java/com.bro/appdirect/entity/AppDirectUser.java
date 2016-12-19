package com.bro.appdirect.entity;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class AppDirectUser {
	private String firstName;
	private String lastName;
	private String uuid;
	private String email;
}
