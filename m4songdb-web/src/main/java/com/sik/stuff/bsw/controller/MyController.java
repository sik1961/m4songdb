package com.sik.stuff.bsw.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller that gives admin users the chance to see the status of the
 * endpoints and add new agent to the backup area for future use
 * 
 * @author 43182808
 * 
 */
@Controller
public class MyController {

	private static final Logger LOG = Logger.getLogger(MyController.class);

	/**
	 * Get request
	 * 
	 * @return
	 */
	@RequestMapping(value = "mypage.htm", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ModelAndView mypage(@RequestParam final String name,
		@RequestParam(required = false) final String job) {

		final Map<String, Object> view = new HashMap<String, Object>();

		view.put("name", name);
		view.put("job", job);

		return new ModelAndView("myjsp", view);
	}

}