package com.bro;

import lombok.AllArgsConstructor;

import com.bro.appdirect.entity.SubscriptionEvent;
import com.bro.appdirect.entity.SubscriptionResponse;

@AllArgsConstructor
public class BroConnector {
	// Attributes?

	public SubscriptionResponse create(SubscriptionEvent createEvent) {
		// TODO: need to build mapper/extractor to get account/user info from the Event?
		// TODO: need to be able to persist values
	}

	public SubscriptionResponse cancel(SubscriptionEvent cancelEvent) {

	}

}
