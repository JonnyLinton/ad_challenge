package com.bro.appdirect.entity;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class EventPayload {
	private AppDirectUser user;
	private Company company;
	private Order order;
	private Subscription subscription;
}
