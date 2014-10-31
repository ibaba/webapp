package com.spring.model.permission;

import org.springframework.stereotype.Repository;

import com.spring.config.generic.persistence.Dao;

@Repository
public class PermissionDao extends Dao<Permission> {

	public PermissionDao() {
		super(Permission.class);
	}
	
}
