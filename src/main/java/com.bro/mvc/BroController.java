package com.bro.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bro.bro.entity.User;
import com.bro.bro.entity.UserRepo;

@Controller
@RequestMapping(value = "/")
public class BroController {
	private Log LOG = LogFactory.getLog(BroController.class);
	@Autowired
	private UserRepo userRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		map.put("Test", "LJonny");

		Iterable<User> subscriptionList = userRepo.findAll();
		map.put("Subscriptions", subscriptionList);

		return "home";
	}
}
