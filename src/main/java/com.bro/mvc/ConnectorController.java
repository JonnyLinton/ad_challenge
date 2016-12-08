package com.bro.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConnectorController {
	private Log LOG = LogFactory.getLog(BroController.class);

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String create(ModelMap map) {

	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(ModelMap map) {

	}
}
