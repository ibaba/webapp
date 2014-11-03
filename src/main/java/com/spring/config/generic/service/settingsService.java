package com.spring.config.generic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class settingsService<E> {
	
	@Autowired
	private Environment env;

	protected Class<?> clazz;
	
	public settingsService(Class<?> clazz) {
		this.clazz = clazz;
	}
	
}
