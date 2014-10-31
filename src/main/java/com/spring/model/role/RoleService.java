package com.spring.model.role;

import org.springframework.stereotype.Service;

import com.spring.config.generic.service.basicService;

@Service
public class RoleService extends basicService<Role> {

	public RoleService() {
		super(Role.class);
	}

}
