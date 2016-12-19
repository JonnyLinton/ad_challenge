package com.bro.appdirect.entity;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Company {
	private String name;
	private String uuid;
}
