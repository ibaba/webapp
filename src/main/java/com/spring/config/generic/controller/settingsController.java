package com.spring.config.generic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.config.generic.service.settingsService;

public class settingsController<E> {
	
	@Autowired
	private settingsService<E> serv;

	protected Class<?> clazz;
	
	public settingsController(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping(value = "insert", method=RequestMethod.POST)
	@ResponseBody
	public void insert(@ModelAttribute("object") E object, BindingResult result) throws Exception {
		serv.create_properties(object);
	}
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	@ResponseBody
	public void update(@ModelAttribute("object") E object, BindingResult result) throws Exception {
		System.out.println("settingsController | object -> "+object);
		serv.save_properties(object);
	}
	
	@RequestMapping(value = "delete", method=RequestMethod.POST)
	@ResponseBody
	public void delete(@ModelAttribute("object") E object, BindingResult result) throws Exception {
		serv.delete_properties(object);
	}
	
	public String getName() {
		return clazz.getSimpleName();
	}
	
}
