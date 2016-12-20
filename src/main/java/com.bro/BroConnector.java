package com.bro;

import static com.bro.bro.entity.User.Edition.BASIC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bro.appdirect.entity.AppDirectUser;
import com.bro.appdirect.entity.SubscriptionEvent;
import com.bro.appdirect.entity.SubscriptionResponse;
import com.bro.bro.entity.User;
import com.bro.bro.entity.UserRepo;

@Service
public class BroConnector {
	@Autowired
	private UserRepo userRepo;

	public SubscriptionResponse handleEvent(SubscriptionEvent event) {
		switch (event.getType()) {
			case ("SUBSCRIPTION_ORDER"):
				return create(event);
			case ("SUBSCRIPTION_CANCEL"):
				return cancel(event);

			default:
				throw new RuntimeException("Could not find event Type = { " + event.getType() + " }");
		}
	}

	public SubscriptionResponse create(SubscriptionEvent createEvent) {
		AppDirectUser appdirectUser = createEvent.getCreator();

		User broUser = new User();
		broUser.setName(appdirectUser.getFirstName() + " " + appdirectUser.getLastName());
		broUser.setEdition(BASIC); // TODO: hardcoded for now
		broUser.setEmail(appdirectUser.getEmail());

		userRepo.save(broUser);

		SubscriptionResponse response = new SubscriptionResponse(true);
		response.setAccountId(appdirectUser.getUuid());

		return response;
	}

	public SubscriptionResponse cancel(SubscriptionEvent cancelEvent) {
		String id = cancelEvent.getPayload().getAccount().getAccountIdentifier();
		User user = userRepo.findOne(id);
		userRepo.delete(user);

		SubscriptionResponse response = SubscriptionResponse.success();
		response.setAccountId(id); //TODO: correct id?

		return response;
	}
}
