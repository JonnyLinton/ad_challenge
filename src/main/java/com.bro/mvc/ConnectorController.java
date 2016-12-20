package com.bro.mvc;

import static org.springframework.http.ResponseEntity.ok;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bro.BroConnector;
import com.bro.appdirect.entity.SubscriptionEvent;
import com.bro.appdirect.entity.SubscriptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;

@Controller
public class ConnectorController {

	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private BroConnector broConnector = new BroConnector();

	@RequestMapping(value = "/api/v1/integration/processEvent", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<SubscriptionResponse> processEvent(@RequestParam String eventUrl) {
		if (eventUrl.isEmpty()) { // return a failure
			SubscriptionResponse failure = SubscriptionResponse.failure();
			failure.setErrorCode("UNKNOWN_ERROR");
			return ResponseEntity.badRequest().body(failure);
		}

		SubscriptionEvent event = null;
		try {
			event = fetchEvent(eventUrl);
		} catch (Exception e) {
			// TODO: handle this somehow
			e.printStackTrace();
			System.exit(1);
		}

		SubscriptionResponse response = broConnector.handleEvent(event);
		return ok(response);
	}

	private SubscriptionEvent fetchEvent(String eventUrl) throws Exception {
		// httpclient -- signed fetch
		OAuthConsumer consumer = new DefaultOAuthConsumer("tinyapp-140704", "r0BP3MUapttUw9Ij");
		URL url = new URL(eventUrl);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		consumer.sign(request);
		request.connect();

		String event;
		try (Scanner scanner = new Scanner(request.getInputStream()).useDelimiter("\\A")) {
			event = scanner.hasNext() ? scanner.next() : "";
		}
		System.out.println(event);

		return objectMapper.readValue(event, SubscriptionEvent.class);
	}
}
