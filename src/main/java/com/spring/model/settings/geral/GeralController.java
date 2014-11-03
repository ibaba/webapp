package com.spring.model.settings.geral;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.config.generic.controller.settingsController;

@Controller
@RequestMapping(value = "Geral")
public class GeralController extends settingsController<Geral> {

	public GeralController() {
		super(Geral.class);
	}

}
