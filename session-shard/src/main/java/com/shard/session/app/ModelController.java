package com.shard.session.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

	@RequestMapping(value = "loginView")
	public ModelAndView customer() {
		return new ModelAndView("login", null);
	}
}
