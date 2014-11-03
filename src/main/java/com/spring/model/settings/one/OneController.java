package com.spring.model.settings.one;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.config.generic.controller.settingsController;

@Controller
@RequestMapping(value = "One")
public class OneController extends settingsController<One> {

	public OneController() {
		super(One.class);
	}

}
