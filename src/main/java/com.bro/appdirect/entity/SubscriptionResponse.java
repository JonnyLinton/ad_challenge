package com.bro.appdirect.entity;

import lombok.Data;

@Data
public class SubscriptionResponse {
	private boolean success;
	private String errorCode;
	private String accountId;

	public SubscriptionResponse(boolean success) {
		this.success = success;
	}

	public static SubscriptionResponse success(String message) {
		return new SubscriptionResponse(true);
	}
	public static SubscriptionResponse failure() {
		return new SubscriptionResponse(false);
	}
}
