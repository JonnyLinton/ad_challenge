package com.bro.appdirect.entity;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class SubscriptionEvent {
	private AppDirectUser creator;
	private EventFlag flag;
	private EventPayload payload;
	private String type;
}
