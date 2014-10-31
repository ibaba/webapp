package com.spring.model.permission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.config.generic.controller.basicController;

@Controller
@RequestMapping(value = "Permission")
public class PermissionController extends basicController<Permission> {

	public PermissionController() {
		super(Permission.class);
	}

}
