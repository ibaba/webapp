package com.spring.model.permission;

import org.springframework.stereotype.Service;

import com.spring.config.generic.service.basicService;

@Service
public class PermissionService extends basicService<Permission> {

	public PermissionService() {
		super(Permission.class);
	}

}
