package com.sik.stuff.bsw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sik.stuff.bsw.controller.ExceptionController;
import com.sik.stuff.bsw.controller.MyController;

/**
 * The context that ties it all together. Brings in all of the required context
 * configurations to have the web app run correctly
 * 
 * @author 43182808
 * 
 */
@Configuration
@EnableWebMvc
public class MyWebappContextConfiguration {

	/**
	 * Used by dispatcher servlet to map the ModelAndView to an actual jsp
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/app/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/**
	 * Give spring a controller to use
	 * 
	 * @return
	 */
	@Bean
	public MyController myController() {
		return new MyController();
	}

	/**
	 * Define Exception controller
	 * 
	 * @return
	 */
	@Bean
	public ExceptionController exceptionController() {
		return new ExceptionController();
	}

}