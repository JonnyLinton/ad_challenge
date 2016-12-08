package com.bro.appdirect.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SubscriptionResponse {
	private String success;
	@Setter
	private String errorCode;
	@Setter
	private String accountId;

	private SubscriptionResponse(String success) {
		this.success = success;
	}

	public static SubscriptionResponse success() {
		return new SubscriptionResponse("success");
	}

	public static SubscriptionResponse failure() {
		return new SubscriptionResponse("failure");
	}
}
