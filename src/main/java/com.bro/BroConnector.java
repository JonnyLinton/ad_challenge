package com.bro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bro.appdirect.entity.AppDirectUser;
import com.bro.appdirect.entity.EventPayload;
import com.bro.appdirect.entity.SubscriptionEvent;
import com.bro.appdirect.entity.SubscriptionResponse;
import com.bro.bro.entity.User;
import com.bro.bro.entity.UserRepo;

@Service
public class BroConnector {
	// Attributes?
	@Autowired
	private UserRepo userRepo;

	public SubscriptionResponse create(SubscriptionEvent createEvent) {
		// TODO: need to build mapper/extractor to get account/user info from the Event?
		AppDirectUser appdirectUser = createEvent.getCreator();
		EventPayload payload = createEvent.getPayload();

		User broUser = new User();
		broUser.setName(appdirectUser.getFirstName() +" " + appdirectUser.getLastName());
		broUser.setEdition(User.Edition.BASIC); // TODO: hardcoded for now
		broUser.setEmail(appdirectUser.getEmail());

		userRepo.save(broUser);

		SubscriptionResponse response = new SubscriptionResponse(true);
		response.setAccountId(appdirectUser.getUuid());

		return response;
	}

	public SubscriptionResponse cancel(SubscriptionEvent cancelEvent) {
		AppDirectUser appdirectUser = cancelEvent.getCreator();
		EventPayload payload = cancelEvent.getPayload();

		User user = userRepo.findOne(payload.getUser().getUuid());
		userRepo.delete(user);

		SubscriptionResponse response = new SubscriptionResponse(true);
		response.setAccountId(appdirectUser.getUuid());

		return response;
	}
}
