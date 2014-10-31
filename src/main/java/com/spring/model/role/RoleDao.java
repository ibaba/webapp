package com.spring.model.role;

import org.springframework.stereotype.Repository;

import com.spring.config.generic.persistence.Dao;

@Repository
public class RoleDao extends Dao<Role> {

	public RoleDao() {
		super(Role.class);
	}
	
}
