package com.bro.mvc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class BroController {
	private Log LOG = LogFactory.getLog(BroController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		map.put("Test", "LJonny");

		List<String> subscriptionList = new ArrayList<>();
		subscriptionList.add("Sub1");
		subscriptionList.add("Sub2");
		subscriptionList.add("Sub3");
		subscriptionList.add("Sub4");
		map.put("Subscriptions", subscriptionList);

		return "home";
	}

}
