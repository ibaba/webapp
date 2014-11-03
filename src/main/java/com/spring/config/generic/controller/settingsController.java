package com.spring.config.generic.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.config.generic.service.settingsService;

public class settingsController<E> {
	
	@Autowired
	private settingsService<E> serv;

	protected Class<?> clazz;
	
	public settingsController(Class<?> clazz) {
		this.clazz = clazz;
	}
	
}
