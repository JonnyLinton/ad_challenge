package com.bro.appdirect.entity;

import lombok.Data;

@Data
public class EventPayload {
	private AppDirectUser user;
	private Company company;
	private Order order;
	private Subscription subscription;
}
