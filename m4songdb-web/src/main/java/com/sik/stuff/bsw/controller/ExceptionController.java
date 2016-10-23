package com.sik.stuff.bsw.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Generic Exception Handler Controller
 * 
 * @author 04827058
 * 
 */
@ControllerAdvice
public class ExceptionController {

	private static final Logger LOG = Logger.getLogger(ExceptionController.class);

	/**
	 * Handle all exceptions and display message via default error page.
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(final Exception exception) {
		LOG.warn("Exception handler intercepted: ", exception);
		return new ModelAndView("../../errors/error").addObject("message", exception.getMessage());
	}
}