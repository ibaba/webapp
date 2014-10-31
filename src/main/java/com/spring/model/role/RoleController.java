package com.spring.model.role;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.config.generic.controller.basicController;

@Controller
@RequestMapping(value = "Role")
public class RoleController extends basicController<Role> {

	public RoleController() {
		super(Role.class);
	}

}
